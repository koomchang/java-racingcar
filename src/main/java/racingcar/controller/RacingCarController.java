package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCars;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfRoundsInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(
            new CarNamesInputValidator(),
            new NumberOfRoundsInputValidator()
    );

    public void run() {
        outputView.printAskingForCarNames();
        List<String> carNames = inputView.askForCarNames();
        RacingCars racingCars = RacingCars.init(carNames);
        outputView.printAskingForNumberOfRounds();
        int rounds = inputView.askForNumberOfRounds();
        outputView.printResult();
        for (int i = 0; i < rounds; i++) {
            racingCars = racingCars.move();
            outputView.printCarsLocation(racingCars);
        }
        RacingCars winners = racingCars.checkWinners();
        outputView.printWinners(winners);
    }
}
