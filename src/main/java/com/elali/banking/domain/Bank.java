package com.elali.banking.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 27/10/13
 * Time: 22:14
 */

@Entity
@Table(name = "BANK")
public class Bank extends DomainObject<Integer> {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
