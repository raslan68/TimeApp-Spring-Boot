package com.ramiaslan.timeapp.validator;

import com.ramiaslan.timeapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueRolenameValidator implements ConstraintValidator<UniqueRolename, String> {

    private final RoleRepository roleRepository;

    @Override
    public boolean isValid(String rolename, ConstraintValidatorContext context) {
        return !roleRepository.existsByName(rolename);
    }

}
