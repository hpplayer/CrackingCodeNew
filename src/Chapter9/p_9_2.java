package Chapter9;

import java.util.ArrayList;

public class p_9_2 {
	static Node[][] graph;
	static ArrayList<Node> Blacklist;
/*
 * my perfect program should run successfully
 * testR uses recursive approach to calculate
 * how many paths are there to reach node(x,y) 
 */
	public static int testR(int x, int y) {
		if (x == 0 || y == 0)
			return 1;
		/*
		if (x == 1)
			return y + 1;
		if (y == 1)
			return x + 1;
			*/
		return testR(x-1, y) +testR(x, y-1);
	}
	
	private class Node{
		int x;
		int y;
		Node[] adj;
		Node parent;
		public void setParent(Node n){
			this.parent = n;
		}
		private Node(int x, int y){
			x = this.x;
			y = this.y;

			adj = new Node[2];
			if(graph[x+1][y] != null) adj[0] = graph[x+1][y];
			if(graph[x][y+1] != null) adj[1] = graph[x][y+1];
		}

	}
	
	/*
	 * for the follow up question, my idea is using DFS to search the Node at right bot,
	 * 
	 */
	static boolean[][] marked = new boolean[100][100];
	public static void DFS(int x, int y){
		if(x == 100 && y == 100){
			System.out.println("we reach here!");
		}
		marked[x][y] = true;
		for(Node n: graph[x][y].adj){
			if(n != null && !marked[n.x][n.y] && !Blacklist.contains(n)){
				n.parent = graph[x][y];
				DFS(n.x, n.y);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(testR(5,5));
		
	}

}
