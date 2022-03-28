package com.example.lab_04.services.Utils.validators;

public class StudentValidator implements Validator {

    private void validateName(String name) throws IllegalArgumentException{
        if (name.length() == 0) {
            throw new IllegalArgumentException("Name can not be empty");
        } else if (!name.matches("^([^0-9]*)$")) {
            throw new IllegalArgumentException("Name can not contain numbers");
        } else if (!name.matches("^[A-ZА-Я][a-zA-Zа-яА-Я]*")) {
            throw new IllegalArgumentException("Name must start with upper case letter");
        }
    }

    private void validateSurname(String surname) {
        if (surname.length() == 0) {
            throw new IllegalArgumentException("Surname can not be empty");
        } else if (!surname.matches("^([^0-9]*)$")) {
            throw new IllegalArgumentException("Surname can not contain numbers");
        } else if (!surname.matches("^[A-ZА-Я][a-zA-Zа-яА-Я]*")) {
            throw new IllegalArgumentException("Surname must start with upper case letter");
        }
    }

    private void validateMarkBookId(String surname) {
        if (surname.length() == 0) {
            throw new IllegalArgumentException("Mark book id can not be empty");
        } else if (!surname.matches("[a-zA-Z]+_\\d+")) {
            throw new IllegalArgumentException("Mark book id must be in format \"[faculty]_[number]\"");
        }
    }

    private void validateAverageMark(String points) {
        if (points.length() == 0) {
            throw new IllegalArgumentException("Average mark can not be empty");
        } else if (!points.matches("^(\\d+\\.*\\d+)$")) {
            throw new IllegalArgumentException("Mark book id must be in format of a number (float number is allowed)");
        } else if (Double.parseDouble(points) < 0 || Double.parseDouble(points) > 100) {
            throw new IllegalArgumentException("Mark book id must be in interval between 0 and 100");
        }
    }

    @Override
    public void validateAll(String[] toValidate) throws IllegalArgumentException {
        validateName(toValidate[0]);
        validateSurname(toValidate[1]);
        validateMarkBookId(toValidate[2]);
        validateAverageMark(toValidate[3]);
    }
}
