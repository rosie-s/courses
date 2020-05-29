package com.ajc;

import javax.persistence.*;

public class Entry {
    public static void main(String[] args) {
        EntityManagerFactory e = Persistence.createEntityManagerFactory("training");
        e.close();
    }
}
