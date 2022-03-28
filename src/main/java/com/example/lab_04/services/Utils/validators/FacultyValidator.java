package com.example.lab_04.services.Utils.validators;

public class FacultyValidator implements Validator {

    private void validateName(String name) throws IllegalArgumentException{
        if (name.length() == 0) {
            throw new IllegalArgumentException("Name can not be empty");
        } else if (!name.matches("^([^0-9]*)$")) {
            throw new IllegalArgumentException("Name can not contain numbers");
        } else if (!name.matches("^[A-ZА-Я][a-zA-Zа-яА-Я]*")) {
            throw new IllegalArgumentException("Name must start with upper case letter");
        }
    }


    @Override
    public void validateAll(String[] toValidate) throws IllegalArgumentException {
        validateName(toValidate[0]);
    }
}
