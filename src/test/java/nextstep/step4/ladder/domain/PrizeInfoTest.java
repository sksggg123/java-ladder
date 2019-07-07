package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 21:38
 */
public class PrizeInfoTest {
    private Participant participant;

    @BeforeEach
    void setUp() {
        participant = Participant.of(
                Arrays.asList(
                        "kwon",
                        "byeon",
                        "yun"));
    }

    @DisplayName("결과정보 생성 - 예외상황(참여자의 수와 결과가 다를 경우)")
    @Test
    void createWinInfoDifferent() {
        int participantCount = participant.count();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            PrizeInfo info = PrizeInfo.of("5000,꽝", participantCount);
        }).withMessageContaining("결과값이 참여자와 다릅니다.");
    }

    @DisplayName("결과정보 생성 - 예외상황(Null, Empty)")
    @ParameterizedTest
    @NullAndEmptySource
    void createWinInfoNull(String prizeInfo) {
        int participantCount = participant.count();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            PrizeInfo info = PrizeInfo.of(prizeInfo, participantCount);
        }).withMessageContaining("실행 결과 값이 없습니다.");
    }

    @DisplayName("index 번호를 통해 Prize 정보")
    @Test
    void getPrizeByIndex() {
        int participantCount = participant.count();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            PrizeInfo info = PrizeInfo.of("", participantCount);
        }).withMessageContaining("실행 결과 값이 없습니다.");
    }

    @DisplayName("Prize와 index 번호를 통해 일치하는 정보가 있는지 확인")
    @Test
    void matchAttribute() {
        int participantCount = participant.count();
        PrizeInfo info = PrizeInfo.of("1,2,3", participantCount);
        assertThat(info.matchAttribute(Prize.of("1"), 0)).isTrue();
    }
}
