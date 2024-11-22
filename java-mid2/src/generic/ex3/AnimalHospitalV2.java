package generic.ex3;

import generic.animal.Animal;

public class AnimalHospitalV2<T> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
//        System.out.println("동물 이름 : " + animal.getName());
//        System.out.println("동물 크기: " + animal.getSize());
//        animal.sound();
        // T의 타입을 메서서를 정의하는 시점에은 알 수 없다. Object 의 기능만 사용 가능
        animal.toString();
    }

    public T getBigger(Animal target) {
//        return animal.getSize() > target.getSize() ? animal : target;
        return null;
    }
}
