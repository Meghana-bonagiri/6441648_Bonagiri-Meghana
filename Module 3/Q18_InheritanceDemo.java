class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class Q18_InheritanceDemo {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        genericAnimal.makeSound();  // Output: Animal makes a sound

        Dog dog = new Dog();
        dog.makeSound();  // Output: Bark
    }
}
