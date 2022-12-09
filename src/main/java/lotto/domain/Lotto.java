package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String NOT_LOTTO_LENGTH_ERROR = "로또 번호는 6자리여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_ERROR = "중복된 로또번호가 존재합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        List<Number> lottoNumber = numbers.stream().map(Number::from)
                .collect(Collectors.toList());
        validLottoSize(lottoNumber);
        validNumberDuplicate(lottoNumber);
        this.numbers = sortLottoNumber(lottoNumber);
    }

    private void validLottoSize(List<Number> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_LOTTO_LENGTH_ERROR);
        }
    }

    private void validNumberDuplicate(List<Number> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }

    private List<Number> sortLottoNumber(List<Number> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    private List<Number> getNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> this.numbers.contains(num))
                .count();
    }

    public boolean isMatch(Number number) {
        if (this.numbers.contains(number)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}