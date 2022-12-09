package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {
    private static final String NOT_LOTTO_NUMBER_RANGE_ERROR = "1에서 45사이의 숫자를 입력해주세요.";
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final int number;

    private Number(int number) {
        validRange(number);
        this.number = number;
    }

    public static Number from(int number) {
        return new Number(number);
    }

    private void validRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(NOT_LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Number)) {
            return false;
        }
        if (((Number) obj).getNumber() == this.number) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Number obj) {
        return this.number - obj.getNumber();
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}