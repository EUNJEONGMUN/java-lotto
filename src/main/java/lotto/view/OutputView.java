package lotto.view;

import lotto.dto.LottoTicketDto;
import lotto.dto.ResultDto;

import java.util.List;

public class OutputView {
    private static final String PRINT_LOTTO_TICKETS_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String PRINT_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String PRINT_RETURN_OF_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static void printLottoTickets(LottoTicketDto lottoTicketDto) {
        List<String> lottoTicketNumbers = lottoTicketDto.getLottoTicketNumbers();
        System.out.println(String.format(PRINT_LOTTO_TICKETS_MESSAGE, lottoTicketNumbers.size()));
        lottoTicketNumbers.stream().forEach(System.out::println);
    }

    public static void printResult(ResultDto resultDto) {
        System.out.println(PRINT_RESULT_MESSAGE);
        resultDto.getTotalResult().stream()
                .forEach(System.out::println);
    }

    public static void printReturnOfRate(double returnOfRate) {
        System.out.println(String.format(PRINT_RETURN_OF_RATE_MESSAGE, returnOfRate));
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}