package com.example.lab_04.dao;

import com.example.lab_04.services.Entities.University;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class JsonDAO extends MyDAO {
    private final String PATH = "../myDatabase/db.json";
    // private final String PATH = "D:\\Desktop\\University\\Labs\\Programming_2_semester\\Lab_04\\src\\main\\java\\com\\example\\lab_04\\myDatabase\\db.json";
    private final Gson gson = new Gson();

    @Override
    public void update(University toWrite) throws IOException {
        String jsonString = gson.toJson(toWrite);
        System.out.println(jsonString);
        try (PrintWriter out = new PrintWriter(new FileWriter(PATH))) {
            out.write(jsonString);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public University getData() throws IOException, ClassNotFoundException, ClassCastException {
        char[] res = new char[2048];
        try (FileReader reader = new FileReader(PATH)) {
            while (reader.read(res) != -1) {
                System.out.println(Arrays.toString(res));
            }
            return gson.fromJson(reader, University.class);
        }
    }
}
