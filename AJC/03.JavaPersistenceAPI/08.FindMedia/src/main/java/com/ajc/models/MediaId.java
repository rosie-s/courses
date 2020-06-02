package com.ajc.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MediaId implements Serializable {
    private String name;
    private MediaType mediaType;

    public MediaId(String name, MediaType mediaType) {
        this.name = name;
        this.mediaType = mediaType;
    }

    public MediaId() {
    }
}
