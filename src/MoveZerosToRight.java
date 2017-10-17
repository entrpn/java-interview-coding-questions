/**
 * Move all zeros in array to the right.
 * @author entrpn
 *
 */
public class MoveZerosToRight {

	public static void move(int[] arr) {
		int k = arr.length-1;
		for (int i = 0; i < arr.length;i++) {
			int curr = arr[i];
			if (curr != 0) continue;
			while (arr[k] == 0 && k > 0) {
				k--;
			}
			if (k < i) break;
			arr[i] = arr[k];
			arr[k] = curr;
		}
	}
	public static void main(String[] args){
		int[] arr = {6,4,0,5,0,0,0,1,0};
		move(arr);
		for (int i =0; i < arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
