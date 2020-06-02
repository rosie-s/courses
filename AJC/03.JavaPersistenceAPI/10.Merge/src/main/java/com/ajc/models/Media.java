package com.ajc.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "media_table")
public class Media {

    @EmbeddedId
    @Column(name ="media_id")
    MediaId id;

    @Column(name = "media_name")
    public String name;

    @Column(name = "release_date")
    //@Temporal(TemporalType.DATE)
    public Date release;

    @ManyToOne
    private Artist artist;

    public Media(MediaId mediaId, Date release) {
       // this.name = name;
        this.release = release;
        this.id = mediaId;
    }

    public Media() {
    }

    public MediaId getId() {
        return id;
    }

    public void setId(MediaId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", release=" + release +
                ", artist=" + artist +
                '}';
    }
}
