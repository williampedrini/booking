package com.ecabs.booking.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.OffsetDateTime;

@Component
class OffsetDateTimeAfterOrEqualNowValidator implements ConstraintValidator<OffsetDateTimeAfterOrEqualNow, OffsetDateTime> {

    @Override
    public void initialize(final OffsetDateTimeAfterOrEqualNow constraintAnnotation) {
    }

    @Override
    public boolean isValid(final OffsetDateTime temporal, final ConstraintValidatorContext context) {
        var now = OffsetDateTime.now();
        return temporal.isAfter(now) || temporal.isEqual(now);
    }
}
