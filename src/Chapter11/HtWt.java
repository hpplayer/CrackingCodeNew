package Chapter11;

public class HtWt  {
	int h;
	int w;
	public HtWt(int h, int w){
		this.h = h;
		this.w = w;
	}
	
	public boolean isBefore( HtWt n){
		if(n == null) return true;
		return (n.w > this.w && n.h > this.h);
	}

	public String toString() {
		return "(" + h + ", " + w + ")";
	}
}
