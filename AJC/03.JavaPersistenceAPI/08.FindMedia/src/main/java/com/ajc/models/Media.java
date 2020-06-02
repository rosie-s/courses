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
