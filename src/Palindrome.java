import java.util.ArrayList;
import java.util.List;

/**
 * Find out if word is a palindrome
 * @author entrpn
 *
 */
public class Palindrome {
	public static boolean isPalindrome(String str) {    
		int n = str.length();
		for( int i = 0; i < n/2; i++ )
			if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(n-i-1))) return false;
		return true;    
	}
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("Anna");
		list.add("Civic");
		list.add("Kayak");
		for (String s : list){
			System.out.println(s+" is palindrome? "+isPalindrome(s));
		}
	}

}
