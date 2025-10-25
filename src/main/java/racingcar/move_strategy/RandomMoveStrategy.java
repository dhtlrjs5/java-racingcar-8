package racingcar.move_strategy;

import racingcar.random_number.RandomNumber;

import static racingcar.utils.Constants.MOVE_THRESHOLD;

public class RandomMoveStrategy implements MoveStrategy {

    private final RandomNumber randomNumber;

    public RandomMoveStrategy(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMovable() {
        return randomNumber.generate() >= MOVE_THRESHOLD;
    }
}
