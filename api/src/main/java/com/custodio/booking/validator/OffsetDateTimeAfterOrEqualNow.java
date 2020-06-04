package com.custodio.booking.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.OffsetDateTime;

/**
 * The annotated element must not be before the current date time. Supported types are:
 *
 * <ul>
 * <li>{@link OffsetDateTime}</li>
 * </ul>
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OffsetDateTimeAfterOrEqualNowValidator.class)
public @interface OffsetDateTimeAfterOrEqualNow {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
