package nodeTrees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// binary search tree storing integers
public class IntBST extends NodeBinaryTree<Integer> {

	// private int size = 0;

	public IntBST() {
	}

	public int size() {
		return size;
	}

	public void setSize(int s) {
		size = s;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Places element e at the root of an empty tree and returns its new Node.
	 *
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */

	public Node<Integer> addRoot(Integer e) throws IllegalStateException {
		if (size != 0)
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Print a binary tree horizontally Modified version of
	 * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 * Modified by Keith Gutfreund
	 * 
	 * @param n Node in tree to start printing from
	 */

	public void print(Node<Integer> n) {
		print("", n);
	}

	public void print(String prefix, Node<Integer> n) {
		if (n != null) {
			print(prefix + "       ", right(n));
			System.out.println(prefix + ("|-- ") + n.getElement());
			print(prefix + "       ", left(n));
		}
	}

	public void inorderPrint(Node<Integer> n) {
		if (n == null)
			return;
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}

	public Iterable<Node<Integer>> children(Node<Integer> n) {
		List<Node<Integer>> snapshot = new ArrayList<>(2); // max capacity of 2
		if (left(n) != null)
			snapshot.add(left(n));
		if (right(n) != null)
			snapshot.add(right(n));
		return snapshot;
	}

	public int height(Node<Integer> n) throws IllegalArgumentException {
		if (isExternal(n)) {
			return 0;
		}
		int h = 0; // base case if p is external
		for (Node<Integer> c : children(n))
			h = Math.max(h, height(c));
		return h + 1;
	}

	public static IntBST makeBinaryTree(int[] a) {

		// IntBST tree = new IntBST();
		// tree.setSize(a.length);
		return binaryTreeBuilder(a, 0, a.length - 1);
		// return tree;
	}

	// public static IntBST binaryTreeBuilder(int[] a, int startIndex, int endIndex)
	// {
	// // System.out.println(Arrays.toString(a));// returns the list of the array
	// // starting a new tree;
	// IntBST tree = new IntBST();
	// // base case
	// if (startIndex > endIndex) {
	// return tree;
	// }
	// int midpoint = (startIndex + endIndex) / 2;
	// System.out.println(a[midpoint]);
	// Node<Integer> mainRoot = tree.addRoot(a[midpoint]);
	// // 1. only look now at the index from 0 to midlle -1
	// int[] larr = Arrays.copyOfRange(a, 0, midpoint);
	// if (midpoint != 0) {
	// IntBST lt = IntBST.binaryTreeBuilder(larr, 0, larr.length);
	// lt.addLeft(mainRoot, larr[midpoint - 1]);

	// if (tree.left(mainRoot) != null) { // checks to see if there is a left
	// element
	// lt.addRight(mainRoot, a[midpoint + 1]);

	// }
	// }
	// // 2. now to look at the right side of the array

	// return tree;
	// }

	// }
	public static IntBST binaryTreeBuilder(int[] a, int startIndex, int endIndex) {
		// System.out.println(Arrays.toString(a));// returns the list of the array
		// starting a new tree;
		IntBST tree = new IntBST();
		// base case
		if (startIndex > endIndex) {
			return null;
		}
		// figure out the middle point in the array
		// no matter what point youre looking
		int midpoint = (startIndex + endIndex) / 2;
		// System.out.println(a[midpoint]);
		// set the middle point as main root
		Node<Integer> mainRoot = tree.addRoot(a[midpoint]);
		// 1. look at the left side of the array and build mini tree
		IntBST lt = binaryTreeBuilder(a, startIndex, midpoint - 1);
		IntBST rt = binaryTreeBuilder(a, midpoint + 1, endIndex);
		// 2. now to look at the right side of the array and build mini tree
		if (lt != null) {
			mainRoot.setLeft(lt.root);
			tree.size += lt.size;
		}
		if (rt != null) {
			mainRoot.setRight(rt.root);
			tree.size += rt.size;
		}
		return tree;
	}

}