package com.elali.banking.io.csv;

import com.elali.banking.AbstractIntegration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 03/11/13
 * Time: 12:34
 */
public class ImporterTest extends AbstractIntegration {
    @Autowired
    Importer importer;

    @Test
//    @Rollback(false)
    public void testHandle() throws Exception {
        importer.handle(new File(getClass().getClassLoader().getResource("data/csv/INGDirect-2013-9-utf-8.csv").getFile()));
    }
}
