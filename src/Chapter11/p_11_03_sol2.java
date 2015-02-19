package Chapter11;

public class p_11_03_sol2 {
	public static int search(int left, int right, int[] ary, int target){
		if(right < left ) return -1;
		int mid = left + (right-left)/2;
		System.out.println(mid);
		System.out.println("mid: " + ary[mid] + " left: " + ary[left] + " right " + ary[right]);
		if(ary[mid] == target) return mid;
		if(ary[left] < ary[mid]){//left good
			if(target <= ary[mid] && target >= ary[left]){//dont forget "=", since the base case "3,4" we may have only two elements, mid = left, and we need to pick the right one 
				return search(left, mid -1, ary, target); //dont forget the influence of mid-1, which make the end of next loop become previous element
			}else{
				return search(mid+1, right, ary, target);
			}
		}else if (ary[right] > ary[mid]){//right good
			System.out.println("count");
			if(target <= ary[right] && target >= ary[mid]){//dont forget "=", since the base case "3,4" we may have only two elements,  mid = right, and we need to pick the right one
				return search(mid+1, right, ary, target);//dont forget the influence of mid+1, which make the start of next loop become next element
			}else{
				return search(left, mid -1, ary, target);
			}
		}else if(ary[mid] == ary[left]){//if left all same
			if(ary[mid] != ary[right]){
				return search(mid+1, right, ary, target);
			}else{//ary[mid] == ary[left] == ary[right]
				int result = search(left, mid -1, ary, target);
				if(result == -1){
					result = search(mid+1, right, ary, target);
				}
				return result;
			}
		}
		System.out.println("i came here??");
		return -1;
	}
	
	public static void main(String[] args){
		int[] a = {7,7,7,7,7,7,7,8,9,10,11,1,2,3,4,5,6,6,6,6,7};
		int[] b = { 2, 2, 2, 2,3, 2, 2, 2 , 2 , 2 };
		int[] c = {15,16,19,20,25,1,3,4,5,7,10,14};
		//System.out.println(search(c, 0, c.length-1, 16));

		//System.out.println(search(0, a.length-1, a, 8));
		//System.out.println(search(0, b.length-1, b, 3));
		System.out.println(search(0, c.length-1, c, 4));
		/*
		int[] a = { 2, 3, 2, 2, 2, 2, 2, 2 , 2 , 2 };

		System.out.println(returnIndex2(0, a.length - 1, a, 2));
		System.out.println(returnIndex2(0, a.length - 1, a, 3));
		System.out.println(returnIndex2(0, a.length - 1, a, 4));
		System.out.println(returnIndex2(0, a.length - 1, a, 1));
		System.out.println(returnIndex2(0, a.length - 1, a, 8));
		*/
	}
}
