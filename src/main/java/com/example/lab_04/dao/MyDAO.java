package com.example.lab_04.dao;

import com.example.lab_04.services.Entities.University;

import java.io.IOException;

public abstract class MyDAO {
    abstract public void update(University toWrite) throws IOException;

    abstract public University getData()  throws IOException, ClassNotFoundException, ClassCastException;
}
