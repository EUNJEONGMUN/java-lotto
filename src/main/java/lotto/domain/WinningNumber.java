package lotto.domain;

import java.util.List;

public class WinningNumber {
    private static final String DUPLICATE_BONUS_NUMBER_ERROR = "로또 번호와 중복된 보너스 번호입니다.";

    private final Lotto winningNumbers;
    private final Number bonusNumber;

    private WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validBonusNumberDuplicated(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = Number.from(bonusNumber);
    }

    public static WinningNumber from(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    private void validBonusNumberDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }
}