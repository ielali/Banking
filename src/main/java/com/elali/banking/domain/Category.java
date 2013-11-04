package com.elali.banking.domain;


import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 27/10/13
 * Time: 22:14
 */

@Entity
@Table(name = "CATEGORY")
public class Category extends DomainObject<Integer> {
    @Column(name = "KEYWORDS")
    private String keywords;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private CategoryType type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<SubCategory> subCategories;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
