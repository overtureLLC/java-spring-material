public class Animal {
  public void makeSound() {
    System.out.println("The animal makes a sound");
  }
}

public class Pig extends Animal {
    @Override    
    public void makeSound() {
        System.out.println("The pig says: ....");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog says: ....");
    }
}

public class SoundTest {
    public void tryMakeSound(Animal animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        SoundTest s = new SoundTest();
        s.tryMakeSound(new Dog());
        s.tryMakeSound(new Pig());
    }
} 