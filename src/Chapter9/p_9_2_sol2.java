package Chapter9;

import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.*;

import CtCILibrary.AssortedMethods;

public class p_9_2_sol2 {
	public static int size = 5;
	public static int[][] maze = new int[size][size];
	public static boolean isFree(int x, int y) {
		if (maze[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}
	/*
	 * my revised version which search for end point from 0,0
	 */
	public static boolean getPath(int x, int y, ArrayList<Point> path) {
		if (x >  size-1 || y > size-1 || !isFree(x, y)) { // !isFree -> [x][y] = 0
			return false;
		}
		
		boolean isAtFinal = (x == size-1) && (y == size-1); //destination: 5, 5
		
		//if there is a path from my current to end, add it
		if(isAtFinal || getPath(x, y+1, path) || getPath(x+1, y, path)){
			Point p = new Point(x,y);
			path.add(p);
			return true;
		}
		return false;
	}
	
	/*
	 * original version which search for start point from destination
	 */
	public static boolean getPath2(int x, int y, ArrayList<Point> path) {
		// If out of bounds or not available, return.
		if (y < 0 || x < 0 || !isFree(x, y)) {
			return false;
		}
		
		boolean isAtOrigin = (x == 0) && (y == 0);
		
		// If there's a path from the start to my current location, add my location.
		if (isAtOrigin || getPath2(x, y - 1, path) || getPath2(x - 1, y, path)) { 
			Point p = new Point(x, y);
			path.add(p);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int size = 6;
		maze = AssortedMethods.randomMatrix(size, size, 0, 5);
		
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = new ArrayList<Point>();
		boolean success = getPath(0, 0, path);
		//boolean success = getPath(size - 1, size - 1, path);
		if (success) {
			String s = AssortedMethods.listOfPointsToString(path);
			System.out.println(s);
		} else {
			System.out.println("No path found.");
		}
	}
}
