package racingcar.move_strategy;

import racingcar.random_number.RandomNumber;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVING_THRESHOLD = 4;

    private final RandomNumber randomNumber;

    public RandomMoveStrategy(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMovable() {
        return randomNumber.generate() >= MOVING_THRESHOLD;
    }
}
