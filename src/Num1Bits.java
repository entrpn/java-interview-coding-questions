/**
 * Function that takes unsigned int (using java long) and returns the number of 1 bits it has.
 * @author entrpn
 *
 */
public class Num1Bits {
	private static int num1Bits(long val) {
		int retval = 0;
		while (val > 0) {
			int mod = (int) (val%2);
			if (mod == 1) retval++;
			val = val/2;
		}
		return retval;
	}
	public static void main(String[] args) {
		System.out.println(num1Bits(7));
	}
}
