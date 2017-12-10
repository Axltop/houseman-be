package com.houseman.housemanbe.errors;

import com.houseman.housemanbe.dto.AbstractDTO;
import org.hibernate.validator.internal.engine.path.PathImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

public class LogicRuleViolation<T extends AbstractDTO> implements ConstraintViolation<T> {
    private String message;
    private Path fieldPath;
    private Object invalidValue;
    private Class<T> violationBeanClass;

    public LogicRuleViolation(String errorMessage, String field, Object invalidValue, Class<T> clazz){
        this.message = errorMessage;
        this.fieldPath = PathImpl.createPathFromString(field);
        this.invalidValue = invalidValue;
        this.violationBeanClass = clazz;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getMessageTemplate() {
        return null;
    }

    @Override
    public T getRootBean() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Class<T> getRootBeanClass() {
        return violationBeanClass;
    }

    @Override
    public Object getLeafBean() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] getExecutableParameters() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getExecutableReturnValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Path getPropertyPath() {
        return fieldPath;
    }

    @Override
    public Object getInvalidValue() {
        return invalidValue;
    }

    @Override
    public ConstraintDescriptor<?> getConstraintDescriptor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <U> U unwrap(Class<U> type) {
        // TODO Auto-generated method stub
        return null;
    }
}
