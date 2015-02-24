package Chapter3;

public class p_3_4_sol2 {
	public static void main(String[] args) {
		// Set up code.
		int n = 3;//does not work on 4 or more rods, only works on 3 rods 
		Tower[] towers = new Tower[6];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}
		
		// Copy and paste output into a .XML file and open it with internet explorer.
		//towers[0].print();
		towers[0].moveDisks(n, towers[2], towers[1]);
		//towers[2].print();
	}
}
