package Chapter11;

import CtCILibrary.AssortedMethods;

public class p_11_06_sol4 {
	public static class Coordinate implements Cloneable{
		int x;
		int y;
		public Coordinate(int x, int y){
			this.x = x;
			this.y = y;
		}

		public boolean inBounds(int[][] matrix){
			return(x>=0 && y >= 0 && y<matrix.length && x<matrix[0].length);
		}

		public boolean isBefore(Coordinate p){
			return x <= p.x && y <= p.y;
		}

		public Object clone(){
			return new Coordinate(x,y);
		}

		public void moveDownRight(){
			x++;
			y++;
		}

		public void setToAverage(Coordinate i, Coordinate j){
			x = (i.x + j.x) /2;
			y =(i.y + j.y)/2;
		}
	}
	
	public static Coordinate SplitAndSearch(int[][] matrix, Coordinate start, Coordinate end, Coordinate p, int target){
		Coordinate RightTopStart = new Coordinate(p.x, start.y);
		Coordinate RightTopEnd = new Coordinate(end.x, p.y-1);//move one row up
		Coordinate LeftBotStart = new Coordinate(start.x, p.y);
		Coordinate LeftBotEnd = new Coordinate(p.x-1, end.y);//move one column left
		
		Coordinate leftBot = search(matrix,LeftBotStart, LeftBotEnd, target);
		if(leftBot == null){
			return search(matrix,RightTopStart, RightTopEnd, target);
		}
		return leftBot;
	}
	public static Coordinate search(int[][] matrix, Coordinate start, Coordinate end, int target){
		//System.out.println("hello");
		
		if(!start.inBounds(matrix) ||!end.inBounds(matrix)) return null;
		//System.out.println("hello");
		if(matrix[start.y][start.x] == target){
			//System.out.println("hello");
			return start;
			
		}else if (!start.isBefore(end)){
			return null;
		}
		//System.out.println("hello");
		
		int dist = Math.min(end.x - start.x, end.y - start.y);
		Coordinate newStart = (Coordinate) start.clone();
		
		Coordinate newEnd = new Coordinate(start.x + dist, start.y + dist);
		Coordinate p = new Coordinate(0,0);

		//System.out.println("hello");
		while(newStart.isBefore(newEnd)){
			p.setToAverage(newStart, newEnd);
			//System.out.println("Newstart: " + matrix[newStart.y][newStart.x]);
		//	System.out.println("Newend: " + matrix[newEnd.y][newEnd.x]);
			//System.out.println("p: " + matrix[p.y][p.x]);
			if(target > matrix[p.y][p.x]){
				newStart.x = p.x+1;
				newStart.y = p.y+1;
			}else{
				newEnd.x=p.x-1;
				newEnd.y = p.y -1;
			}
			
		}
		//System.out.println("hello");
		//System.out.println("p: " + matrix[p.y][p.x]);
		//System.out.println("start: " + matrix[newStart.y][newStart.x]);
		//System.out.println("end: " + matrix[newEnd.y][newEnd.x]);
		//System.out.println();
		
		return SplitAndSearch(matrix, start, end, newStart, target );
	}
	
	public static Coordinate search(int[][] matrix, int target){
	//	Coordinate start = new Coordinate(0,0);
		//Coordinate end = new Coordinate(matrix.length -1, matrix[0].length -1);
		return search(matrix, new Coordinate(0,0), new Coordinate(matrix.length-1, matrix[0].length -1), target);
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
		Coordinate c = search(matrix, 70);
		System.out.println("(" + c.y + ", " + c.x + ")");
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
