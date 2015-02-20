package Chapter11;

import CtCILibrary.AssortedMethods;

public class p_11_06_sol3 {
	//if we have not found the element, it must be in lower left or upper right
	public static Coordinate partionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x){
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);//top left in this part
		Coordinate lowerLeftDest = new Coordinate(dest.row, origin.column-1);//bot right in this part
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);//top left in this part
		Coordinate upperRightDesti = new Coordinate(pivot.row -1, dest.column);//bot right in this part
	
	    Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, x);//search lower left first
	    if(lowerLeft == null){//if return null
	    	return findElement(matrix, upperRightOrigin, upperRightDesti, x);
	    }
	    //else
	    return lowerLeft; 
	}
	
	public static Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x){
		if(!origin.inbounds(matrix) || !dest.inbounds(matrix)) return null;
		if(matrix[origin.row][origin.column] == x){
			return origin;
		}else if(!origin.isBefore(dest)){
			return null;
		}
		
		Coordinate start = (Coordinate) origin.clone();
		int diagDist =  Math.min(dest.row - origin.row, dest.column - origin.column);//pick the smallest onem, we will make the submatrix equals to the smallest difference
		Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);//make the submatrix a square
	    Coordinate p = new Coordinate(0,0);
		//System.out.println("start: " + matrix[start.row][start.column]);
		//System.out.println("end: " + matrix[end.row][end.column]);
	    //binary search, looking for fist element greater than one, when start smaller than x, still loop, next loop, start point bigger then x, break the loop 
		while(start.isBefore(end)){
			p.setToAverage(start, end);//get mid, p is mid
			if(x > matrix[p.row][p.column]){//search right bot in the diagonal 
				start.row = p.row +1;
				start.column = p.column +1;
			}else{//search left top in the diagonal 
				end.row = p.row -1;
				end.column = p.column -1;
			}
			System.out.println("p: " + matrix[p.row][p.column]);
			System.out.println("start: " + matrix[start.row][start.column]);
			System.out.println("end: " + matrix[end.row][end.column]);
			System.out.println();
		}
		System.out.println("i break out");
		//System.out.println(matrix[start.row][start.column]);
		//input original origin and original dest, but start is changed in the binary search, w
		return partionAndSearch(matrix, origin, dest, start, x);//start is the first element in diagonal that larger than x
	}
	
	
	public static Coordinate findElement(int[][] matrix, int x){
		Coordinate origin = new Coordinate(0,0);
		Coordinate dest = new Coordinate(matrix.length -1, matrix[0].length -1);
		return findElement(matrix, origin, dest, x);
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{15, 30,  50,  70,  73}, 
				 	 	  {35, 40, 100, 102, 120},
				 	 	  {36, 42, 105, 110, 125},
				 	 	  {46, 51, 106, 111, 130},
				 	 	  {48, 55, 109, 140, 150}};
	
		AssortedMethods.printMatrix(matrix);
		int m = matrix.length;
		int n = matrix[0].length;
		
		int count = 0;
		int littleOverTheMax = matrix[m - 1][n - 1] + 10;
		Coordinate c = findElement(matrix, 70);
		System.out.println("(" + c.row + ", " + c.column + ")");
		/*
		for (int i = 0; i < littleOverTheMax; i++) {
			Coordinate c = findElement(matrix, i);
			if (c != null) {
				System.out.println(i + ": (" + c.row + ", " + c.column + ")");
				count++;
			}
		}
		*/
		//System.out.println("Found " + count + " unique elements.");
	}
}
