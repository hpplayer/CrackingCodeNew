package Chapter14;

import java.util.ArrayList;

public class CircularArray<T> extends ArrayList<T>{
		
	public void rotate(int n){
		int size = this.size();
		for(int i = 0; i < n; i++){
			this.add(size, this.get(0));
			this.remove(0);
		}
	}
}
