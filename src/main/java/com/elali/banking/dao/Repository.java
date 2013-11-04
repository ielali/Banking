package com.elali.banking.dao;

import com.elali.banking.domain.DomainObject;
import org.apache.commons.lang.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 10/23/13
 * Time: 2:36 AM
 */
@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager entityManager;

    public <T extends DomainObject> T find(Class<T> clazz, Serializable id) {
        return entityManager.find(clazz, id);
    }

    public <T extends DomainObject> List<T> findBy(Class<T> clazz, String propertyName, Serializable value) {
        return entityManager.createQuery(String.format("from %s x where x.%s=:%s", clazz.getName(), propertyName, propertyName))
                .setParameter(propertyName, value)
                .getResultList();
    }

    public <T extends DomainObject> List<T> findByIgnoreCase(Class<T> clazz, String propertyName, String value) {
        return entityManager.createQuery(String.format("from %s x where lower(x.%s)=:%s", clazz.getName(), propertyName, propertyName))
                .setParameter(propertyName, StringUtils.lowerCase(value))
                .getResultList();
    }

    public <T extends DomainObject> List<T> findAll(Class<T> clazz) {
        return entityManager.createQuery(String.format("from  %s x", clazz.getName())).getResultList();
    }

    public <T extends DomainObject> void persist(T domainObject) {
        entityManager.persist(domainObject);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
