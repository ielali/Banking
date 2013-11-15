package com.elali.banking.io.html;

import com.elali.banking.dao.Repository;
import com.elali.banking.domain.Account;
import com.elali.banking.domain.SubCategory;
import com.elali.banking.domain.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 15/11/13
 * Time: 00:36
 */
@Component("htmlImporter")
public class Importer {
    @Autowired
    Repository repository;

    public void handle(File file) throws Exception {
        Date operationDate = new Date();
        Document doc = Jsoup.parse(file, "UTF-8");
        SimpleDateFormat yearDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.FRANCE);
        SimpleDateFormat monthDateFormat = new SimpleDateFormat("dd MMM", Locale.FRANCE);
        List<String> months = Arrays.asList("jan", "fev", "mar", "avr", "mai", "juin", "juil", "aout", "sept", "oct", "nov", "dec");
        Elements divs = doc.select("div[id^=Account]"); // a with href
        String accountName = trim(doc.select("span.item.active span.bankAccount.notPro").text());
        String accountAmount = trim(doc.select("span.item.active span.bankAmount.notPro").text().replace("€", "").replace(" ", ""));
        List<Account> accounts = repository.findByIgnoreCase(Account.class, "name", accountName);
        Account account = accounts.get(0);
        account.setBalance(new BigDecimal(accountAmount));
        account.setLastUpdateDate(operationDate);
        System.out.println(account.getBalance());
        for (Element div : divs) {
            Transaction transaction = new Transaction();
            transaction.setCreationDate(operationDate);
            transaction.setAccount(account);
            String dateStr = div.select("p.date").text()
                    .trim().toLowerCase()
                    .replace("aout", "août").replace("mar.", "mars")
                    .replace("fev.", "févr.").replace("jan.", "janv.")
                    .replace("dec.", "déc.");
            Date date = null;
            if (dateStr.length() > 0) {
                if (dateStr.length() > 8) {
                    date = yearDateFormat.parse(dateStr);
                } else {
                    date = monthDateFormat.parse(dateStr);
                }
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            transaction.setCreationDate(date);
            transaction.setName(div.select("span.note").text());
            String description = div.select("p.note").text();
            if (!"Cliquer ici pour éditer la note".equals(description)) {
                transaction.setDescription(description);
            }
            transaction.setIncluded(Boolean.valueOf(div.select("#showInApp").attr("value").trim()));
            transaction.setRelativeMonth(months.indexOf(div.select("div.checked").text().trim()) - calendar.get(Calendar.MONTH));
            List<SubCategory> subCategories = repository.findByIgnoreCase(SubCategory.class, "name", div.select("p.type").text().trim());
            if (subCategories != null && subCategories.size() > 0) {
                transaction.setSubCategory(subCategories.get(0));
            }
            transaction.setAmount(new BigDecimal(div.select("p.price").text().replace("€", "").replace(" ", "").trim()));
//            System.out.println(transaction);
            repository.persist(transaction);
        }
        repository.persist(account);
    }

    private String trim(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceAll("\u00a0", "").trim();
    }
}
