package Chapter8_5_sol2;

public class Book {
	private int bookID;
	private String details;
	
	public Book(int id, String det){
		bookID = id;
		details = det;
	}
	
	public void update(){
		
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
