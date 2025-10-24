package racingcar.move_strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomMoveStrategyTest {

    @Test
    @DisplayName("랜덤수가 4이상이면 true")
    void isMovableReturnFalseTest() {
        //given
        MoveStrategy moveStrategy = new RandomMoveStrategy(() -> 5);

        //when
        boolean movable = moveStrategy.isMovable();

        //then
        assertThat(movable).isTrue();
    }

    @Test
    @DisplayName("랜덤수가 4미만이면 true")
    void isMovableReturnTrueTest() {
        //given
        MoveStrategy moveStrategy = new RandomMoveStrategy(() -> 3);

        //when
        boolean movable = moveStrategy.isMovable();

        //then
        assertThat(movable).isFalse();
    }
}