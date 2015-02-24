/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 5, 2014 10:10:25 PM
 */
package Chapter4;
import CtCILibrary.*;
/*
 * This solution use DFS to solve the problem
 * DFS is more convenient to detect loop then BFS
 * since it is easy to implement AND DFS can easily
 * record which path cause the loop while BFS need 
 * extra works to detect such loop
 */
public class p_4_2 {
	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(checkNode(g, start, end));
	}
	
	public static boolean checkNode(Graph g, Node s, Node d){
		if(s == d) return true;
		for (Node u : g.getNodes()){
			u.state = State.Unvisited;
		}
		
		DFS(s, d);
		return d.state == State.Visited? true : false;
	
	
	}
	
	public static void DFS(Node root, Node dest){
		root.state =  State.Visiting;
		for(Node temp : root.getAdjacent()){
			if(temp.state == State.Unvisited){
				DFS(temp, dest);
			}
			else if (temp.state == State.Visiting){
				System.err.println("loop detected!"); 
			}
			
			if(temp == dest){
				System.out.println("path detected!");
			}
		}
		root.state = State.Visited;
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		//temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[3] = new Node("d", 2);
		
		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		temp[3].addAdjacent(temp[0]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

}
