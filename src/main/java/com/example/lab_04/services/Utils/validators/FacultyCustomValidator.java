package com.example.lab_04.services.Utils.validators;

import java.util.ArrayList;
import java.util.Map;

public class FacultyCustomValidator extends CustomValidator{
    @Override
    public void validate(Map<String, String> toValidate) throws IllegalArgumentException, NullPointerException {
        validators.setValidators(new ArrayList<ValidationSingleUnit>(){{
            add(new NullValidationUnit());
            add(new EmptyValidationUnit());
            add(new FacultyNameFormatValidationUnit());
        }});
    }

    private class NullValidationUnit extends ValidationSingleUnit {

        @Override
        void validate(String parName, String toValidate) throws NullPointerException {
            if (toValidate == null) {
                throw new NullPointerException(String.format("%s can not be null", parName));
            }
        }
    }

    private class EmptyValidationUnit extends ValidationSingleUnit {

        @Override
        void validate(String parName, String toValidate) throws IllegalArgumentException {
            if (toValidate.length() == 0) {
                throw new IllegalArgumentException(String.format("%s can not be empty", parName));
            }
        }
    }

    private class FacultyNameFormatValidationUnit extends ValidationSingleUnit {

        @Override
        void validate(String parName, String toValidate) throws IllegalArgumentException {
            if (!toValidate.matches("[a-zа-яA-ZА-Я]")) {
                throw new IllegalArgumentException(String.format("%s must consist of letters(latin or cyrillic)", parName));
            }
        }
    }
}
