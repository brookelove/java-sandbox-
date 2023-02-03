import nodeTrees.*;
// make sure all files in nodeTrees package are accessible
// some files in nodeTrees may need files from net.datastructures

public class Hw3_p7 {
	public static IntBST binaryTreeBuilder(int[] a, int startIndex, int endIndex) {
		// create new tree
		IntBST tree = new IntBST();

		// base case
		if (startIndex > endIndex) {
			return tree;
		}
		// find the middle element of the array
		// add root note using the middle element of the array
		// middle is the root now
		// build the left side of the tree using recursion
		// build the right side of the tree using recursion
		// calculate the tree size
		/// attach the left and right tree to the middle node
		return tree;
	}

	public static void main(String[] args) {

		IntBST t = new IntBST();

		int[] a1 = { 10 };
		int[] a2 = { 10, 20, 30 };
		int[] a3 = { 10, 20, 30, 40, 50, 60, 70 };
		int[] a4 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150 };

		t = IntBST.makeBinaryTree(a4); // test with other arrays too
		System.out.println("Tree size: " + t.size());
		System.out.println("Tree height: " + t.height(t.root));
		System.out.println("");

		t.print(t.root);

	}

}
