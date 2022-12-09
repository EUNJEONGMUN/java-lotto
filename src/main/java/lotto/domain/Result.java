package lotto.domain;

import lotto.dto.ResultDto;

import java.util.EnumMap;

public class Result {
    public static final int PERCENT = 100;

    private final EnumMap<Prize, Integer> totalMatchResult;

    public Result() {
        this.totalMatchResult = Prize.initialMap();
    }

    public void addResult(Rank rank) {
        Prize prize = Prize.findByRank(rank);
        totalMatchResult.put(prize, totalMatchResult.get(prize) + 1);

    }

    public long getTotalPrizeMoney() {
        return totalMatchResult.keySet().stream()
                .mapToLong(prize -> prize.calculatePrizeMoney(totalMatchResult.get(prize)))
                .sum();
    }

    public ResultDto getTotalMatchResult() {
        return ResultDto.from(totalMatchResult);
    }

    public double getReturnOfRate(Price price) {
        long totalPrizeMoney = getTotalPrizeMoney();
        return (double) totalPrizeMoney / price.getPrice() * PERCENT;
    }
}