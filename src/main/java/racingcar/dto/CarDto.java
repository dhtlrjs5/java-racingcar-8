package racingcar.dto;

import static racingcar.utils.Constants.NAME_POSITION_DELIMITER;

public class CarDto {

    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getRepresentation() {
        return name + NAME_POSITION_DELIMITER + "-".repeat(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
