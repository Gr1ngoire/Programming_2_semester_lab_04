package com.example.lab_04.services.Utils.validators;

public interface Validator {
    void validateAll(String[] toValidate) throws IllegalArgumentException;
}
