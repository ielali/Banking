package com.elali.banking.controller;

import com.elali.banking.dao.Repository;
import com.elali.banking.domain.Bank;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 03/11/13
 * Time: 20:37
 */
public class Accounts {
    @Autowired
    Repository repository;

    public void list() {

    }

    public List<Bank> getBanks() {
        return repository.findAll(Bank.class);
    }
}
