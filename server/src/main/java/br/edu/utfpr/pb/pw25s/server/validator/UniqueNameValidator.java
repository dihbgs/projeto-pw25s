package br.edu.utfpr.pb.pw25s.server.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import br.edu.utfpr.pb.pw25s.server.annotation.UniqueName;
import br.edu.utfpr.pb.pw25s.server.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findUserByName(name) == null;
    }
}
