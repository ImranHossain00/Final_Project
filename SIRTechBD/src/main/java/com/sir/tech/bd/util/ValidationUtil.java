package com.sir.tech.bd.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Map;
import java.util.stream.Collectors;

// This is an example of Singleton Pattern
public class ValidationUtil {

    private static final ValidationUtil INSTANCE
            = new ValidationUtil();

    private final Validator validator;

    private ValidationUtil() {
        var validatorFactory
                = Validation.buildDefaultValidatorFactory();
        this.validator
                = validatorFactory.getValidator();
    }

    public static ValidationUtil getInstance() {
        return INSTANCE;
    }
    public <T>Map<String, String> validate(T obj) {
        var violations = validator.validate(obj);

        return violations
                .stream()
                .collect(Collectors.toMap(
                        violation ->
                                violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage,
                        (eMsg1, eMsg2) -> eMsg1 + " <br/> " + eMsg2
                ));
    }
}
