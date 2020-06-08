package com.ajc.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInstrument is a Querydsl query type for Instrument
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInstrument extends EntityPathBase<Instrument> {

    private static final long serialVersionUID = -1400444470L;

    public static final QInstrument instrument = new QInstrument("instrument");

    public final ListPath<Artist, QArtist> artistFavouriteInstrument = this.<Artist, QArtist>createList("artistFavouriteInstrument", Artist.class, QArtist.class, PathInits.DIRECT2);

    public final ListPath<Artist, QArtist> artistPlayableInstruments = this.<Artist, QArtist>createList("artistPlayableInstruments", Artist.class, QArtist.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<InstrumentType> instrumentType = createEnum("instrumentType", InstrumentType.class);

    public final StringPath name = createString("name");

    public QInstrument(String variable) {
        super(Instrument.class, forVariable(variable));
    }

    public QInstrument(Path<? extends Instrument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInstrument(PathMetadata metadata) {
        super(Instrument.class, metadata);
    }

}

