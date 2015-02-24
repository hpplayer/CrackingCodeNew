package Chapter9;

import java.util.Arrays;

import CtCILibrary.AssortedMethods;

public class p_9_3_f {
	public static int magicSlow(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int returnIndex() {
		return index;
	}

	static int index = -1;

	public static boolean findIndex(int min, int max, int[] ary) {
		// System.out.println("max: " + max);
		// System.out.println("min: " + min);
		//if (min < 0 || max > ary.length - 1 || max < min) {
		if ( max < min) {
			// System.out.println("no such index!");
			return false;
		} else {
			// int mid = (max + min)/2;//maybe I could not add min, since we are
			// comparing min and mid;
			int mid = min + (max - min) / 2;
			// System.out.println(mid);
			if (ary[mid] == mid) {
				index = mid;
			 //System.out.println(index);
				//System.out.println(ary[index]);
				return true;
			}
			index = -1;
			return (findIndex(min, mid - 1, ary) || findIndex(mid + 1, max, ary));
		}
	}

	/* Creates an array that is sorted */
	public static int[] getSortedArray(int size) {
		int[] array = AssortedMethods.randomArray(size, -1 * size, size);
		Arrays.sort(array);
		return array;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int size = AssortedMethods.randomIntInRange(5, 20);
			int[] array = getSortedArray(size);
			findIndex(0, array.length - 1, array);

			int v2 = returnIndex();
			if (v2 == -1 && magicSlow(array) != -1) {
				int v1 = magicSlow(array);
				System.out.println("Incorrect value: index = -1, actual = "
						+ v1 + " " + i);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			} else if (v2 > -1 && array[v2] != v2) {
				System.out.println("Incorrect values: index= " + v2
						+ ", value " + array[v2]);
				System.out.println(AssortedMethods.arrayToString(array));
				break;
			}
			System.out.println("succeed!");
		}
	}
}