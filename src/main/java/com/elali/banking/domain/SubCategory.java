package com.elali.banking.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 28/10/13
 * Time: 23:39
 */
@Entity
@Table(name = "SUB_CATEGORY")
public class SubCategory extends DomainObject<Integer> {
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
