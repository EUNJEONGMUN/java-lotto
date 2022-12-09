package lotto.domain;

import lotto.dto.ResultDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTicketsTest {

    @DisplayName("1등 1개, 2등 2개의 결과를 얻는다.")
    @Test
    void getMatchResult() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,3,4,5,6,7)));
        LottoTickets lottoTickets = new LottoTickets(lottos);

        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 4, 5, 6), 7);

        Result result = lottoTickets.getMatchResult(winningNumber);
        ResultDto resultDto = result.getTotalMatchResult();
        Assertions.assertThat(resultDto.getTotalResult()).contains(
                "6개 일치 (2,000,000,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }
}