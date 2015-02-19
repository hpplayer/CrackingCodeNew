package Chapter11;

public class p_11_03 {
	public static int returnIndex(int[] ary, int integer){
		int i = 0;
		for(i = 0; i < ary.length; i++){
			if(ary[i] == integer){
				break;
			}
		}
		if(i != 0){
			return i;
		}else{
			return -1;
		}
	}
	
	/*
	 * still has problem...cant return right part 
	 */
	public static int returnIndex2(int left, int right, int ary[], int integer){
		//if(left < 0 || right >= ary.length||right<left) return -1;
		if(right<left) return -1;
		int mid = left + (right-left)/2;
		//System.out.println(mid);
		if(ary[mid] == integer) return mid;
		if(ary[right] > ary[left]){//nomral order
			if(ary[mid] > integer){
				return returnIndex2(left, mid-1, ary, integer);
			}else{
				return (returnIndex2(mid+1, right, ary, integer));
			}
		}else{
			if(ary[mid]>integer && ary[left] >integer){
				return (returnIndex2(mid+1, right, ary, integer));
			}else if (ary[mid] < integer && ary[right] > integer){
				return (returnIndex2(mid+1, right, ary, integer));
			}else{
				return (returnIndex2(left, mid -1, ary, integer));
			}
		}
	}
	
	public static int search(int[] a, int left, int right, int x){
		int mid = left + (right-left)/2;
		if( x == a[mid]){
			return mid;
		}
		
		if(right < left){//we only need to consider this case?!
			return -1;
		}
		
		if(a[left] < a[mid]){//left is normally ordered
			if(x >= a[left] && x <= a[mid]){//x is in left part
				return search(a, left, mid-1, x);
			}else{
				return search(a, mid+1, right, x);
			}
		}else if(a[mid] < a[left]){//right is normally ordered 
			if(x >= a[mid] && x <= a[right]){//x is in right part
				return search(a, mid+1, right, x);
			}else{
				return search(a, left, mid-1,x);
			}
		}else if (a[left] == a[mid]){//left half all repeats
			if(a[mid] != a[right]){//if right half is different, not all repeats
				return search(a, mid+1, right,x );
			}else{//this case is weird, left and right mostly duplicate, so we dont where to start, have to seach both
				int result = search(a, left, mid - 1, x);
				if(result == -1){//left part, no match
					return search(a, mid+1, right, x);
				}
				return result;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a = {7,7,7,7,7,7,7,8,9,10,11,1,2,3,4,5,6,6,6,6,7};
		int[] b = { 2, 2, 2, 2,3, 2, 2, 2 , 2 , 2 };
		int[] c = {15,16,19,20,25,1,3,4,5,7,10,14};
		//System.out.println(search(c, 0, c.length-1, 16));
		System.out.println(returnIndex2(0, c.length-1, c, 4));
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
