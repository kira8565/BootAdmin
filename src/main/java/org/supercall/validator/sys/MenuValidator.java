package org.supercall.validator.sys;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.supercall.model.SysMenu;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Repository
public class MenuValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void validate(Object o, Errors errors) {
        SysMenu entity = (SysMenu) o;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();
        Set<ConstraintViolation<SysMenu>> constraintViolations = validator.validate(entity);
        constraintViolations.forEach(e -> {
            errors.rejectValue(e.getPropertyPath().toString(), e.getMessage());
        });
    }
}
