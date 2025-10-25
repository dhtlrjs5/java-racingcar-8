package racingcar.utils;

public final class Constants {

    //생성 금지
    private Constants() {
    }

    // Car.java
    public static final int NAME_MAX_LENGTH = 5;

    // RandomMoveStrategy.java
    public static final int MOVE_THRESHOLD = 4;

    // RandomNumberGenerator.java
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;

    // 공통 사용
    public static final String NAME_POSITION_DELIMITER = " : ";

    // OutputView.java
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String FINAL_WINNER_MESSAGE_PREFIX = "최종 우승자" + NAME_POSITION_DELIMITER;

    // InputView.java
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    // --- Error Messages Constants ---
    public static final String ERROR_PREFIX = "[ERROR] ";

    // Car.java
    public static final String NAME_LENGTH_ERROR_MESSAGE_MESSAGE = "자동차 이름은 1~5자 이내여야 합니다.";

    // Cars.java
    public static final String ERROR_DUPLICATE_NAME_MESSAGE = ERROR_PREFIX + "중복된 자동차 이름이 있습니다.";

    // RacingGameController.java
    public static final String ERROR_ATTEMPT_COUNT_NEGATIVE_MESSAGE = ERROR_PREFIX + "시도 횟수는 0이상 이여야 합니다.";

    // InputView.java
    public static final String ERROR_INPUT_MUST_BE_A_NUMBER_MESSAGE = ERROR_PREFIX + "시도 횟수는 Integer.MAX_VALUE 이하의 양수만 입력 가능합니다.";
}
