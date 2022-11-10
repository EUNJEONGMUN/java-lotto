package lotto;

import java.util.HashMap;
import java.util.List;

public class Result {
    private static HashMap<MatchCount, Integer> totalMatchResult = new HashMap<>();
    private int totalPrizeMoney = 0;

    public Result(List<Lotto> lottoTickets) {
        saveMatchResult(lottoTickets);
        showResult();
    }

    public void saveMatchResult(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            MatchCount matchResult = LottoNumber.getMatchResult(lotto);
            totalMatchResult.put(matchResult, totalMatchResult.getOrDefault(matchResult, 0)+1);
        }
    }

    public void showResult() {
        List<Prize> allPrize = Prize.getAllPrize();
        for (Prize prize : allPrize) {
            int countPrize = getPrizeCount(prize.getWinningCount(), prize.getBonusCount());
            System.out.println(prize.getMessage()+ " - " + countPrize+"개");
            sumPrizeMoney(prize.getPrizeMoney(), countPrize);
        }
    }

    private int getPrizeCount(int winningCount, int bonusCount) {
        return totalMatchResult.getOrDefault(new MatchCount(winningCount, bonusCount), 0);
    }

    public void sumPrizeMoney(int prizeMoney, int countPrize) {
        totalPrizeMoney += prizeMoney*countPrize;
    }
}
