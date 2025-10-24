package racingcar.model;

import racingcar.move_strategy.MoveStrategy;

public class Car {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 1~5자 이내여야 합니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
