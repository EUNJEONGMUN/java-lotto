package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RankTest {

    @DisplayName("매칭 결과에 따른 등수를 반환한다.")
    @ParameterizedTest(name = "[{index}] 맞은개수({0}), 보너스({1}) -> {2}")
    @MethodSource
    void findRankByResult(int winningCount, boolean bonusMatch, Rank expected) {
        Rank result = Rank.findRankByMatchResult(winningCount, bonusMatch);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> findRankByResult() {
        return Stream.of(
                Arguments.of(1, false, Rank.NONE),
                Arguments.of(1, true, Rank.NONE),
                Arguments.of(2, false, Rank.NONE),
                Arguments.of(2, true, Rank.NONE),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }
}