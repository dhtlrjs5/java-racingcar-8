package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성 테스트")
    void newCarsTest() {
        //given
        Cars cars = Cars.createCars(List.of("Car1", "Car2", "Car3", "Car4"));
        List<Car> carList = cars.getCars();

        //when

        //then
        assertThat(carList.size()).isEqualTo(4);
        assertThat(carList.getFirst().getName()).isEqualTo("Car1");
        assertThat(carList.getLast().getName()).isEqualTo("Car4");
    }

    @Test
    @DisplayName("우승자가 한명일 때")
    void soloWinnerTest() {
        //given
        Cars cars = Cars.createCars(List.of("Car1", "Car2", "Car3", "Car4"));

        //when
        AtomicInteger incrementNumber = new AtomicInteger();
        cars.playRacing(() -> {
            int winnerNumber = incrementNumber.getAndIncrement();
            return winnerNumber == 0;
        });
        List<Car> winner = cars.getWinner();

        //then
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.getFirst().getName()).isEqualTo("Car1");
    }

    @Test
    @DisplayName("우승자가 여러명일 때")
    void multiWinnerTest() {
        //given
        Cars cars = Cars.createCars(List.of("Car1", "Car2", "Car3", "Car4"));

        //when
        AtomicInteger incrementNumber = new AtomicInteger();
        cars.playRacing(() -> {
            int winnerNumber = incrementNumber.getAndIncrement();
            return winnerNumber != 0;
        });
        List<Car> winners = cars.getWinner();

        //then
        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("Car2", "Car3", "Car4");
    }

    @Test
    @DisplayName("중복된 이름이 있으면 IllegalArgumentException 발생")
    void throwIllegalArgumentExceptionWhenDuplicateName() {
        assertThatThrownBy(() -> Cars.createCars(List.of("Car1", "Car1", "Car3", "Car4")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}