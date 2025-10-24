package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String INPUT_MUST_BE_A_NUMBER_MESSAGE = "시도 횟수는 숫자만 입력 가능합니다.";

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String cars = Console.readLine();

        return Arrays.asList(cars.split(","));
    }

    public int inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
        String attempts = Console.readLine();

        try {
            return Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MUST_BE_A_NUMBER_MESSAGE);
        }
    }
}
