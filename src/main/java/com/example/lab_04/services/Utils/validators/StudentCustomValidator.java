package com.example.lab_04.services.Utils.validators;

import java.util.Map;

public class StudentCustomValidator extends CustomValidator{
    @Override
    public void validate(Map<String, String> toValidate) throws IllegalArgumentException, NullPointerException {
        validators.addValidationUnit(new StudentNameFormatValidationUnit());
        validators.addValidationUnit(new StudentSurnameFormatValidationUnit());
        validators.addValidationUnit(new MarkBookIdValidationUnit());
        validators.addValidationUnit(new AverageMarkValidationUnit());
        validators.addValidationUnit(new FacultyValidationUnit());
        super.validate(toValidate);
    }

    private class StudentNameFormatValidationUnit extends ValidationSingleUnit  {

        @Override
        void validate(String parName, String toValidate) throws IllegalArgumentException{
            if (parName.equals("name")) {
                if (!toValidate.matches("^([^0-9]*)$")) {
                    throw new IllegalArgumentException(String.format("%s can not contain numbers", parName));
                } else if (!toValidate.matches("^[A-ZА-Я][a-zA-Zа-яА-Я]*")) {
                    throw new IllegalArgumentException(String.format("%s must start with upper case letter", parName));
                }
            }
        }
    }

    private class StudentSurnameFormatValidationUnit extends ValidationSingleUnit  {

        @Override
        void validate(String parName, String toValidate) throws IllegalArgumentException{
            if (parName.equals("surname")) {
                if (!toValidate.matches("^([^0-9]*)$")) {
                    throw new IllegalArgumentException(String.format("%s can not contain numbers", parName));
                } else if (!toValidate.matches("^[A-ZА-Я][a-zA-Zа-яА-Я]*")) {
                    throw new IllegalArgumentException(String.format("%s must start with upper case letter and have no spacebars", parName));
                }
            }
        }
    }

    private class MarkBookIdValidationUnit extends ValidationSingleUnit {

        @Override
        void validate(String parName, String toValidate) {
            if (parName.equals("markBookId")) {
                if (!toValidate.matches("[a-zA-Z]+_\\d+")) {
                    throw new IllegalArgumentException(String.format("%s must be in format \\\"[faculty]_[number]\\\"\"", parName));
                }
            }
        }
    }

    private class AverageMarkValidationUnit extends ValidationSingleUnit {

        @Override
        void validate(String parName, String toValidate) {
            if (parName.equals("points")) {
                if (!toValidate.matches("^(\\d+(\\.\\d+)*)$")) {
                    throw new IllegalArgumentException(String.format("%s must be in format of a number (float number is allowed)", parName));
                } else if (Double.parseDouble(toValidate) < 0 || Double.parseDouble(toValidate) > 100) {
                    throw new IllegalArgumentException(String.format("%s must be in interval between 0 and 100", parName));
                }
            }
        }
    }

    private class FacultyValidationUnit extends ValidationSingleUnit {

        @Override
        void validate(String parName, String toValidate) {
            if (parName.equals("faculty")) {
                if (!toValidate.matches("[a-zа-яA-ZА-Я]+")) {
                    throw new IllegalArgumentException(String.format("%s must follow format (consist only of latin and cyrillic letters)", parName));
                }
            }
        }
    }
}
