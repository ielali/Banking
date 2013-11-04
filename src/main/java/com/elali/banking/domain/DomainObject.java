package com.elali.banking.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 10/15/13
 * Time: 12:47 PM
 *
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class DomainObject<T extends Serializable> implements Serializable {
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID")
    protected T id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;
    @Column(name = "ACTIVE")
    private Boolean active = true;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomainObject)) return false;

        DomainObject that = (DomainObject) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DomainObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
