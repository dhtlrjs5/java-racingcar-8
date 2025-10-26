package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void newCarTest() {
        //given
        Car car = new Car("car");
        CarDto carDto = car.toDto();

        //when

        //then
        assertThat(carDto.getName()).isEqualTo("car");
        assertThat(carDto.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이동 가능 테스트")
    void carMoveReturnTrueTest() {
        //given
        Car car = new Car("car");

        //when
        car.move(() -> true);
        CarDto carDto = car.toDto();

        //then
        assertThat(carDto.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 불가능 테스트")
    void carMoveReturnFalseTest() {
        //given
        Car car = new Car("car");

        //when
        car.move(() -> false);
        CarDto carDto = car.toDto();

        //then
        assertThat(carDto.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 IllegalArgumentException 발생")
    void carNameExceedMaxLengthTest() {
        //given
        String carName = "superCar";

        //when, then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 IllegalArgumentException 발생")
    void carNameIsBlankTest() {
        //given
        String carName = "";

        //when, then
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}