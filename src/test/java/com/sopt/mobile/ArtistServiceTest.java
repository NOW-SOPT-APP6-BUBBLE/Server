package com.sopt.mobile;

import com.sopt.mobile.domain.Subscribe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArtistServiceTest {

    @Test
    @DisplayName("할인율 계산")
    public void discount() {
        int n = 2;
        Subscribe subscribe = new Subscribe(Integer.toString(n) + "인권", 4500 * (n), 4500 * (n) - 1000 * (n - 1));
        Assertions.assertThat(subscribe.getPrice()).isEqualTo(8000);

        n = 4;
        Subscribe subscribe2 = new Subscribe(Integer.toString(n) + "인권", 4500 * (n), 4500 * (n) - 1000 * (n - 1));
        Assertions.assertThat(subscribe2.getPrice()).isEqualTo(15000);
        Assertions.assertThat(subscribe2.getPreviousPrice()).isEqualTo(18000);

    }
}
