package com.bootcamp.casadocodigo.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private String field;
    private Class<?> theClass;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(Unique constraintAnnotation) {
        field = constraintAnnotation.field();
        theClass = constraintAnnotation.theClass();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery(
            "select 1 from " + theClass.getName() + " where " + field + " = :pValue"
        );
        query.setParameter("pValue", obj);
        List<?> list = query.getResultList();
        Assert.state(
                list.size() <= 1,
                "múltiplos atributos " + field + " da classe " + theClass.getName() + "foram encontrados"
        );

        return list.isEmpty();
    }
}
