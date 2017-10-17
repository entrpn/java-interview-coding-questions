/**
 * Sum of 3 elements in array are equal to zero. O(n^2)
 * @author entrpn
 *
 */
public class SumOf3ElementsIsZero {

	private static boolean isZero(int arr[]) {
		boolean retval = false;
		QuickSort qs = new QuickSort();
		qs.quickSort(arr);
		int k = arr.length-1;
		for (int i=0;i < arr.length-2;i++) {
			int j = i+1;
			while (k >= j) {
				int val = arr[i] + arr[j] + arr[k];
				if (val == 0) {
					retval = true;
					break;
				}
				if (val > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return retval;
	}

	public static void main(String[] args) {
		int arr[] = {1,3,5,-4,7,5,2};

		System.out.println(isZero(arr));
	}
}
