package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

    @DisplayName("돈을 1000원 단위로 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 1001, 1100, 1111, 1})
    void inputMoneyNot1000Unit(int input) {
        Assertions.assertThatThrownBy(() -> Price.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1,000원 단위로 입력해주세요.");
    }


    @DisplayName("1원 이하, 2억 초과의 돈을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 2000000001})
    void inputMoneyNotRange(int input) {
        Assertions.assertThatThrownBy(() -> Price.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1원 이상 2억 이하의 금액을 입력해주세요.");
    }

    @DisplayName("살 수 있는 로또 장수를 반환한다.")
    @ParameterizedTest(name = "[{index}] {0}원으로 {1}개의 로또를 살 수 있다.")
    @CsvSource(value = {"10000:10", "1000:1"}, delimiter = ':')
    void getNumberOfLotto(int price, int expected) {
        int result = Price.from(price).getNumberOfLotto();
        Assertions.assertThat(result).isEqualTo(expected);
    }
}