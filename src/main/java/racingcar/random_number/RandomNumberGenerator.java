package racingcar.random_number;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.utils.Constants.*;

public class RandomNumberGenerator implements RandomNumber {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
