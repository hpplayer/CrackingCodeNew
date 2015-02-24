package Chapter8_10and8_10_sol2;

import java.util.LinkedList;

public class Hash<Key, Value> {
	
	int MAX_SIZE = 10;
	Node HeadNode;
	LinkedList<Node>[] items;
	
	// a helper linked list data type
	private class Node{
		private Key key;
		private Value val;
		
		public Node(Key key, Value val){
			this.key = key;
			this.val = val;
		}
		
		
		public Key getKey() {
			return key;
		}


		public Value getVal() {
			return val;
		}

		public String toString(){
			return "(" + key.toString() + ", " + val.toString()  + ")";
		}
		
		public boolean equivalent(Node n){
			return equivalent(n.getKey());
		}
		
		public boolean equivalent(Key k){
			return k.equals(key);
		}
	}
	
	public Hash(){
		items = new LinkedList[MAX_SIZE];
	}
	
	public int hashFunction(Key key){
		char[] ary = key.toString().toCharArray();
		int sum = 0;
		for(char c: ary){
			sum += (int) c;
		}
		/*
		if(key == "Maxwell"){
			System.out.println(sum);
			System.out.println(ary.length);
			System.out.println( sum % ary.length);	
		}
		 */
		return sum % items.length;
	}

	public void put(Key key, Value value){
		int x = hashFunction(key);
		
		if(items[x] == null){
			items[x] = new LinkedList<Node>();
		}
		
		LinkedList<Node> collided = items[x];
		
		for(Node c: collided){
			if(c.equivalent(key)){
				collided.remove(c); //if we need replace it
				break;
			}
		}
		
		Node node = new Node(key, value);
		collided.add(node);
	}
	
	
	public Value get(Key key){
		int x = hashFunction(key);
		if(items[x] == null){
			return null;
		}
		
		LinkedList<Node> collided = items[x];
		for(Node c: collided){//check collided
			if(c.equivalent(key)){
				return c.getVal();
			}
		}
		
		return null;//if found nothing for this key
	}
	
	public void debugPrintHash() {
		for (int i = 0; i < items.length; i++) {
			System.out.print(i + ": ");
			LinkedList<Node> list = items[i];
			if (list != null) {
				for (Node cell : list) {
					System.out.print(cell.toString() + ", ");
				}
			}
			System.out.println("");
		}
	}
	
}
