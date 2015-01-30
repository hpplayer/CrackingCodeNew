package Chapter8_6_sol2;

public class Puzzle {
	Piece[] pieces;//remaining pieces
	Piece[][] solution;
	Edge currentEdge;
	
	Edge[] inners, outers, flats;
	Piece[] corners;
	public Puzzle(){
		corners = new Piece[4];
		inners = new Edge[10];
		outers = new Edge[10];
	}
	void sort(){
		int c = 0;
		int i = 0;
		int o = 0;
		for(Piece p: pieces){
			if(p.isConner()){
				corners[c] = p;
				c++;
			}
			for(Edge e: p.edges){
				if (e.type == Edge.Type.inner){
					inners[i] = e;
					i++;
				}
				else if (e.type == Edge.Type.outer){
					outers[o] = e;
					o++;
				}
			}
		}
	}
	
	public void solve(){
		Edge[] opposites = null;
		currentEdge = getExposedEdge(corners[0]);
		while(currentEdge != null){
			opposites = currentEdge.type == Edge.Type.inner? outers : inners;
		}
		
		for(Edge fittingEdge: opposites){
			if(currentEdge.fitsWidth(fittingEdge)){
				attachEdges(currentEdge, fittingEdge);
				removeFromList(currentEdge);
				removeFromList(fittingEdge);
				
				currentEdge = nextExposedEdge(fittingEdge);
				break;
			}
		}
	}

	public Edge nextExposedEdge(Edge edge){
		int next_index = (edge.index * 2) %4;
		Edge next_edge = edge.parent.edges[next_index];
		if (isExposed(next_edge)){
			return next_edge;
		}
		return getExposedEdge(edge.parent);
	}
	public void removeFromList(Edge edge){
		if(edge.type == Edge.Type.flat) return;
		Edge[] ary = currentEdge.type == Edge.Type.inner? inners : outers;
		for(Edge e : ary){
			if (e == edge){
				e = null;
			}
		}
	}
	public boolean attachEdges(Edge e1, Edge e2){
		e1.attached_to = e2;
		e2.attached_to = e1;
		return true;
	}
	public boolean isExposed(Edge e){
		return e.type != Edge.Type.flat && e.attached_to == null;
	}
	
	public Edge getExposedEdge(Piece p){
		for(Edge e: p.edges){
			if(isExposed(e)){
				return e;
			}
		}
		return null;
	}
}
