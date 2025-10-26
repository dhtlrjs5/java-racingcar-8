package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

import static racingcar.utils.Constants.*;

public class OutputView {

    public void outputResult() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void outputCurrentResult(List<CarDto> cars) {
        cars.forEach(
                this::carRepresentation
        );
        System.out.println();
    }

    public void outputFinalWinner(List<CarDto> winners) {
        List<String> carNameList = toCarNameList(winners);

        System.out.println(FINAL_WINNER_MESSAGE_PREFIX + String.join(", ", carNameList));
    }

    private List<String> toCarNameList(List<CarDto> carList) {
        return carList.stream()
                .map(CarDto::name)
                .toList();
    }

    private void carRepresentation(CarDto car) {
        System.out.println(car.name() + NAME_POSITION_DELIMITER + "-".repeat(car.position()));
    }
}
