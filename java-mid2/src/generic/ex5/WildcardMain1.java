package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {

    public static void main(String[] args) {
        Box<Object> box = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);

        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);

        // 입력한 값을 그대로 받고 싶지만 와일드 카드에서는 제너릭 설정이 되지 않기 때문에
        // 그대로 반납하는 것이 아닌 가능한 최상단이나 지정해준 타입으로만 가능하다
        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);

    }
}
