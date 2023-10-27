package racingcar.model;

public class Car {

    private final Name name;
    private final Location location;
    private final IsWinner isWinner;

    public Car(Name name, Location location, IsWinner isWinner) {
        this.name = name;
        this.location = location;
        this.isWinner = isWinner;
    }

    public Car init(String carName) {
        return new Car(Name.init(carName), Location.init(), IsWinner.init());
    }
}
