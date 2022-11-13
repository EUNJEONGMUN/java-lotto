package lotto.domain;

import lotto.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validLotto(numbers);
        this.numbers = numbers;
    }

    private void validLotto(List<Integer> numbers) {
        Validation.validateLottoSize(numbers);
        Validation.validLottoNumberDuplicate(numbers);
        Validation.validNumberRange(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public MatchCount getMatchResult(LottoNumber lottoNumber) {
        int match = (int) lottoNumber.winningNumbers.getNumbers().stream()
                .filter(num -> numbers.contains(num))
                .count();
        int bonusMatch = 0;
        if (numbers.contains(lottoNumber.bonusNumber)) {
            bonusMatch++;
        }
        return new MatchCount(match, bonusMatch);
    }
}
