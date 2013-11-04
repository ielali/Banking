package com.elali.banking.view.freemarker;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 03/11/13
 * Time: 22:08
 */
public class AbbreviateMethod implements TemplateMethodModelEx {
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (arguments != null && arguments.size() >= 2) {
            String str = (String) arguments.get(0);
            Integer count = (Integer) arguments.get(1);
            return StringUtils.abbreviate(str, count);
        }
        return null;
    }
}
