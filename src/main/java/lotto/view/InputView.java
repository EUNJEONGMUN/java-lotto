package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String INPUT_WINNING_NUM_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String NUMBER_DELIMITER = ",";

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String price = Console.readLine().trim();
        Validator.validIsNumber(price);
        return Integer.parseInt(price);
    }

    public static List<Integer> readWinningNumber() {
        System.out.println(INPUT_WINNING_NUM_MESSAGE);
        String numbers = Console.readLine().trim();
        Validator.validLottoNumberPattern(numbers);
        return Arrays.stream(numbers.split(NUMBER_DELIMITER))
                .map(s -> s.replaceAll(" ", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUM_MESSAGE);
        String number = Console.readLine().trim();
        Validator.validIsNumber(number);
        return Integer.parseInt(number);

    }
}