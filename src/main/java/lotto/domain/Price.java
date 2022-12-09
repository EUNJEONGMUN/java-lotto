package lotto.domain;

public class Price {
    private static final String NOT_RADIX_1000_ERROR = "1,000원 단위로 입력해주세요.";
    private static final String NOT_PRICE_RANGE_ERROR = "1원 이상 2억 이하의 금액을 입력해주세요.";
    private static final int PRICE_MIN = 0;
    private static final int PRICE_MAX = 200000000;
    private static final int MONEY_UNIT = 1000;
    private static final int REMAINDER_ZERO = 0;

    private final int price;

    private Price(int price) {
        validPriceRange(price);
        validMoneyUnit(price);
        this.price = price;
    }

    public static Price from(int price) {
        return new Price(price);
    }

    private void validPriceRange(int price) {
        if (price <= PRICE_MIN || price > PRICE_MAX) {
            throw new IllegalArgumentException(NOT_PRICE_RANGE_ERROR);
        }
    }

    private void validMoneyUnit(int price) {
        if (price % MONEY_UNIT != REMAINDER_ZERO) {
            throw new IllegalArgumentException(NOT_RADIX_1000_ERROR);
        }
    }

    public int getNumberOfLotto() {
        return this.price / MONEY_UNIT;
    }

    public int getPrice() {
        return price;
    }
}