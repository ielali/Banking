package com.elali.banking;

import com.elali.banking.dao.Repository;
import com.elali.banking.domain.DomainObject;

import javax.annotation.Resource;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.Map;

import static risible.util.ClassUtils.getParameterizedTypes;

/**
 * Created with IntelliJ IDEA.
 * User: Imad
 * Date: 10/15/13
 * Time: 1:07 PM
 */
@Named("typeConverter")
public class TypeConverter extends risible.core.TypeConverter {
    @Resource
    Repository repository;

    @Override
    public Object convertValue(Map context, Object target, Member member, String propertyName, Object value, Class toType) {
        String stringValue = toSingleString(value);
        if (DomainObject.class.isAssignableFrom(toType)) {
            Class domainObjectIdType = (Class) (getParameterizedTypes(toType)[0]);
            Serializable id = (Serializable) convertPrimitives(propertyName, domainObjectIdType, stringValue);
            DomainObject object = repository.find(toType, id);
            if (object == null) {
                try {
                    object = (DomainObject) toType.newInstance();
                    object.setId(id);
                    return object;
                } catch (InstantiationException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            return null;
        }
        return super.convertValue(context, target, member, propertyName, value, toType);
    }
}
