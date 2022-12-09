package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @DisplayName("등수에 따른 상금을 반환한다.")
    @ParameterizedTest(name = "[{index}] rank({0}) -> prize({1})")
    @CsvSource(value = {"NONE:NONE", "FIRST:FIRST_PRIZE", "SECOND:SECOND_PRIZE", "THIRD:THIRD_PRIZE", "FOURTH:FOURTH_PRIZE", "FIFTH:FIFTH_PRIZE"}, delimiter = ':')
    void findByRank(Rank rank, Prize expected) {
        Prize result = Prize.findByRank(rank);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("1등을 2개 맞으면 40억의 상금을 받는다.")
    @Test
    void calculatePrizeMoney() {
        Prize first = Prize.FIRST_PRIZE;
        long result = first.calculatePrizeMoney(2);
        long expected = 4000000000L;
        Assertions.assertThat(result).isEqualTo(expected);
    }
}