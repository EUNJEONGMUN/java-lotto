package lotto.util;

import java.util.Arrays;

public class Validator {
    public static final String NOT_NUMBER_ERROR = "숫자를 입력해주세요.";
    public static final String NOT_NUMBER_DELIMITER_ERROR = "컴마로 구분된 숫자를 입력해주세요.";
    private static final String NUMBER_DELIMITER = ",";

    public static void validLottoNumberPattern(String numbers) {
        try {
            Arrays.stream(numbers.split(NUMBER_DELIMITER))
                    .map(s -> s.replaceAll(" ", ""))
                    .forEach(num -> validIsNumber(num));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_NUMBER_DELIMITER_ERROR);
        }

    }

    public static void validIsNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }
}