package br.edu.utfpr.pb.pw25s.server.annotation;

import jakarta.validation.Payload;
import jakarta.validation.Constraint;

import java.lang.annotation.Target;

import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import br.edu.utfpr.pb.pw25s.server.validator.UniqueNameValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameValidator.class)
public @interface UniqueName {
    String message() default "{br.edu.utfpr.pb.pw25s.server.user.username.constraints.UniqueUsername.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
