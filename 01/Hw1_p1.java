
import java.util.Arrays;

public class Hw1_p1 {
	
	public static void find(int[] a, int x) {
		// implement this method
	}
	
	public static boolean isPrefix(String s1, String s2) {
		// implement this method
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {5, 3, 5, 6, 1, 2, 12, 5, 6, 1};
		
		find(a, 5);
		find(a, 10);
		System.out.println();
		
		String s1 = "abc";
		String s2 = "abcde";
		String s3 = "abdef";
		
		if (isPrefix(s1,s2)) {
			System.out.println(s1 + " is a prefix of " + s2);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s2);
		}
		
		if (isPrefix(s1,s3)) {
			System.out.println(s1 + " is a prefix of " + s3);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s3);
		}
	}
}
