package racingcar.controller;

import racingcar.model.Cars;
import racingcar.move_strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.utils.Constants.ERROR_ATTEMPT_COUNT_NEGATIVE_MESSAGE;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;

    public RacingGameController(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        Cars cars = initializeCars();
        int attempts = inputAttempts();

        outputView.outputResult();
        startRacing(cars, attempts);
        outputView.outputFinalWinner(cars.getWinner());
    }

    private int inputAttempts() {
        int attempts = inputView.inputAttemptCount();
        validateAttempts(attempts);
        return attempts;
    }

    private void validateAttempts(int attempts) {
        if (isNegativeNumber(attempts)) {
            throw new IllegalArgumentException(ERROR_ATTEMPT_COUNT_NEGATIVE_MESSAGE);
        }
    }

    private Cars initializeCars() {
        return Cars.createCars(inputView.inputCarNames());
    }

    private void startRacing(Cars cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            cars.playRacing(moveStrategy);
            outputView.outputCurrentResult(cars.getCars());
        }
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }
}
