package Chapter8_2;

public class test {
	public static void main(String[] args){
		callcenter test = new callcenter();
	


		respondent rs = new respondent(4);
		rs.needhelp = true;
		rs.busy = true;
		test.resps.add(rs);

		test.addq(1, 1);
		
		test.addq(2, 1);
		test.addq(3, 1);
		//test.addq(4, 1);
		test.resps.add(rs);
		test.addq(5, 2);
		test.addq(6, 2);
		test.addq(7, 3);
	//	System.out.println(test.dirs.size());
		System.out.println(test.dispatchcall());//should be 7
		
	}
}
