package Chapter8_6_sol2;

public class Piece {
	Edge[] edges;
	boolean isConner(){
		int count = 0;
		for(Edge e: edges){
			if(e.type == Edge.Type.flat){
				count ++;
			}
		}
		
		return (count == 2);
	}
}
