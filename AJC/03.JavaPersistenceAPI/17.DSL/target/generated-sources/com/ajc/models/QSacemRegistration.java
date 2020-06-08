package com.ajc.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSacemRegistration is a Querydsl query type for SacemRegistration
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSacemRegistration extends EntityPathBase<SacemRegistration> {

    private static final long serialVersionUID = 294196563L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSacemRegistration sacemRegistration = new QSacemRegistration("sacemRegistration");

    public final QArtist artist;

    public final StringPath code = createString("code");

    public final DatePath<java.util.Date> date = createDate("date", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QSacemRegistration(String variable) {
        this(SacemRegistration.class, forVariable(variable), INITS);
    }

    public QSacemRegistration(Path<? extends SacemRegistration> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSacemRegistration(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSacemRegistration(PathMetadata metadata, PathInits inits) {
        this(SacemRegistration.class, metadata, inits);
    }

    public QSacemRegistration(Class<? extends SacemRegistration> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new QArtist(forProperty("artist"), inits.get("artist")) : null;
    }

}

