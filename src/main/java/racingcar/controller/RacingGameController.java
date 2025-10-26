package racingcar.controller;

import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.move_strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

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
        outputView.outputFinalWinner(getWinners(cars));
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
            outputView.outputCurrentResult(toCarDtoList(cars));
        }
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private List<CarDto> toCarDtoList(Cars cars) {
        List<Car> carList = cars.getCars();

        return carList.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .toList();
    }

    private List<CarDto> getWinners(Cars cars) {
        List<Car> winners = cars.getWinner();

        return winners.stream()
                .map(winner -> new CarDto(winner.getName(), winner.getPosition()))
                .toList();
    }
}
