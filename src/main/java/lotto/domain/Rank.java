package lotto.domain;

import java.util.Arrays;

public enum Rank {

    NONE(0, false),
    FIFTH(3, false),
    FOURTH(4, false),
    THIRD(5, false),
    SECOND(5, true),
    FIRST(6, false);

    private final int winningCount;
    private final boolean bonusMatch;

    Rank(int winningCount, boolean bonusMatch) {
        this.winningCount = winningCount;
        this.bonusMatch = bonusMatch;
    }

    private int getWinningCount() {
        return winningCount;
    }

    public static Rank findRankByMatchResult(int winningCount, boolean bonusMatch) {
        if (winningCount == 5 && bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningCount() == winningCount)
                .findAny()
                .orElse(NONE);
    }
}