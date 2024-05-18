package com.sopt.mobile.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Subscribe {
    String name;
    Integer price;

    public Subscribe(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
