package nextstep.ladder;

import nextstep.ladder.domain.Custom;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.util.StringUtil;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.impl.InputViewImpl;
import nextstep.ladder.view.impl.ResultViewImpl;

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
        Custom custom = Custom.of(StringUtil.split(customNames));
        // 사다리 높이 입력받기
        int ladderHeight = inputView.inputLadderHeight();
        // 사다리 생성 (사용자 수, 사다리 높이)
        Ladder ladderLine = new Ladder(custom.count(), ladderHeight);
        // 사용자 이름 출력
        resultView.printCustoms(custom);
    }
}
