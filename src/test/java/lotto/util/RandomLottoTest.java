package lotto.util;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomLottoTest {

    @DisplayName("입력 개수만큼 로또를 생성한다.")
    @Test
    void createLottoTicketsByNumOfLotto() {
        int numOfLotto = 2;
        List<Lotto> result = RandomLotto.createLottoTicketsByNumOfLotto(numOfLotto);
        Assertions.assertThat(result.size()).isEqualTo(numOfLotto);
    }
}