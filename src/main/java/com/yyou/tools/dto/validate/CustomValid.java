package com.yyou.tools.dto.validate;

import com.yyou.tools.dto.CustomValider;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//自定义验证规则
public class CustomValid implements ConstraintValidator<CustomValider,String> {
    @Override
    public void initialize(CustomValider constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isEmpty(s) || !s.startsWith("q");
    }
}
