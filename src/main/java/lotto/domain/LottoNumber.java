package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static constant.Constant.INITIAL_NUMBER;
import static constant.Constant.LOTTO_SIZE;

public class LottoNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoNumber(String winningNumbers, String bonusNumber) {
        String[] split = winningNumbers.split(",");
        this.winningNumbers = Stream.of(split).map(Integer::parseInt).collect(Collectors.toList());
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public MatchCount getMatchResult(Lotto lotto) {
        int match = 0;
        int bonusMatch = 0;
        for (int idx = INITIAL_NUMBER; idx < LOTTO_SIZE; idx++) {
            if (lotto.getNumbers().contains(winningNumbers.get(idx))) {
                match++;
            }
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            bonusMatch++;
        }
        return new MatchCount(match, bonusMatch);
    }
}