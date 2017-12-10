package com.houseman.housemanbe.controller;

import com.houseman.housemanbe.dto.AbstractDTO;
import com.houseman.housemanbe.errors.LogicRuleViolation;
import com.houseman.housemanbe.errors.ValidationErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api")
public abstract class AbstractRestController<T extends AbstractDTO> {

    public final static int DEFAULT_PAGE_SIZE = 10;
    public final static int DEFAULT_PAGE = 0;

    @Autowired
    private Validator validator;

    @Autowired
    private MessageSource msgSource;

    protected Pageable getPageData(AbstractDTO dto) {
        return this.getPageData(dto, null, null);
    }

    protected Pageable getPageData(AbstractDTO dto, String defaultSortColumn, Sort.Direction defaultDirection) {

        PageRequest pageRequest = null;
        Sort sort = null;

        if (dto != null) {

            int currentPage;
            int pageSize;

            if (dto.getCurrentPage() != null) {
                currentPage = dto.getCurrentPage();
            } else {
                currentPage = DEFAULT_PAGE;
            }

            if (dto.getPageSize() == null) {
                pageSize = -1;
            } else if (dto.getPageSize() > 0) {
                pageSize = dto.getPageSize();
            } else {
                pageSize = DEFAULT_PAGE_SIZE;
            }

            if (dto.getSortColumns() != null) {

                Sort.Direction direction = Sort.Direction.DESC;
                if (dto.isSortAsc()) {
                    direction = Sort.Direction.ASC;
                }
                sort = new Sort(direction, dto.getSortColumns());
            } else {
                if (defaultSortColumn != null && defaultDirection != null) {
                    sort = new Sort(defaultDirection, Arrays.asList(defaultSortColumn));
                }
            }

            if (pageSize > 0) {
                pageRequest = new PageRequest(currentPage, pageSize, sort);
            } else {
                pageRequest = null;
            }
        }

        return pageRequest;
    }

    @SuppressWarnings(value = { "all" })
    protected void validate(T dto) {
        validate(dto, null);
    }

    protected <V extends AbstractDTO> void validateDTO(V dto, Class validationGroup) {

        if (validationGroup == null) {
            validationGroup = Default.class;
        }
        // get JPA constraint violations
        Set<ConstraintViolation<V>> violatins = validator.validate(dto, validationGroup);

        // throw validation exception if errors are found
        if (violatins != null && violatins.size() > 0) {
            throw new ConstraintViolationException(violatins);
        }
    }

    @SuppressWarnings(value = { "all" })
    protected void validate(T dto, Class... validationGroup) {

        if (validationGroup == null) {
            validationGroup = new Class[] { Default.class };
        }
        // get JPA constraint violations
        Set<ConstraintViolation<T>> violatins = validator.validate(dto, validationGroup);

        // get business rules constraint violations
        if (dto != null) {
            Map<String, ValidationErrorMessage> businessErrors = validateLogicRules(dto, validationGroup);

            if (businessErrors != null && !businessErrors.isEmpty()) {

                for (Map.Entry<String, ValidationErrorMessage> entry : businessErrors.entrySet()) {
                    ValidationErrorMessage value = entry.getValue();
                    LogicRuleViolation logicRuleViolation = new LogicRuleViolation(value.getMessage(),
                            entry.getKey(), value.getInvalidValue(), dto.getClass());
                    violatins.add(logicRuleViolation);
                }
            }
        }

        // throw validation exception if errors are found
        if (violatins != null && violatins.size() > 0) {
            throw new ConstraintViolationException(violatins);
        }
    }

    /**
     * Throw single field validation error
     *
     * @param fieldName
     * @param validationMessage
     * @param collisionValue
     * @param clazz
     */
    protected void throwValidationError(String fieldName, String validationMessage, Object collisionValue,
                                        Class clazz) {

        Set<ConstraintViolation<?>> violatins = new HashSet<ConstraintViolation<?>>();
        LogicRuleViolation logicRuleViolation = new LogicRuleViolation(validationMessage, fieldName,
                collisionValue, clazz);
        violatins.add(logicRuleViolation);
        throw new ConstraintViolationException(violatins);
    }

    /*
     * Implement all needed custom business rules validation.
     *
     * @return list of validation errors
     */
    protected abstract Map<String, ValidationErrorMessage> validateLogicRules(T value, Class... validationGroups);
}

