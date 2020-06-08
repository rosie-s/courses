package com.ajc.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMediaId is a Querydsl query type for MediaId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMediaId extends BeanPath<MediaId> {

    private static final long serialVersionUID = -1738863332L;

    public static final QMediaId mediaId = new QMediaId("mediaId");

    public final EnumPath<MediaType> mediaType = createEnum("mediaType", MediaType.class);

    public final StringPath name = createString("name");

    public QMediaId(String variable) {
        super(MediaId.class, forVariable(variable));
    }

    public QMediaId(Path<? extends MediaId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMediaId(PathMetadata metadata) {
        super(MediaId.class, metadata);
    }

}

