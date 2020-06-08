package com.ajc.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtist is a Querydsl query type for Artist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArtist extends EntityPathBase<Artist> {

    private static final long serialVersionUID = 444124842L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArtist artist = new QArtist("artist");

    public final QPerson _super = new QPerson(this);

    public final StringPath bandName = createString("bandName");

    public final QInstrument favouriteInstrument;

    //inherited
    public final StringPath firstName = _super.firstName;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastName = _super.lastName;

    public final QManager manager;

    public final ListPath<Media, QMedia> media = this.<Media, QMedia>createList("media", Media.class, QMedia.class, PathInits.DIRECT2);

    public final ListPath<Instrument, QInstrument> playableInstruments = this.<Instrument, QInstrument>createList("playableInstruments", Instrument.class, QInstrument.class, PathInits.DIRECT2);

    public final QSacemRegistration sacemRegistration;

    public final NumberPath<Integer> size = createNumber("size", Integer.class);

    public QArtist(String variable) {
        this(Artist.class, forVariable(variable), INITS);
    }

    public QArtist(Path<? extends Artist> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArtist(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArtist(PathMetadata metadata, PathInits inits) {
        this(Artist.class, metadata, inits);
    }

    public QArtist(Class<? extends Artist> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.favouriteInstrument = inits.isInitialized("favouriteInstrument") ? new QInstrument(forProperty("favouriteInstrument")) : null;
        this.manager = inits.isInitialized("manager") ? new QManager(forProperty("manager")) : null;
        this.sacemRegistration = inits.isInitialized("sacemRegistration") ? new QSacemRegistration(forProperty("sacemRegistration"), inits.get("sacemRegistration")) : null;
    }

}

