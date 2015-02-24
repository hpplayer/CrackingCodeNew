package Chapter11;

import java.util.Arrays;
import java.util.LinkedList;

public class Heap {
	LinkedList<Node> heap;
	public Heap(){
		heap = new LinkedList<Node>();
	}
	
	public void insert(Node n){
		boolean flag = false;
		//System.out.println(n.value);
		if(heap.isEmpty()){
			//n.setRank(0);
			//flag = true;
			heap.add(n);
		}else{
			for(int i = 0; i < heap.size(); i ++){
				//System.out.println("heap i value: " + heap.get(i).value + " n value " + n.value);
				if(heap.get(i).value > n.value){
					//System.out.println("I enter here 1");
					//System.out.println("value: " + n.value + " index: " + (i-1));
					if(i == 0){
						heap.addFirst(n);
						flag = true;
						break;
					}
					//System.out.println(n.value + " value " + (i));
					//System.out.println("I enter here 1");
					//System.out.println(n.value);
					heap.add(i, n);
					flag = true;
					break;
				}
			}
			if(!flag){
				//System.out.println("I enter here 2");
				//System.out.println(n.value);
				heap.addLast(n);
			}
		}
	}
	
	public int countRank(Node n){
		return heap.indexOf(n);
	}
	
	
}
