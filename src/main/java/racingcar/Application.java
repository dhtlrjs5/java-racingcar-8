package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.move_strategy.MoveStrategy;
import racingcar.move_strategy.RandomMoveStrategy;
import racingcar.random_number.RandomNumber;
import racingcar.random_number.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomNumber randomNumber = new RandomNumberGenerator();
        MoveStrategy moveStrategy = new RandomMoveStrategy(randomNumber);

        RacingGameController racingGameController = new RacingGameController(inputView, outputView, moveStrategy);

        racingGameController.run();
    }
}