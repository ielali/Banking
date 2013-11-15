package com.elali.banking.io.csv;

import com.elali.banking.AbstractIntegration;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 03/11/13
 * Time: 12:34
 */
public class CsvImporterTest extends AbstractIntegration {
    @Resource(name = "csvImporter")
    Importer importer;

    @Test
//    @Rollback(false)
    public void testHandle() throws Exception {
        importer.handle(getFile("data/csv/INGDirect-2013-9-utf-8.csv"));
    }

}
