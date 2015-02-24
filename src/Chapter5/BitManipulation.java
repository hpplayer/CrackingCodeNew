package Chapter5;

public class BitManipulation {

	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(~2));
		System.out.println(Integer.toBinaryString(1111));//convert to bit 
		System.out.println(Integer.toBinaryString(1143));//convert to bit 
		System.out.println(Integer.toBinaryString(1095));//convert to bit 
		System.out.println(Integer.toBinaryString(7));//convert to bit 
		System.out.println(Integer.toBinaryString(1088));//convert to bit 
		System.out.println(Integer.toBinaryString(1095));//convert to bit 
		System.out.println(new BitManipulation().updatebit(1111, 4, 0));
		
	}
	
	
	boolean getbit(int input, int num){
		return (( input & (1<<num)) != 0);//return 1 if num th of input is not 0
	}
	
	int setbit(int input, int num){
		return (input | (1<< num));
	}
	
	int clearbit(int input, int num){
		int mask = ~(1<<num);
		return input & mask;
	}
	
	int clearbits(int input, int num){//clear the bit from the most significant bit to num-th
		int mask = (1<<num)-1; // a sequence of 0 followed by 1s
		return input & mask;
	}
	
	int clearall(int input, int num){//clear the bit from the num-th to 0-th
		//int mask = ~(-1 >>> (31-num)); //111100000, >>> shift sign bit as well
		int mask = ~(~0 >>> (31-num)); 
		return input & mask;
	}
	
	int updatebit(int input, int num, int newbit){
		int mask = ~(1 << num);//1111101111
		return (input & mask) | (newbit << num);
	}
}
