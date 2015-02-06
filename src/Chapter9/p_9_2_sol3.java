package Chapter9;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.*;

import CtCILibrary.AssortedMethods;

public class p_9_2_sol3 {
	public static int size = 5;
	public static int[][] maze = new int[size][size];
	
	public static boolean isFree(int x, int y) {
		if (maze[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache){
		if(x > size-1 || y > size -1 || !isFree(x,y)){
			return false;
		}
		
		Point p = new Point(x,y);// we need to check the point p if it has been checked before, so we create point here instead later
		if(cache.containsKey(p)){
			return cache.get(p);
		}
		
		boolean isAtFinal = (x==size-1) && (y == size -1);
		boolean success = false;
		
		if(isAtFinal || getPath(x, y+1, path, cache) || getPath(x+1, y, path, cache)){
			path.add(p);
			success = true;
		}
		
		cache.put(p, success);
		return success;
	}
	
	public static void main(String[] args) {
		maze = AssortedMethods.randomMatrix(size, size, 0, 5);
		AssortedMethods.printMatrix(maze);
		ArrayList<Point> path = new ArrayList<Point>();
		Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
		//boolean success = getPath(size - 1, size - 1, path, cache);
		boolean success = getPath(0, 0, path, cache);
		
		if (success) {
			String s = AssortedMethods.listOfPointsToString(path);
			System.out.println("Path: " + " " + s);			
		} else {
			System.out.println("No path exists.");
		}
	}
}
