package utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validation;
import lotto.domain.LottoNumber;

import static constant.Constant.*;
import static constant.ErrorMessage.*;
import static constant.Messages.*;

public class UserInput {

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String price = Console.readLine();
        Validation.validIsDigit(price);
        validMoneyUnit(Integer.parseInt(price));
        return calculateNumOfLotto(Integer.parseInt(price));
    }

    public static LottoNumber inputLottoNumbers() {
        System.out.println(INPUT_WINNING_NUM_MESSAGE);
        String winningNumbers = Console.readLine();

        System.out.println(INPUT_BONUS_NUM_MESSAGE);
        String bonusNumber = Console.readLine();
        return new LottoNumber(winningNumbers, bonusNumber);
    }

    private static void validMoneyUnit(int price) {
        if (price % MONEY_UNIT != REMAINDER_ZERO) {
            System.out.println(NOT_RADIX_1000);
            throw new IllegalArgumentException(NOT_RADIX_1000);
        }
    }

    private static int calculateNumOfLotto(int price) {
        return price / MONEY_UNIT;
    }
}
