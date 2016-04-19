package studentRecordsBackup.bst;

public class BST {
	private Node root;
	private int sum;
	private Node max;

	/**
	 * @param node
	 *            method to insert a node into tree
	 */

	public void insert(Node node) {
		if (getRoot() == null) {
			node.setMax(true);
			setRoot(node);
			max = node;
		} else {
			if (max.getbNum() < node.getbNum()) {
				max.setMax(false);
				node.setMax(true);
				max = node;

			}
			Node current = root;
			while (true) {
				if (current.getbNum() > node.getbNum()) {
					if (current.getLeft() == null) {
						current.setLeft(node);
						return;
					} else
						current = current.getLeft();
				} else if (current.getbNum() < node.getbNum()) {
					if (current.getRight() == null) {
						current.setRight(node);
						return;
					} else
						current = current.getRight();

				}
			}
		}
	}

	/**
	 * method to get root node
	 */
	private Node getRoot() {
		return root;
	}

	/**
	 * method to set root node
	 */
	private void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * method to print Inorder
	 */
	public void printInorder() {
		if (getRoot() != null)
			printInorder(getRoot());
		else
			System.out.print("Tree empty");
		System.out.println();
	}

	/**
	 * inorder recursion
	 */
	private void printInorder(Node node) {
		if (node != null) {
			printInorder(node.getLeft());
			System.out.print(node.getbNum() + "\t");
			printInorder(node.getRight());
		}
	}

	/**
	 * method to print sum of all nodes
	 */
	private void printBsum(Node n) {
		if (n != null) {
			printBsum(n.getLeft());
			sum += n.getbNum();
			printBsum(n.getRight());
		}
	}

	public void printBSum() {
		sum = 0;
		printBsum(getRoot());
		System.out.println("The sum of all the B-Numbers : " + sum);
	}

	/**
	 * @param updateValue
	 *            method to increment all nodes in tree
	 */
	public void increment(int updateValue) {
		increment(getRoot(), updateValue);
	}

	private void increment(Node node, int updateValue) {
		if (node != null) {
			increment(node.getLeft(), updateValue);
			node.updateNode(updateValue);
			increment(node.getRight(), updateValue);
		}
	}

}
