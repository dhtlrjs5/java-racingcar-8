package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

public class Car {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 1~5자 이내여야 합니다.";

    private final String name;
    private final RandomNumberGenerator randomNumberGenerator;
    private int position = 0;

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        validateName(name);
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
    }

    public void move() {
        if (randomNumberGenerator.canMove()) {
            position++;
        }
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    /**
     * getter, setter를 사용했는가? 에 위반
     * 추후 DTO로 처리?
     */
    public String getName() {
        return name;
    }
}
