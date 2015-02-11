package Chapter9;


public class p_9_7 {
	enum Color {
		Black, White, Red, Yellow, Green, black;
	}
	public static String PrintColor(Color c) {
		switch(c) {
		case Black:
			return "B";
		case White:
			return "W";
		case Red:
			return "R";
		case Yellow:
			return "Y";
		case Green:
			return "G";
		}
		return "X";
	}
	
	public static void PrintScreen(Color[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(PrintColor(screen[i][j]));
			}
			System.out.println();
		}
	}
	public static void test(Color[][] screen, int x, int y, Color OldColor,
			Color NewColor) {
		if (screen.length <= y || screen[0].length <= x || x < 0 || y < 0)
			return;

		if (screen[y][x] == NewColor)
			return;
	
		if(screen[y][x] == OldColor){
			screen[y][x] = NewColor;
			test(screen, x, y + 1, OldColor, NewColor);
			test(screen, x, y - 1, OldColor, NewColor);
			test(screen, x - 1, y, OldColor, NewColor);
			test(screen, x + 1, y, OldColor, NewColor);
		}

	}

	public static void test(Color[][] screen, int x, int y, Color ncolor) {
		//if (screen[x][y] == ncolor) return false;
		test(screen, y, x, screen[y][x], ncolor);
	}
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static void main(String[] args) {
		int N = 10;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.Black;
			}			
		}
		for (int i = 0; i < 100; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		PrintScreen(screen);
		test(screen, 2, 2, Color.White);
		System.out.println();
		System.out.println();
		PrintScreen(screen);
	}
}
