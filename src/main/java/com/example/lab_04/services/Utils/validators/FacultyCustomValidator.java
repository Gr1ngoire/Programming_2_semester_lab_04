package com.example.lab_04.services.Utils.validators;

import java.util.Map;

public class FacultyCustomValidator extends CustomValidator {
    @Override
    public void validate(Map<String, String> toValidate) throws IllegalArgumentException, NullPointerException {
        validators.addValidationUnit(new FacultyNameFormatValidationUnit());
        super.validate(toValidate);
    }

    private class FacultyNameFormatValidationUnit extends ValidationSingleUnit {

        @Override
        void validate(String parName, String toValidate) throws IllegalArgumentException {
            if (!toValidate.matches("[a-zа-яA-ZА-Я]+")) {
                throw new IllegalArgumentException(String.format("%s must consist of letters(latin or cyrillic)", parName));
            }
        }
    }
}
