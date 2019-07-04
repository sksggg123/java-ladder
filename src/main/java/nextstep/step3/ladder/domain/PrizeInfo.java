package nextstep.step3.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 21:44
 */
public class PrizeInfo {
    private static final String NULL_EMPTY_EXCEPTION_MESSAGE = "실행 결과 값이 없습니다.";
    private static final String INFO_RESULT_SIZE_EXCEPTION_MESSAGE = "결과값이 참여자와 다릅니다.";

    private List<Prize> prizeInfo;

    private PrizeInfo(List<Prize> prizeInfo) {
        this.prizeInfo = prizeInfo;
    }

    public static PrizeInfo of(List<Prize> info, int participantCount) {
        if (info == null || info.isEmpty()) {
            throw new IllegalArgumentException(NULL_EMPTY_EXCEPTION_MESSAGE);
        }

        int infoCount = info.size();
        if (infoCount != participantCount) {
            throw new IllegalArgumentException(INFO_RESULT_SIZE_EXCEPTION_MESSAGE);
        }
        return new PrizeInfo(info);
    }

    public Stream<Prize> stream() {
        return this.prizeInfo.stream();
    }

    public Prize getPrizeByIndex(int index) {
        return Prize.of(prizeInfo.get(index).getPrize());
    }
}