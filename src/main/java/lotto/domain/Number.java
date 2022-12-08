package lotto.domain;

import constant.ErrorMessage;

import java.util.Objects;

public class Number {
    private static final int LOTTO_NUMBER__MIN = 1;
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
        if (number<LOTTO_NUMBER__MIN || number>LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER_RANGE);
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
}