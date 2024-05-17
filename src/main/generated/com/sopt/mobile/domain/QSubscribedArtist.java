package com.sopt.mobile.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubscribedArtist is a Querydsl query type for SubscribedArtist
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubscribedArtist extends EntityPathBase<SubscribedArtist> {

    private static final long serialVersionUID = 1844602720L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubscribedArtist subscribedArtist = new QSubscribedArtist("subscribedArtist");

    public final QBaseTime _super = new QBaseTime(this);

    public final QArtistMember artistMember;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath nickname = createString("nickname");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public QSubscribedArtist(String variable) {
        this(SubscribedArtist.class, forVariable(variable), INITS);
    }

    public QSubscribedArtist(Path<? extends SubscribedArtist> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubscribedArtist(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubscribedArtist(PathMetadata metadata, PathInits inits) {
        this(SubscribedArtist.class, metadata, inits);
    }

    public QSubscribedArtist(Class<? extends SubscribedArtist> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artistMember = inits.isInitialized("artistMember") ? new QArtistMember(forProperty("artistMember"), inits.get("artistMember")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

