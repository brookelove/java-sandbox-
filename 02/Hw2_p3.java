
public class Hw2_p3 {

	// implement reverse method
	// you may want to write a separate method with additional parameters, which is
	// recursive
	public static void helper(DoublyLinkedList<Integer> intList, int i) {
		// System.out.println(intList);
		// System.out.println(i);
		// 1.base case
		if (i <= 0) {
			return;
		}
		// 2. removed the first element in the list and stire its value

		int currentFirst = intList.removeFirst();
		System.out.println("Placed on Stack: " + currentFirst);
		// 3. recursive call
		helper(intList, i - 1);
		// 4. add the most recenetly removed element to the end of the list
		// intList.addFirst(currentFirst);
		System.out.println("Removed from stack: " + currentFirst);
	}

	public static void reverse(DoublyLinkedList<Integer> intList) {
		// complete this method
		intList.last();
		int index = intList.size();
		// System.out.println(intList.last()); // gets the last item in the array
		// System.out.println(intList.size()); //gets the size of the list
		helper(intList, index);
	}

	// use the main method for testing
	// test with arrays of different lenghts
	public static void main(String[] args) {

		DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();

		int[] a = { 10, 20, 30, 40, 50 };
		for (int i = 0; i < a.length; i++) {
			intList.addLast(a[i]);
		}
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

		// Here, invoke the reverse method you implemented above
		reverse(intList);

		System.out.println("After reverse: " + intList.toString());

		intList = new DoublyLinkedList<>();
		int[] b = { 10, 20, 30, 40, 50, 60 };
		for (int i = 0; i < b.length; i++) {
			intList.addLast(b[i]);
		}
		System.out.println();
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

		// Here, invoke the reverse method you implemented above
		reverse(intList);

		System.out.println("After reverse: " + intList.toString());

	}

}
