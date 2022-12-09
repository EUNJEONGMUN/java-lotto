package lotto.controller;

import lotto.domain.*;
import lotto.util.RandomLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void start() {
        Price price = Price.from(InputView.inputPrice());
        int numOfLotto = price.getNumberOfLotto();
        LottoTickets lottoTickets = createLottoTickets(numOfLotto);
        WinningNumber winningNumber = readLottoNumber();

        Result result = lottoTickets.getMatchResult(winningNumber);
        OutputView.printResult(result.getTotalMatchResult());
        OutputView.printReturnOfRate(result.getReturnOfRate(price));
    }

    private LottoTickets createLottoTickets(int numOfLotto) {
        List<Lotto> lottos = RandomLotto.createLottoTicketsByNumOfLotto(numOfLotto);
        LottoTickets lottoTickets = new LottoTickets(lottos);
        OutputView.printLottoTickets(lottoTickets.getLottoTickets());
        return lottoTickets;
    }

    private WinningNumber readLottoNumber() {
        List<Integer> inputWinningNumber = InputView.readWinningNumber();
        int bonusNumber = InputView.readBonusNumber();
        return WinningNumber.from(inputWinningNumber, bonusNumber);
    }
}