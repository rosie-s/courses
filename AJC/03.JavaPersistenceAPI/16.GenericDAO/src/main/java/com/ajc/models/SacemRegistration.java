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
    @Column(name ="sacem_id")
    public long id;

    @Column(unique = true, name = "sacem_code")
    public String code;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne(mappedBy = "sacemRegistration")
    private Artist artist;

    public SacemRegistration(String code) {
        this.id = id;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "SacemRegistration{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", artist=" + artist +
                '}';
    }
}
