package com.elali.banking.service;

import com.elali.banking.dao.Repository;
import com.elali.banking.domain.DomainObject;
import com.elali.banking.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Component
public class UserService {
    @Resource
    Repository repository;

    @Transactional
    public <T extends DomainObject> void persist(T domainObject) {
        repository.persist(domainObject);
    }

    public User findUser(int id) {
        if (id < 0) {
            return null;
        }
        return repository.find(User.class, id);
    }

    public List<User> users() {
        return repository.getEntityManager().createQuery("from com.elali.banking.domain.User user").getResultList();
    }
}
