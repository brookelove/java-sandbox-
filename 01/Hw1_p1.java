
import java.util.ArrayList;
import java.util.List;

public class Hw1_p1 {

	public static void find(int[] a, int x) {
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {
			if (x == a[i]) {
				tempList.add("a[" + i + "]");
			}
		}
		if (tempList.size() == 0) {
			System.out.println(x + " does not exist");
		} else {
			for (String ind : tempList) {
				System.out.println(x + " is in " + ind);
			}
		}
		// for loop to compare a to x
		//
		// String[] tempArr;

		// System.out.println(tempArr.length);
		// for (int i = 0; i < a.length; i++) {
		// if (x == a[i]) {
		// tempArr[tempArr.length] = ("a[" + i + "]");
		// }
		// }
		// if (tempArr.length == 0) {
		// System.out.println(tempArr.length);
		// } else {
		// System.out.println(tempArr.length);
		// }
		// for (int i = 0; i < a.length; i++) {
		// System.out.println(i);
		// if (a[i] == x && tempArr.length == 0) {
		// tempArr[tempArr.length] = ("a[" + i + "]");
		// System.out.println(x + " is in a[" + i + "]");
		// } else if (a[i] != x) { // need to rethink how to print if on the last
		// break;
		// //
		// } else {
		// System.out.println(x + " does not exist");
		// }
		// if (a[i] == x && tempArr.length < 0) {
		// tempArr[tempArr.length - 1] = ("a[" + i + "]");
		// System.out.println(x + " is in a[" + i + "]");
		// } else if (a[i] != x) { // need to rethink how to print if on the last
		// break;
		// //
		// } else {
		// System.out.println(x + " does not exist");
		// }

		// }if(tempArr.length==0)

		// {
		// System.out.println(x + " does not exist");
		// }else
		// {
		// for (int i = 0; i < tempArr.length; i++) {
		// System.out.println(x + " is in" + tempArr[i]);
		// }
		// }
		// System.out.println("end here");
	}

	public static boolean isPrefix(String s1, String s2) {
		// implement this method
		List<String> tempList = new ArrayList<String>();

		for (int i = 0; i < s1.length(); i++) {
			// for (int j = 0; j < s2.length(); j++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				tempList.add("yes");
			}
			// }
		}
		// System.out.println(s1.length());
		// System.out.println(tempList.size());
		if (tempList.size() == s1.length()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		int[] a = { 5, 3, 5, 6, 1, 2, 12, 5, 6, 1 };

		find(a, 5);
		find(a, 10);
		System.out.println();

		String s1 = "abc";
		String s2 = "abcde";
		String s3 = "abdef";

		if (isPrefix(s1, s2)) {
			System.out.println(s1 + " is a prefix of " + s2);
		} else {
			System.out.println(s1 + " is not a prefix of " + s2);
		}

		if (isPrefix(s1, s3)) {
			System.out.println(s1 + " is a prefix of " + s3);
		} else {
			System.out.println(s1 + " is not a prefix of " + s3);
		}
	}
}
