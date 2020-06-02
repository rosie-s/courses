package com.ajc.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "media_table")
public class Media {

    @EmbeddedId
    MediaId id;
    
    @Column(name = "mName")
    public String name;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    public Date release;

    @ManyToOne
    private Artist artist;
}
