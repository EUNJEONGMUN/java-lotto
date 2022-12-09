package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLotto {
    public static List<Lotto> createLottoTicketsByNumOfLotto(int numOfLotto) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numOfLotto; i++) {
            lottoTickets.add(createLotto());
        }
        return lottoTickets;
    }

    private static Lotto createLotto() {
        return new Lotto(RandomLotto.createRandomLottoNumbers());
    }

    private static List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .collect(Collectors.toList());
    }
}