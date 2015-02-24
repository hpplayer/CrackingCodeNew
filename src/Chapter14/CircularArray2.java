package Chapter14;

import java.util.Iterator;

public class CircularArray2<T> implements Iterable<T>{
	private T[] items;
	private int head = 0;
	
	public CircularArray2(int size) {
		items = (T[]) new Object[size];
	}
	
	private int convert(int index){

		if(index < 0 ){
			index += items.length;
		}
		return (head + index) % items.length;
		//return head + index;
	}
	
	public void rotate(int shiftRight){
		head = convert(shiftRight);
	}
	
	public T get(int i ){
		if(i < 0 || i >= items.length){
			throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item){
		items[convert(i)] = item;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIteator<T>(this);
	}
	
	private class CircularArrayIteator<T> implements Iterator{
		private int current = -1;
		private T[] items2;
		
		public CircularArrayIteator(CircularArray2<T> ary){
			items2 = ary.items;
		}
		
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<items.length -1;
		}

		public Object next() {
			// TODO Auto-generated method stub
			current++;
			T item = (T)items2[convert(current)];
			return item;
		}
		
	}
}
