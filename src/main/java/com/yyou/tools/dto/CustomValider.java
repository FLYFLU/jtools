package com.yyou.tools.dto;

import com.yyou.tools.dto.validate.CustomValid;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValid.class)
public @interface CustomValider {
    String message() default "不在范围内";
    Class[] groups() default {};
    Class[] payload() default {};
}
