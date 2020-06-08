package com.ajc.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QManager is a Querydsl query type for Manager
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QManager extends EntityPathBase<Manager> {

    private static final long serialVersionUID = -1844376406L;

    public static final QManager manager = new QManager("manager");

    public final QPerson _super = new QPerson(this);

    public final ListPath<Artist, QArtist> artists = this.<Artist, QArtist>createList("artists", Artist.class, QArtist.class, PathInits.DIRECT2);

    public final NumberPath<Double> budget = createNumber("budget", Double.class);

    //inherited
    public final StringPath firstName = _super.firstName;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastName = _super.lastName;

    public QManager(String variable) {
        super(Manager.class, forVariable(variable));
    }

    public QManager(Path<? extends Manager> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManager(PathMetadata metadata) {
        super(Manager.class, metadata);
    }

}

