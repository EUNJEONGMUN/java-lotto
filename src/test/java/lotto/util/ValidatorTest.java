package lotto.util;

import lotto.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("로또번호는 컴마로 입력되지 않으면 예외가 발생한다.")
    @Test
    void createInvalidLottoNumberPattern() {
        String lottoNumber = "1,2,3,4;5,6";
        Assertions.assertThatThrownBy(() -> Validator.validLottoNumberPattern(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("컴마로 구분된 숫자를 입력해주세요.");
    }

    @DisplayName("로또번호는 컴마로 입력되어 있으면 정상처리한다.")
    @Test
    void createValidLottoNumberPattern() {
        String lottoNumber = "1,2,3,4,5,6";
        assertThatNoException().isThrownBy(() -> Validator.validLottoNumberPattern(lottoNumber));
    }

    @DisplayName("숫자에 문자가 포함되어있을 경우 예외가 발생한다.")
    @Test
    void validIsDigit() {
        String number = "2*";
        assertThatThrownBy(() -> Validator.validIsNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요.");
    }
}