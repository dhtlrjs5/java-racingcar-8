package racingcar.model;

import racingcar.dto.CarDto;
import racingcar.move_strategy.MoveStrategy;

import static racingcar.utils.Constants.*;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public CarDto toDto() {
        return new CarDto(name, position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE_MESSAGE);
        }
    }
}