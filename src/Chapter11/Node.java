package Chapter11;

import java.util.ArrayList;


public class Node implements Comparable<Node>{
	int value;

	
	public Node(int value) {
		super();
		this.value = value;
	}
	


	public int compareTo(Node o) {
		Node other =(Node) o;
		return ((Integer) this.value).compareTo((Integer) other.value);
	}	
}
