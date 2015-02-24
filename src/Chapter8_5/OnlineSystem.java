package Chapter8_5;

import java.util.HashMap;

public class OnlineSystem {
	
	/*My idea is using nested hashmap
	 * 
	 * first hashmap has the search key type
	 * nested hashmap has the search key book ISBN
	 *
	 */
	HashMap<BookType, HashMap> types;
	HashMap<String, Integer> ISBNlookup;

	public OnlineSystem(){
		types = new HashMap<BookType, HashMap>();
		for(BookType bt: BookType.values()){
			types.put(bt, new HashMap<Integer, Book>());
		}
		ISBNlookup = new HashMap<String, Integer>();
	}
	
	public void storeISBN(String name, Integer ISBN){
		ISBNlookup.put(name, ISBN);
	}
	
	public Integer searchISBN(String name){
		return ISBNlookup.get(name);
	}
	public Book searchbook(User user, BookType bookType, int ISBN){
		if(!types.containsKey(bookType)){
			return null;
		}else{
			if(!types.get(bookType).containsKey(ISBN)){
				return null;
			}else{
				Book temp = (Book) types.get(bookType).get(ISBN);
				user.currentBooks.add(temp);
				return temp;
			}
		}
	}
	
	
	
}
