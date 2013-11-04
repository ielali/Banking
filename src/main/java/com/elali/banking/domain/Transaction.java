package com.elali.banking.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 27/10/13
 * Time: 22:14
 */

@Entity
@Table(name = "BANK_TRANSACTION")
public class Transaction extends DomainObject<Integer> {
    @ManyToOne
    @JoinColumn(name = "SUB_CATEGORY_ID")
    private SubCategory subCategory;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @Basic(optional = false)
    @Column(name = "AMOUNT",scale = 2, precision = 15)
    private BigDecimal amount;
    @Column(name = "INCLUDED")
    @Basic(optional = false)
    private Boolean included = true;
    @Column(name = "RELATIVE_MONTH")
    @Basic(optional = false)
    private Integer relativeMonth = 0;

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getIncluded() {
        return included;
    }

    public void setIncluded(Boolean included) {
        this.included = included;
    }

    public Integer getRelativeMonth() {
        return relativeMonth;
    }

    public void setRelativeMonth(Integer relativeMonth) {
        this.relativeMonth = relativeMonth;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "subCategory=" + subCategory +
                ", account=" + account +
                ", amount=" + amount +
                ", included=" + included +
                ", relativeMonth=" + relativeMonth +
                "} " + super.toString();
    }
}
