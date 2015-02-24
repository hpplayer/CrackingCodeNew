package Chapter9;

import java.util.ArrayList;
import java.util.HashMap;

public class p_9_10_sol2 {
	public static class Box {
		public int width;
		public int height;
		public int depth;

		public Box(int width, int height, int depth) {
			super();
			this.width = width;
			this.height = height;
			this.depth = depth;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}

		public boolean canBeAbove(Box b) {
			if (b == null) {
				return true;
			}
			if (width < b.getWidth() && height < b.getHeight()
					&& depth < b.getDepth()) {
				return true;
			}
			return false;
		}

		public String toString() {
			return "Box(" + width + "," + height + "," + depth + ")";
		}
	}

	public static int stackHeight(ArrayList<Box> boxes) {
		if (boxes == null) {
			return 0;
		}
		int h = 0;
		for (Box b : boxes) {
			h += b.height;
		}
		return h;
	}
	public static ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> stack_map){
		if(bottom != null && stack_map.containsKey(bottom)){
			return (ArrayList<Box>) stack_map.get(bottom).clone();//using clone, dont ruin the list
		}
		
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for(int i = 0; i < boxes.length; i++){
			if(boxes[i].canBeAbove(bottom)){
				ArrayList<Box> new_stack = createStackDP(boxes, boxes[i], stack_map);
				int new_height = stackHeight(new_stack);
				if(new_height > max_height){
					max_height = new_height;
					max_stack = new_stack;
				}
			}
		}
		
		if(max_stack == null) max_stack = new ArrayList<Box>();
		if(bottom != null){
			max_stack.add(0, bottom);
		}
		stack_map.put(bottom, max_stack);
		return max_stack;
		
	}
	public static ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		// every box is treated as first layer bottom once;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);// i's
																			// bottom
																			// will
																			// fiter
																			// itself,
																			// once
																			// it
																			// is
																			// on
																			// list,
																			// no
																			// smaller
																			// boxes
																			// can
																			// be
																			// added
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_height = new_height;
					max_stack = new_stack;
				}
			}
		}

		// after the last box added to the boxes each recursion
		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);// if we need refresh
		}
		return max_stack;
	}

	public static void main(String[] args) {
		Box[] boxes = { new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3) };

		 ArrayList<Box> stack = createStackDP(boxes, null, new HashMap<Box, ArrayList<Box>>());
	//	ArrayList<Box> stack = createStackR(boxes, null);
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.println(b.toString());
		}
	}
}
