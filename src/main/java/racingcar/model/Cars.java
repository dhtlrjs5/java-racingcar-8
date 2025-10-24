package racingcar.model;

import racingcar.move_strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 자동차 이름이 있습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames) {
        validateDuplicateName(carNames);

        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void playRacing(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(cars -> cars.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static void validateDuplicateName(List<String> carNames) {
        long distinctSize = carNames.stream()
                .distinct()
                .count();

        if (distinctSize != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }
}
