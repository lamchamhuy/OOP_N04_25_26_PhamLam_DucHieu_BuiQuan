
public interface Animal {
   
    public void animalSound();
}

public class Dog implements Animal {
 
    @Override
    public void animalSound() {
      
        System.out.println("Dog is barking");
    }

    public static void main(String[] args){
        Dog dog = new Dog();
        dog.animalSound();
    }
}
