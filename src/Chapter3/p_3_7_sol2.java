package Chapter3;

import java.util.LinkedList;

public class p_3_7_sol2 {
	LinkedList<Dog2> Dog2s = new LinkedList<Dog2>();
	LinkedList<Cat2> Cat2s = new LinkedList<Cat2>();
	private int order = 0;
	public static void main(String[] args) {
		p_3_7_sol2 animals = new p_3_7_sol2();
		animals.enqueue(new Cat2("Callie"));
		animals.enqueue(new Cat2("Kiki"));
		animals.enqueue(new Dog2("Fido"));
		animals.enqueue(new Dog2("Dora"));
		animals.enqueue(new Cat2("Kari"));
		animals.enqueue(new Dog2("Dexter"));
		animals.enqueue(new Dog2("Dobo"));
		animals.enqueue(new Cat2("Copa"));
		
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dog2("Dapa"));
		animals.enqueue(new Cat2("Kilo"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}
	}
	public void enqueue(Animal2 a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog2) {
			Dog2s.addLast((Dog2) a);
		} else if (a instanceof Cat2) {
			Cat2s.addLast((Cat2)a);
		}
	}
	
	public Animal2 dequeueAny() {
		if (Dog2s.size() == 0) {
			return dequeueCat2s();
		} else if (Cat2s.size() == 0) {
			return dequeueDog2s();
		}
		Dog2 Dog2 = Dog2s.peek();
		Cat2 Cat2 = Cat2s.peek();
		if (Dog2.isOlderThan(Cat2)) {
			return Dog2s.poll();
		} else {
			return Cat2s.poll();
		}
	}
	
	public Animal2 peek() {
		if (Dog2s.size() == 0) {
			return Cat2s.peek();
		} else if (Cat2s.size() == 0) {
			return Dog2s.peek();
		}
		Dog2 Dog2 = Dog2s.peek();
		Cat2 Cat2 = Cat2s.peek();
		if (Dog2.isOlderThan(Cat2)) {
			return Dog2;
		} else {
			return Cat2;
		}
	}
	
	public int size() {
		return Dog2s.size() + Cat2s.size();
	}
	
	public Dog2 dequeueDog2s() {
		return Dog2s.poll();
	}
	
	public Dog2 peekDog2s() {
		return Dog2s.peek();
	}
	
	public Cat2 dequeueCat2s() {
		return Cat2s.poll();
	}
	
	public Cat2 peekCat2s() {
		return Cat2s.peek();
	}
}
