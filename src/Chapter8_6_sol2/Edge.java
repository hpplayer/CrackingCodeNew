package Chapter8_6_sol2;

public class Edge {
	enum Type{inner, outer, flat}
	Piece parent;
	Type type;
	int index;
	Edge attached_to;
	
	boolean fitsWidth(Edge edge){
		return (this.attached_to == edge);
	}
	
}
