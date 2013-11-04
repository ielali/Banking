package com.elali.banking.dao;

import com.elali.banking.AbstractIntegration;
import com.elali.banking.domain.Account;
import com.elali.banking.domain.Bank;
import com.elali.banking.domain.SubCategory;
import com.elali.banking.domain.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 02/11/13
 * Time: 23:45
 */
public class RepositoryTest extends AbstractIntegration {

    @Test
    public void testFind() throws Exception {
        Account account = repository.find(Account.class, 0);
        assertNotNull(account);
    }

    @Test
    public void testFindBy() throws Exception {
        List<Account> accounts = repository.findBy(Account.class, "name", "Compte De Chèques A venir");
        assertNotNull(accounts);
        Assert.assertEquals(1, accounts.size());
        Account account = accounts.get(0);
        assertNotNull(account);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Bank> banks = repository.findAll(Bank.class);
        assertNotNull(banks);
        assertEquals(3, banks.size());
    }

    @Test
    public void testPersist() throws Exception {
        Transaction transaction = new Transaction();
        transaction.setAccount(repository.find(Account.class, 0));
        transaction.setAmount(new BigDecimal(12.3));
        transaction.setIncluded(true);
        transaction.setRelativeMonth(0);
        transaction.setSubCategory(repository.find(SubCategory.class, 1));
        transaction.setCreationDate(new Date());
        transaction.setName("New Transaction");
        transaction.setDescription("New Description");
        transaction.setActive(true);
        repository.persist(transaction);

        assertNotNull(transaction.getId());
        Transaction savedTransaction = repository.find(Transaction.class, transaction.getId());
        assertNotNull(savedTransaction.getAccount());
        assertNotNull(savedTransaction.getSubCategory());
    }
}
