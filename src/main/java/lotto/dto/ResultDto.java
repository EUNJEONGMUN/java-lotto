package lotto.dto;

import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ResultDto {
    private static final String MAKE_RESULT_MASSAGE = "%s - %d개";

    private final EnumMap<Prize, Integer> totalMatchResult;

    private ResultDto(EnumMap<Prize, Integer> totalMatchResult) {
        this.totalMatchResult = totalMatchResult;
    }

    public static ResultDto from(EnumMap<Prize, Integer> totalMatchResult) {
        return new ResultDto(totalMatchResult);
    }

    public List<String> getTotalResult() {
        List<String> result = new ArrayList<>();
        totalMatchResult.keySet().stream()
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize ->
                        result.add(String.format(MAKE_RESULT_MASSAGE,
                                prize.getMessage(),
                                totalMatchResult.get(prize))));
        return result;
    }
}