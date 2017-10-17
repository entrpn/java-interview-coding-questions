/**
 * Print pascal's triange and also find nth, kth element using factorials. 
 * @author entrpn
 *
 */
public class PascalTriangle {
	/**
	 * (n k) = n!/(k! * (n-k)!)
	 * @param depth
	 */

	public static void pascalsTriangle(int depth){
		for (int i=0; i <depth;i++){
			for (int j=0; j<=i;j++){
				System.out.print(nCalc(i,j)+" ");
			}
			System.out.println();
		}
	}

	private static int nCalc(int n,int k){
		return factorial(n) / (factorial(k) * factorial(n-k));
	}

	private static int factorial(int f){
		int retval = 1;
		for (int i=1;i<=f;i++){
			retval*=i;
		}
		return retval;
	}

	public static void main(String[] args) {

		pascalsTriangle(8);

		System.out.println(nCalc(5,3));
	}
}
