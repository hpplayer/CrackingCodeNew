package Chapter8_9_sol2;

public class Question {
	public static void main(String[] args) {
		Directory root = new Directory("Food", null); //root
		File taco = new File("Taco", root, 4); //1
		File hamburger = new File("Hamburger", root, 9); //1
		root.addEntry(taco);
		root.addEntry(hamburger);
		
			Directory healthy = new Directory("Healthy", root);//1
		
				Directory fruits = new Directory("Fruits", healthy);//2
					File apple = new File("Apple", fruits, 5);
					File banana = new File("Banana", fruits, 6);
				fruits.addEntry(apple);//3
				fruits.addEntry(banana);//3
				
			healthy.addEntry(fruits);
				
				Directory veggies = new Directory("Veggies", healthy);//2
					File carrot = new File("Carrot", veggies, 6);
					File lettuce = new File("Lettuce", veggies, 7);
					File peas = new File("Peas", veggies, 4);
				veggies.addEntry(carrot);
				veggies.addEntry(lettuce);
				veggies.addEntry(peas);
			
			healthy.addEntry(veggies);
			
		root.addEntry(healthy);
		
		System.out.println(root.numberOfFiles());
		System.out.println(veggies.getFullPath());
	}
}
