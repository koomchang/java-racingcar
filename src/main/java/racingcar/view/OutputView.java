package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class OutputView {

    public void printAskingForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskingForNumberOfRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCarsLocation(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.racingCarList()) {
            printCarCurrentLocation(racingCar);
        }
        System.out.println();
    }

    private void printCarCurrentLocation(RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getLocation()));
    }

    public void printWinners(RacingCars winners) {
        int winnerCount = 0;
        System.out.print("최종 우승자 : ");
        for (RacingCar racingCar : winners.racingCarList()) {
            System.out.print(racingCar.getName());
            winnerCount += 1;
            printComma(winners, winnerCount);
        }
    }

    private void printComma(RacingCars winners, int winnerCount) {
        if (winnerCount < winners.racingCarList().size()) {
            System.out.print(", ");
        }
    }

}
