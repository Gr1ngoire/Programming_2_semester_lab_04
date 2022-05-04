package com.example.lab_04.services.Utils.validators;

import java.util.Map;

public abstract class CustomValidator {
    protected final ValidatorsStorage validators = new ValidatorsStorage();

    public abstract void validate(Map<String, String> toValidate) throws IllegalArgumentException;

}
