package Queue;

import java.util.LinkedList;

/* An animal shelter holds only dogs and cats, and operates on a strictly "first in,
first out" basis. People must adopt either the "oldest" (based on arrival time) of
all animals at the shelter, or they can select whether they would prefer a dog or
a cat (and will receive the oldest animal of that type). They cannot select which
specificanimal they would like. Create the data structures to maintain this system
and implement operations such as enqueue, dequeueAny, dequeueDog and
dequeueCat.You may use the built-in LinkedList data structure.*/
public class AnimalShelter {

	public static void main(String[] args) {
		
		AnimalQueue aq = new AnimalQueue();		
		aq.enqueue(new Dog("tommy"));
		aq.enqueue(new Dog("sheru"));				
		aq.enqueue(new Cat("kitty"));
		aq.enqueue(new Cat("titi"));
		
		Animal an = (Animal) aq.dequeueAny();
		
		System.out.println(an.name);		
		an = (Animal) aq.dequeueCat();
		System.out.println(an.name);		
	}

}
abstract class Animal 
{
	int order;
	String name;
	Animal(String name) {
		this.name = name;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getOrder() {
		return order;
	}
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}	
}

class Dog extends Animal 
{
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal 
{
	public Cat(String name) {
		super(name);
	}
}

class AnimalQueue 
{	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0; // timestamp
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) dogs.addLast((Dog) a);
		if (a instanceof Cat) cats.addLast((Cat) a);
	}
	
	public Animal dequeueAny() {
		Dog d = dogs.peek();
		Cat c = cats.peek();		
		if (d.isOlderThan(c)) return dequeueDog(); else return dequeueCat();		
	}
	
	public Dog dequeueDog() {
		return dogs.poll();
	}
	
	public Cat dequeueCat() {
		return cats.poll();
	}
}


