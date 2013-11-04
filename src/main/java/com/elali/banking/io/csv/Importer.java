package com.elali.banking.io.csv;

import com.elali.banking.dao.Repository;
import com.elali.banking.domain.Account;
import com.elali.banking.domain.SubCategory;
import com.elali.banking.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.StrReplace;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormatSymbols;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 03/11/13
 * Time: 00:45
 */
@Component
public class Importer {
    @Autowired
    Repository repository;

    public void handle(File file) throws IOException {
        ICsvBeanReader beanReader = null;
        try {
            beanReader = new CsvBeanReader(new FileReader(file), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

            // the header elements are used to map the values to the bean (names must match)
            beanReader.getHeader(true);
            final String[] header = new String[]{"creationDate", "name", "account", "amount", null, "subCategory", "description"};
            final CellProcessor[] processors = getProcessors();

            Set<Account> accounts = new HashSet<Account>();
            Transaction transaction;
            while ((transaction = beanReader.read(Transaction.class, header, processors)) != null) {
                repository.persist(transaction);
                Account account = transaction.getAccount();
                account.setBalance(account.getBalance().add(transaction.getAmount()));
                accounts.add(account);
            }
            for (Account account : accounts) {
                repository.persist(account);
            }

        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
        }


    }

    /**
     * Sets up the processors used for the examples. There are 10 CSV columns, so 10 processors are defined. Empty
     * columns are read as null (hence the NotNull() for mandatory columns).
     *
     * @return the cell processors
     */
    private CellProcessor[] getProcessors() {


        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new ParseDate("dd/MM/yyyy")), // creation date
                new NotNull(), // name
                new NotNull(new LookUp<Account>(repository, Account.class, "name")), // acco()unt
                new NotNull(new StrReplace("[[0-9]&&,]", "", new ParseBigDecimal(new DecimalFormatSymbols(Locale.FRANCE)))), // amount
                new Optional(), // category
                new NotNull(new LookUp<SubCategory>(repository, SubCategory.class, "name")), // sub categroy
                new Optional(), // description
        };

        return processors;
    }

}
