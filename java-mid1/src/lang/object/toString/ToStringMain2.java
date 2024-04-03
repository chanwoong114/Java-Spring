package lang.object.toString;

public class ToStringMain2 {

    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 5);


        System.out.println(car.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());


        System.out.println(car);
        System.out.println(dog1);
        System.out.println(dog2);

        ObjectPrinter.print(car);
        ObjectPrinter.print(dog1);
        ObjectPrinter.print(dog2);

        String i = Integer.toHexString(System.identityHashCode(dog1));
        System.out.println(i);
    }
}
