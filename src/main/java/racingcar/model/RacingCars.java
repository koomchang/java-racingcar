package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCarList;

    public RacingCars(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public static RacingCars init(List<String> carNameList) {
        List<RacingCar> initRacingCarList = new ArrayList<>();
        for (String carName : carNameList) {
            initRacingCarList.add(RacingCar.init(carName));
        }
        return new RacingCars(initRacingCarList);
    }

    public RacingCars move() {
        List<RacingCar> movedRacingCarList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            RacingCar movedCar = racingCar.move();
            movedRacingCarList.add(movedCar);
        }
        return new RacingCars(movedRacingCarList);
    }

    public RacingCars findWinners() {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            updateWinnerListIfMaxLocation(racingCar, winners);
        }
        return new RacingCars(winners);
    }

    private void updateWinnerListIfMaxLocation(RacingCar racingCar, List<RacingCar> winners) {
        if (racingCar.getLocation() == getMaxLocation()) {
            winners.add(racingCar);
        }
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (RacingCar racingCar : racingCarList) {
            int location = racingCar.getLocation();
            maxLocation = updateMaxIfGreater(location, maxLocation);
        }
        return maxLocation;
    }

    private int updateMaxIfGreater(int location, int maxLocation) {
        if (location > maxLocation) {
            maxLocation = location;
        }
        return maxLocation;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
