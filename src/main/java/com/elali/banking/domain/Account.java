package com.elali.banking.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 27/10/13
 * Time: 22:14
 */

@Entity
@Table(name = "ACCOUNT")
public class Account extends DomainObject<Integer> {
    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;
    @Column(name = "BALANCE", scale = 2, precision = 15)
    private BigDecimal balance = new BigDecimal(0);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Transaction> transactions;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank group) {
        this.bank = group;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
