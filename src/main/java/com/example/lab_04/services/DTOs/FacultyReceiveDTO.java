package com.example.lab_04.services.DTOs;

import java.util.HashMap;
import java.util.Map;

public class FacultyReceiveDTO {
    private String name;

    public FacultyReceiveDTO(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Map<String, String> asHashMap() {
        return new HashMap<String, String>(){{
            put("facultyName", name);
        }};
    }
}
