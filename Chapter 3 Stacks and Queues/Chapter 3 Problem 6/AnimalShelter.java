import java.util.LinkedList;
import java.util.Random;

/**
* Animal shelter class that follows the following rules:
* - Holds only dogs and cats
* - Must adapt the oldest of either type
*/
public class AnimalShelter{
  private LinkedList<Dog> dogs;
  private LinkedList<Cat> cats;

  public AnimalShelter(){
    dogs = new LinkedList<Dog>();
    cats = new LinkedList<Cat>();
  }

  /**
  * Adds an animal to the appropriate queue
  */
  public void enqueue(Object animal){
    if(animal instanceof Dog){
      dogs.add(animal);
    }else{
      cats.add(animal);
    }
  }

  public Object dequeueAny(){
    //coin flip for animals life
    Random randNum = new Random();
    int randomNumber = randNum.nextInt(2);//should be 0 or 1
    if(randomNumber == 0){
      return dogs.removeFirst();
    }else{
      return cats.removeFirst();
    }
  }

  public Object dequeueDog(){
    return dogs.removeFirst();
  }

  public Object dequeueCat(){
    return cats.removeFirst();
  }

  public boolean enqueueDog(Dog d){
    dogs.add(d);
  }

  public boolean enqueueCat(Cat c){
    cats.add(c);
  }

}
