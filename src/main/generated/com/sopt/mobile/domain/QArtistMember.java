package com.sopt.mobile.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArtistMember is a Querydsl query type for ArtistMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArtistMember extends EntityPathBase<ArtistMember> {

    private static final long serialVersionUID = -264706208L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArtistMember artistMember = new QArtistMember("artistMember");

    public final QBaseTime _super = new QBaseTime(this);

    public final QArtist artist;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageURL = createString("imageURL");

    public final StringPath introduction = createString("introduction");

    public final BooleanPath isService = createBoolean("isService");

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public QArtistMember(String variable) {
        this(ArtistMember.class, forVariable(variable), INITS);
    }

    public QArtistMember(Path<? extends ArtistMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArtistMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArtistMember(PathMetadata metadata, PathInits inits) {
        this(ArtistMember.class, metadata, inits);
    }

    public QArtistMember(Class<? extends ArtistMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.artist = inits.isInitialized("artist") ? new QArtist(forProperty("artist")) : null;
    }

}

