package com.sopt.mobile.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDiscount is a Querydsl query type for Discount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiscount extends EntityPathBase<Discount> {

    private static final long serialVersionUID = 1954545504L;

    public static final QDiscount discount1 = new QDiscount("discount1");

    public final QBaseTime _super = new QBaseTime(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final NumberPath<Double> discount = createNumber("discount", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public QDiscount(String variable) {
        super(Discount.class, forVariable(variable));
    }

    public QDiscount(Path<? extends Discount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiscount(PathMetadata metadata) {
        super(Discount.class, metadata);
    }

}

