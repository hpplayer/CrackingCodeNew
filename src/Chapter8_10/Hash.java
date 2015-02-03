package Chapter8_10;

import java.util.LinkedList;

public class Hash<Key, Value> {
	int MAX_SIZE = 10;
	LinkedList<Node>[] items;
	
	public Hash(){
		items = (LinkedList<Node>[]) new LinkedList[MAX_SIZE];// we have to case the type
	}
	
	public class Node{
		Key key;
		Value value;
		public Node(Key key, Value value) {
			super();
			this.key = key;
			this.value = value;
		}
		public Key getKey() {
			return key;
		}
	
		
		public Value getValue() {
			return value;
		}
		boolean compareKey(Node node){
			return compareKey(node.getKey());
		}
		boolean compareKey(Key key){
			return this.key.equals(key);
		}
	}
	
	public int hashfunction(Key key){
		return key.toString().toCharArray().length % items.length;
	}
	
	public void put(Key key, Value value){
		 int index = hashfunction(key);
		 if(items[index].isEmpty())
			 items[index] = new LinkedList<Node>();
		 LinkedList<Node> collided = items[index];
		 
		 for(Node n:collided){
			 if (n.compareKey(key)){
				 collided.remove(n);//if collied is found, remove it
				 break;
			 }
		 }
		 
		Node node = new Node(key, value);
		collided.add(node);
	}
	
	public Value get(Key key){
		int index = hashfunction(key);
		 if(items[index].isEmpty())
			 return null;
		 LinkedList<Node> temp = items[index];
		 for(Node n: temp){
			 if(n.compareKey(key)){
				 return n.getValue();
			 }
		 }
		 return null;
	}
}
