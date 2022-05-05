package com.example.lab_04.services.DTOs;

import java.util.HashMap;
import java.util.Map;

public class StudentReceiveDTO {
    private String name;
    private String surname;
    private String markBookId;
    private String averageMark;
    private String faculty;

    public StudentReceiveDTO(StudentReceiveDTOBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.markBookId = builder.markBookId;
        this.averageMark = builder.averageMark;
        this.faculty = builder.faculty;
    }

    public Map<String, String> asHashMap() {
        return new HashMap<String, String>(){{
            put("name", name);
            put("surname", surname);
            put("markBookId", markBookId);
            put("averageMark", averageMark);
            put("faculty", faculty);
        }};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMarkBookId() {
        return markBookId;
    }

    public void setMarkBookId(String markBookId) {
        this.markBookId = markBookId;
    }

    public String getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(String averageMark) {
        this.averageMark = averageMark;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static class StudentReceiveDTOBuilder {
        private final String name;
        private String surname;
        private String markBookId;
        private String averageMark;
        private String faculty;

        public StudentReceiveDTOBuilder(String name) {
            this.name = name;
        }

        public StudentReceiveDTOBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentReceiveDTOBuilder setMarkBookId(String markBookId) {
            this.markBookId = markBookId;
            return this;
        }

        public StudentReceiveDTOBuilder setAverageMark(String averageMark) {
            this.averageMark = averageMark;
            return this;
        }

        public StudentReceiveDTOBuilder setFaculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public StudentReceiveDTO build() {
            return new StudentReceiveDTO(this);
        }
    }
}
