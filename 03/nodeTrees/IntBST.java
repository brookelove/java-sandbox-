package nodeTrees;

import java.nio.IntBuffer;
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
		IntBST tree = new IntBST();
		tree.setSize(a.length);
		binaryTreeBuilder(a, 0, a.length);
		return tree;
	}

	public static IntBST binaryTreeBuilder(int[] a, int startIndex, int endIndex) {
		// create new tree, reference this as the element instead of IntBST
		IntBST tree = new IntBST();
		// base case
		if (startIndex >= endIndex) {
			return tree;
		}
		// find the middle element of the array
		int midpoint = a.length / 2;

		// add root note using the middle element of the array
		// use addRoot
		Node<Integer> root = tree.addRoot(a[midpoint]);

		if (midpoint - 1 >= 0) {
			tree.addLeft(root, a[midpoint - 1]);
		}
		if (midpoint + 1 <= a.length - 1) {
			tree.addRight(root, a[midpoint + 1]);
		}

		// build left side of the tree using recursion
		int[] larr = Arrays.copyOfRange(a, 0, midpoint);

		// build the right side of teh tree using recursion
		int[] rarr = Arrays.copyOfRange(a, midpoint + 1, a.length);
		// System.out.println(Arrays.toString(larr));
		// System.out.println(Arrays.toString(rarr));

		// build the left side of the tree using recursion
		IntBST lt = IntBST.binaryTreeBuilder(larr, 0, larr.length);
		// build the right side of the tree using recursion
		IntBST rt = IntBST.binaryTreeBuilder(rarr, 0, rarr.length);

		// attach the left and right tree to the middle node
		// use the attach method
		tree.attach(root, lt, rt);

		return tree;
	}

}
