package lotto.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {
    private List<Lotto> lottoTickets;

    private LottoTicketDto(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    public static LottoTicketDto from(List<Lotto> lottoTickets) {
        return new LottoTicketDto(lottoTickets);
    }

    public List<String> getLottoTicketNumbers() {
        List<String> result = new ArrayList<>();
        lottoTickets.stream()
                .map(lotto -> result.add(lotto.toString()))
                .collect(Collectors.toUnmodifiableList());
        return result;
    }
}