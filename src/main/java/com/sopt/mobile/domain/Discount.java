package com.sopt.mobile.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity
@NoArgsConstructor
public class Discount extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer price;

    private Double discount;

    @Builder
    public Discount(Integer price, Double discount) {
        this.price = price;
        this.discount = discount;
    }

    public static Discount createDiscount(Integer price, Double discount) {
        return Discount
                .builder()
                .price(price)
                .discount(discount)
                .build();
    }
}
