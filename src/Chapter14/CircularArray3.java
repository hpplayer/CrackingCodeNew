package Chapter14;

import java.util.Iterator;

public class CircularArray3<T> implements Iterable<T>{
	private T[] arrays;
	private int head = 0;
	public CircularArray3(int n ){
		arrays = (T[]) new Object[n]; 
	}
	private int convert(int index){
		if(index < 0){
			index = index + arrays.length;
		}
		return (index + head) % arrays.length;
	}

	public void rotate(int n){
		head = convert(n);
	}

	public T get(int n){
		if(n<0 || n >= arrays.length){
			return null;
		}
		return arrays[convert(n)];
	}

	public void set(int n, T item){
		arrays[convert(n)] = item;
	}

	public Iterator<T> iterator(){
		return new CircularArrayIterator<T>(this);
	}

	private class CircularArrayIterator<T> implements Iterator{
		private int current = -1;
		private T[] items;
		public CircularArrayIterator(CircularArray3<T> ary){
			items = ary.arrays;
		}

		public boolean hasNext(){
			return current < items.length -1;
		}

		public Object next(){
			current ++;
			T item = (T) items[convert(current)];
			return item;
		}
	}

}