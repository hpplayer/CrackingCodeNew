package Chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/*
 * not right.
 * we cant always take highest height
 * since we may have more boxes with mid height
 * 
 */
public class p_9_10 {
	public static class box{
		int height;
		int width;
		int depth;
		public box(int h, int w, int d){
			this.height = h;
			this.width = w;
			this.depth = d;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getDepth() {
			return depth;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
		public String toString() {
			return "Box(" + width + "," + height + "," + depth + ")";
		}
		
	}
	public static int countBoth(int d, int w, ArrayList<box> boxes){
		int count = 0;
		for(box b: boxes){
			if(b.getDepth() > d && b.getWidth()>w){
				count++;
			}
		}
		return count;

	}
	
	public static void sortOnHeight(ArrayList<box> boxes){
		Collections.sort(boxes, new Comparator<box>(){
			public int compare(box a, box b){
				return (a.getHeight() - b.getHeight());
			}
		});
	}
	public static ArrayList<box> test(ArrayList<box> boxes){
		return test(boxes, new ArrayList<box>());
	}
	
	public static ArrayList<box> test(ArrayList<box> boxes, ArrayList<box> targets){
		if(boxes.isEmpty()){
			return targets;
		}
		sortOnHeight(boxes);
		ArrayList<box> boxes2 = (ArrayList<box>) boxes.clone();
		box temp = boxes.get(0);
		for(box b: boxes){
			if(b.getHeight() == temp.getHeight()){
				if(countBoth(temp.getDepth(), temp.getWidth(), boxes2) < countBoth(b.getDepth(), b.getWidth(), boxes2)){
					temp = b;
					boxes2 = (ArrayList<box>) boxes2.subList(boxes2.indexOf(b), boxes2.size()-1);
					boxes2.remove(b);
					targets.add(b);
				}
			}else{
				targets.add(temp);
				boxes2.remove(temp);
				test(boxes2, targets);
			}
		}

		
		return targets;
	}
	
	public static void main(String[] args) {
		ArrayList<box> boxes = new ArrayList<box>();
		boxes.add(new box(3, 4, 1));
		boxes.add(new box(8, 6, 2));
		boxes.add(new box(7, 8, 3));
		
		ArrayList<box> stack = test(boxes);
		//ArrayList<Box> stack = createStackR(boxes, null);		
		for (int i = stack.size() - 1; i >= 0; i--) {
			box b = stack.get(i);
			System.out.println(b.toString());
		}
	}
}
