package lotto.domain;

import lotto.dto.LottoTicketDto;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTicketDto getLottoTickets() {
        return LottoTicketDto.from(lottoTickets);
    }

    public Result getMatchResult(WinningNumber winningNumber) {
        Result result = new Result();
        for (Lotto lotto : lottoTickets) {
            int winningCount = lotto.getMatchCount(winningNumber.getWinningNumbers());
            boolean matchBonusNumber = lotto.isMatch(winningNumber.getBonusNumber());
            result.addResult(Rank.findRankByMatchResult(winningCount, matchBonusNumber));
        }
        return result;
    }
}