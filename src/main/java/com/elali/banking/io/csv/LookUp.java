package com.elali.banking.io.csv;

import com.elali.banking.dao.Repository;
import com.elali.banking.domain.DomainObject;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 03/11/13
 * Time: 12:12
 */
public class LookUp<T extends DomainObject> extends CellProcessorAdaptor implements StringCellProcessor {
    private Repository repository;
    private Class<T> clazz;
    private String propertyName = "id";

    public LookUp(Repository repository, Class<T> clazz) {
        this.repository = repository;
        this.clazz = clazz;
    }

    public LookUp(Repository repository, Class<T> clazz, String propertyName) {
        this.repository = repository;
        this.clazz = clazz;
        this.propertyName = propertyName;
    }

    @Override
    public Object execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);

        if (!(value instanceof Serializable)) {
            throw new SuperCsvCellProcessorException(Serializable.class, value, context, this);
        }
        List<T> list = repository.findByIgnoreCase(clazz, propertyName, (String) value);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        System.out.println(String.format("Lookup [%s] by [%s] using [%s]returned null @ line [%d], column [%d]"
                , clazz.getSimpleName(), propertyName, value, context.getLineNumber(), context.getColumnNumber()));
        return null;
    }
}
