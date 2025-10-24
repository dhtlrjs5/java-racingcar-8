package racingcar.model;

import racingcar.move_strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void playRacing(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public void printCurrentRacing() {
        cars.forEach(
                car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()))
        );
        System.out.println();
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
}
