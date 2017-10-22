
public class QuickSort {

	public static int[] sort(int[] arr) {
		int i = getMedianIndex(arr);
		// swap pivot with last element
		swap(arr,i,0);
		System.out.println("Swap median pivot: "+i);
		print(arr,-1);
		sort(arr,0 ,arr.length-1);
		return arr;
	}
	private static void sort(int[] arr, int start, int end) {
		int i = start;
		int k = end;
		System.out.println("start: "+start+", end: "+end);
		if (end - start > 0) {
			int pivot = arr[start];
			while (i < k) {
				while (arr[i] <= pivot && i<end) i++;
				System.out.print("i("+i+"): ");
				print(arr,i);
				while (arr[k] >= pivot && k > start) k--;
				System.out.print("k("+k+"): ");
				print(arr,k);
				if (k > i) {
					swap(arr,i,k);
				}
			}
			swap(arr,k,start);
			sort(arr,start,k-1);
			sort(arr,k+1,end);
		}
	}
	private static void swap(int[] arr, int i, int k) {
		int temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}
	private static int getMedianIndex(int[] arr){
		int start = arr[0];
		int mid = arr[arr.length/2];
		int end = arr[arr.length-1];
		if ((start - mid) * (end - start) >= 0) {
			return 0;
		} else if ((mid - start) * (end - mid) >= 0) {
			return mid;
		} else {
			return end;
		}
	}
	private static void print(int[] arr, int index) {
		for (int i=0; i < arr.length;i++) {
			if (index != -1 && index == i) {
				System.out.print("[" + arr[i] +"] ");
			} else {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {3,7,8,5,2,1,9,5,4};
		sort(arr);
		print(arr,-1);
	}
}
