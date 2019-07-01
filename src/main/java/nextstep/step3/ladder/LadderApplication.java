package nextstep.step3.ladder;

import nextstep.step3.ladder.domain.Ladder;
import nextstep.step3.ladder.domain.Participant;
import nextstep.step3.ladder.util.StringUtil;
import nextstep.step3.ladder.view.InputView;
import nextstep.step3.ladder.view.ResultView;
import nextstep.step3.ladder.view.impl.InputViewImpl;
import nextstep.step3.ladder.view.impl.ResultViewImpl;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 01:57
 */
public class LadderApplication {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderApplication() {
        this.inputView = new InputViewImpl();
        this.resultView = new ResultViewImpl();
    }

    public static void main(String[] args) {
        LadderApplication app = new LadderApplication();
        app.run();
    }

    public void run() {
        // 사용자 이름 입력
        String customNames = inputView.inputCustomNames();
        // 사용자 생성
        Participant participant = Participant.of(StringUtil.split(customNames));
        // 실행 결과를 입력
        String executionResult = inputView.inputExecutionResult();
        StringUtil.split(executionResult);

        // 사다리 높이 입력받기
        int ladderHeight = inputView.inputLadderHeight();
        // 사다리 생성 (사용자 수, 사다리 높이)
        Ladder ladder = new Ladder(participant.count(), ladderHeight);
        // 사용자 이름 출력
        resultView.printCustoms(participant);
        // 사다리 출력
        resultView.printLadder(ladder);
    }
}