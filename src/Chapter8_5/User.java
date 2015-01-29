package Chapter8_5;

import java.util.ArrayList;

public class User {
	int ID;
	String username;
	ArrayList<Book> currentBooks;
	
	public User(){
		currentBooks = new ArrayList<Book>();
	}
}
