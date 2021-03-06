package Chapter5;

public class p_5_2 {
	
	public static void main(String[] args) {
		String bs = printBinary(0.8125);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = printBinary(num);
			String binary2 = printBinary2(num);
			if (!binary.equals("ERROR") ||!binary2.equals("ERROR")) {
				System.out.println(num + " : " + binary+ " "  +binary2);
			}
		}
	}
	static String printBinary2(double num){
		if(num <= 0 || num >= 1){
			return "ERROR";
		}
		
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while(num > 0){
			if(binary.length() >= 32){
				return "ERROR";
			}
			if(num >= frac){
				binary.append(1);
				num -= frac;
			}else{
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}
	
	static String printBinary(double num){
		/*treat num as binary input?*/
		if (num >= 1 || num <= 0)
			return "ERROR";
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		
		while(num >0){
			if(binary.length() > 32){
				return "ERROR";
			}
			
			double r = num * 2;
			
			if(r>=1){
				binary.append(1);
				num = r -1;
			}else{
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
}
