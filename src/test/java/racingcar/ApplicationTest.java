package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 0이면 모두 우승")
    void AllCarsWinnerWhenAttemptIsZero() {
        //given
        String carNames = "pobi,woni,jun";
        String attempts = "0";

        //when
        run(carNames, attempts);

        //then
        assertThat(output()).contains("최종 우승자 : pobi, woni, jun");
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외 발생")
    void throwExceptionWhenCarNameIsEmpty() {
        assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외 발생")
    void throwExceptionWhenCarNameIsBlank() {
        assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void throwExceptionWhenCarNameExceedsFiveChars() {
        assertThatThrownBy(() -> runException("pobi,woni,junjun", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외 발생")
    void throwExceptionWhenCarNameIsDuplicated() {
        assertThatThrownBy(() -> runException("pobi,pobi,jun", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 빈 값이면 예외 발생")
    void throwExceptionWhenAttemptIsEmpty() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", ""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 공백이면 예외 발생")
    void throwExceptionWhenAttemptIsBlank() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", " "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    void throwExceptionWhenAttemptIsNotNumber() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 음수이면 예외 발생")
    void throwExceptionWhenAttemptIsNegative() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 소수이면 예외 발생")
    void throwExceptionWhenAttemptIsDecimal() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "1.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 Integer 최대값을 초과하면 예외 발생")
    void throwExceptionWhenAttemptOverflows() {
        assertThatThrownBy(() -> runException("pobi,woni,jun", "3000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
