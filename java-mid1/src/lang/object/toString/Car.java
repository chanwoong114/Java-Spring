package lang.object.toString;

public class Car {

    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "carName = " + carName;
    }
}
