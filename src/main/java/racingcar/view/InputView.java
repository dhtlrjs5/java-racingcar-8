package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.utils.Constants.*;

public class InputView {

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String cars = Console.readLine();

        return Arrays.asList(cars.split(","));
    }

    public int inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
        String attempts = Console.readLine();

        return convertAttempt(attempts);
    }

    private int convertAttempt(String attempts) {
        try {
            return Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_MUST_BE_A_NUMBER_MESSAGE);
        }
    }
}
