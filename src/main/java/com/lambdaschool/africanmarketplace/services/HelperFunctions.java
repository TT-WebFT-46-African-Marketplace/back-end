package com.lambdaschool.africanmarketplace.services;

import com.lambdaschool.africanmarketplace.models.ValidationError;

import java.util.List;

public interface HelperFunctions {
    List<ValidationError> getConstraintViolation(Throwable cause);

    boolean isAuthorizedToMakeChange(String username);
}
