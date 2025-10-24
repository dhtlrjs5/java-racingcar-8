package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자" + NAME_POSITION_DELIMITER;

    public void outputResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void outputFinalWinnerMessage(List<Car> winners) {
        List<String> carNameList = toCarNameList(winners);

        System.out.println(FINAL_WINNER_MESSAGE + String.join(", ", carNameList));
    }

    private List<String> toCarNameList(List<Car> carList) {
        return carList.stream()
                .map(Car::getName)
                .toList();
    }
}
