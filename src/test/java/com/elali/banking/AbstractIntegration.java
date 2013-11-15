package com.elali.banking;

import com.elali.banking.dao.Repository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 03/11/13
 * Time: 00:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext-test.xml")
@Transactional
public abstract class AbstractIntegration {
    @Autowired
    protected Repository repository;

    protected File getFile(String name) {
        return new File(getClass().getClassLoader().getResource(name).getFile());
    }
}
