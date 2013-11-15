package com.elali.banking.io.bankin;

import com.elali.banking.AbstractIntegration;
import com.elali.banking.io.html.Importer;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 11/11/13
 * Time: 14:19
 */
public class HtmlImporterTest extends AbstractIntegration {
    @Resource(name = "htmlImporter")
    protected Importer importer;

    @Test
    @Rollback(false)
    public void testParse() throws Exception {
        importer.handle(getFile("data/bankin/bred.html"));
        importer.handle(getFile("data/bankin/ing.html"));
        importer.handle(getFile("data/bankin/bnp.html"));
    }


}
