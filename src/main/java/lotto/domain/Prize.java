package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public enum Prize {
    NONE(Rank.NONE, 0, Messages.NONE_MESSAGE),
    FIRST_PRIZE(Rank.FIRST, 2000000000, Messages.FIRST_PRIZE_MESSAGE),
    SECOND_PRIZE(Rank.SECOND, 30000000, Messages.SECOND_PRIZE_MESSAGE),
    THIRD_PRIZE(Rank.THIRD, 1500000, Messages.THIRD_PRIZE_MESSAGE),
    FOURTH_PRIZE(Rank.FOURTH, 50000, Messages.FOURTH_PRIZE_MESSAGE),
    FIFTH_PRIZE(Rank.FIFTH, 5000, Messages.FIFTH_PRIZE_MESSAGE);

    private final Rank rank;
    private final long prizeMoney;
    private final String message;

    Prize(Rank rank, long prizeMoney, String message) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    private Rank getRank() {
        return rank;
    }

    public String getMessage() {
        return message;
    }

    public long calculatePrizeMoney(int count) {
        return this.prizeMoney * count;
    }

    public static Prize findByRank(Rank rank) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getRank().equals(rank))
                .findAny()
                .orElse(NONE);
    }

    public static EnumMap<Prize, Integer> initialMap() {
        EnumMap<Prize, Integer> init = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> init.put(prize, 0));
        return init;
    }

    private static class Messages {
        private static final String NONE_MESSAGE = "없음";
        private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원)";
        private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원)";
        private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원)";
        private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
        private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원)";
    }
}