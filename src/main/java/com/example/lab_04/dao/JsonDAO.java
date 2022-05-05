package com.example.lab_04.dao;

import com.example.lab_04.services.Entities.University;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonDAO extends MyDAO {
    private final String PATH = "D:\\Desktop\\University\\Labs\\Programming_2_semester\\Lab_04\\src\\main\\java\\com\\example\\lab_04\\myDatabase\\db.json";
    private final Gson gson = new Gson();

    @Override
    public void update(University toWrite) throws IOException {
        String jsonString = gson.toJson(toWrite);
        try (PrintWriter out = new PrintWriter(new FileWriter(PATH))) {
            out.write(jsonString);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public University getData() throws IOException, ClassNotFoundException, ClassCastException {
        try (Reader reader = Files.newBufferedReader(Paths.get(PATH))) {
            return gson.fromJson(reader, University.class);
        }
    }
}
