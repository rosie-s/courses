package com.ajc;

import javax.persistence.*;

public class Entry {
    public static void main(String[] args) {
       EntityManagerFactory e = Persistence.createEntityManagerFactory("music");
       // EntityManagerFactory artist = Persistence.createEntityManagerFactory("artist");
       // EntityManagerFactory department = Persistence.createEntityManagerFactory("department");

        e.close();
    }
}
