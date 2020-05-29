package com.ajc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sacem_table")
public class SacemRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(unique = true)
    public String code;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne(mappedBy = "sacemRegistration")
    private Artist artist;
}
