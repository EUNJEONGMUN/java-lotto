package lotto.domain;

import lotto.dto.ResultDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    private Result result = new Result();

    @DisplayName("당첨 결과는 1등 1개, 3등 1개이다.")
    @BeforeEach
    void setUp() {
        result.addResult(Rank.FIRST);
        result.addResult(Rank.THIRD);
    }

    @DisplayName("총 상금을 계산한다.")
    @Test
    void getTotalPrizeMoney() {
        long firstPrizeMoney = 2000000000L;
        long thirdPrizeMoney = 1500000L;
        long expected = firstPrizeMoney + thirdPrizeMoney;
        Assertions.assertThat(result.getTotalPrizeMoney()).isEqualTo(expected);
    }

    @DisplayName("1등 1개, 3등 1개의 결과를 얻는다.")
    @Test
    void getTotalMatchResult() {
        ResultDto resultDto = result.getTotalMatchResult();
        Assertions.assertThat(resultDto.getTotalResult()).contains(
                "6개 일치 (2,000,000,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개");
    }

    @DisplayName("5000원으로 로또를 샀을 때의 수익률을 얻는다.")
    @Test
    void getReturnOfRate() {
        int money = 5000;
        double result = this.result.getReturnOfRate(Price.from(money));
        double expected = 2001500000 / money * 100;
        Assertions.assertThat(result).isEqualTo(expected);
    }
}