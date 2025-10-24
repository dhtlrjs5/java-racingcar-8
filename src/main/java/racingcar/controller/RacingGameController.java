package racingcar.controller;

import racingcar.model.Cars;
import racingcar.move_strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        Cars cars = Cars.createCars(inputView.inputCarNames());
        int attempts = inputView.inputAttemptCount();

        outputView.outputResult();

        for (int i = 0; i < attempts; i++) {
            cars.playRacing(moveStrategy);
            outputView.outputCurrentResult(cars.getCars());
        }

        outputView.outputFinalWinner(cars.getWinner());
    }
}
