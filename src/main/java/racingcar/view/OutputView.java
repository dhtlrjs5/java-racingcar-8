package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.utils.Constants.*;

public class OutputView {

    public void outputResult() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void outputCurrentResult(List<Car> cars) {
        cars.forEach(
                car -> System.out.println(car.getRepresentation())
        );
        System.out.println();
    }

    public void outputFinalWinner(List<Car> winners) {
        List<String> carNameList = toCarNameList(winners);

        System.out.println(FINAL_WINNER_MESSAGE_PREFIX + String.join(", ", carNameList));
    }

    private List<String> toCarNameList(List<Car> carList) {
        return carList.stream()
                .map(Car::getName)
                .toList();
    }
}
