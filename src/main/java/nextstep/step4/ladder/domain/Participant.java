package nextstep.step4.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:15
 */
public class Participant {
    private List<Name> names;

    public Participant(List<Name> names) {
        this.names = names;
    }

    public static Participant of(List<String> names) {
        if (null == names || names.isEmpty()) {
            throw new IllegalArgumentException("사람이 입력되지 않았습니다.");
        }

        return new Participant(names.stream()
                .distinct()
                .filter(name -> !"".equals(name))
                .map(name -> Name.of(name.trim()))
                .collect(Collectors.toList()));
    }

    public int count() {
        return names.size();
    }

    public Stream<Name> stream() {
        return names.stream();
    }

    public Name findNameByIndex(int findIndex) {
        return names.stream()
                .filter(name -> names.get(findIndex).equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
