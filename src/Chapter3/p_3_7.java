package Chapter3;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;
/*FIFO
 * LinkedList can use either poll() or removeFirst() to dequeue
 * LinkedList can use addLast to enqueue
 * LinkedList can use either peek() or getFirst() to peek the head node
 */
public class p_3_7 {
	LinkedList<Dog> dogq = new LinkedList<Dog>();
	LinkedList<Cat> catq = new LinkedList<Cat>();
	//Queue catq;
	private int id = 0;
	
	public static void main(String[] args) {
		p_3_7 animals = new p_3_7();
		Cat a = new Cat();
		a.setName("Callie");
		Cat b = new Cat();
		b.setName("Kiki");
		
		Dog c = new Dog();
		c.setName("Fido");
		
		Dog d = new Dog();
		d.setName("Dora");
		
		Cat e = new Cat();
		e.setName("Kari");
		
		Dog f = new Dog();
		f.setName("Dexter");
		
		Dog g = new Dog();
		g.setName("Dobo");
		
		Cat h = new Cat();
		h.setName("Copa");
		
		animals.enqueue(a);
		animals.enqueue(b);
		animals.enqueue(c);
		animals.enqueue(d);
		animals.enqueue(e);
		animals.enqueue(f);
		animals.enqueue(g);
		animals.enqueue(h);
		System.out.println(animals.dequeueAny().getName());	
		System.out.println(animals.dequeueAny().getName());	
		System.out.println(animals.dequeueAny().getName());	
		
		Dog i= new Dog();
		i.setName("Dapa");
		Cat j = new Cat();
		j.setName("Kilo");
		animals.enqueue(i);
		animals.enqueue(j);
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().getName());	
		}
	}
	
	public void enqueue(Animal a){
		a.setID(id);
		id++;
		if( a instanceof Cat){
			catq.addLast((Cat)a);
		}else{
			dogq.addLast((Dog)a);
		}	
	}
	public int size(){
		return catq.size() + dogq.size();
	}
	
	public Animal dequeueAny(){
		if(dogq.isEmpty()){
			return deququeCat();
		}
		else if (catq.isEmpty()){
			return deququeDog();
		}
		Dog firstDog = Dogpeek();
		Cat firstCat = Catpeek();
		if(firstDog.getID() > firstCat.getID() ){
			return deququeCat();
		}else{
			return deququeDog();
		}
		
	}
	
	public Animal peekAny(){
		if(dogq.isEmpty()){
			return Catpeek();
		}
		else if (catq.isEmpty()){
			return Dogpeek();
		}
		Dog firstDog = Dogpeek();
		Cat firstCat = Catpeek();
		if(firstDog.getID() > firstCat.getID() ){
			return firstCat;
		}else{
			return firstDog;
		}
		
	}
	
	
	public Cat deququeCat(){
		return catq.removeFirst();
		//return catq.poll();
	}
	public Dog deququeDog(){
		return dogq.removeFirst();
		//return dogq.poll();
	}
	public Cat Catpeek(){
		return catq.getFirst();
		//return catq.peek();
	}
	
	public Dog Dogpeek(){
		return dogq.getFirst();
		//return dogq.peek();
	}
	
	
}
