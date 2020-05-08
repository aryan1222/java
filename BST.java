package Lectures;

public class BST {
	private class Node {
		int data;
		Node left;
		Node right;

	}

	private Node root;

	public BST(int[] in) {
		this.root = construct(in, 0, in.length - 1);

	}

	private Node construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}

		int mid = (ilo + ihi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, ilo, mid - 1);
		nn.right = construct(in, mid + 1, ihi);

		return nn;

	}

	public void display() {
		display(this.root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = "";

		if (node.left == null) {
			str += ".";

		} else
			str += node.left.data;

		str += "->" + node.data + "<-";
		if (node.right == null) {
			str += ".";

		} else
			str += node.right.data;

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size() {
		return size(this.root);

	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs + 1;
	}

	public boolean find(int item) {
		return find(this.root, item);

	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (item > node.data) {
			return find(node.right, item);
		} else if (item < node.data) {
			return find(node.left, item);
		} else
			return true;
	}

	public int max() {
		return max(this.root);

	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	public int ht() {
		return ht(this.root);

	}

	private int ht(Node node) {
		if (node == null) {
			return -1;

		}
		int l = ht(node.left);
		int r = ht(node.right);

		return Math.max(l, r) + 1;
	}

	public void Range(int lo, int hi) {
		Range(this.root, lo, hi);

	}

	private void Range(Node node, int lo, int hi) {

		if (node == null) {
			return;

		}
		if (node.data > lo) {
			Range(node.right, lo, hi);
		} else if (node.data < hi) {
			Range(node.left, lo, hi);

		} else {
			Range(node.left, lo, hi);
			System.out.println(node.data);
			Range(node.right, lo, hi);

		}
	}

	public void printDec() {
		printDec(this.root);

	}

	private void printDec(Node node) {
		if (node == null) {
			return;

		}
		printDec(node.right);
		System.out.println(node.data);
		printDec(node.left);

	}

	public class HeapMover {
		int sum = 0;
	}

	public void replacewithSumLarger() {
		replacewithSumLarger(null, new HeapMover());
	}

	private void replacewithSumLarger(Node node, HeapMover mover) {
		if (node == null) {
			return;
		}
		replacewithSumLarger(node.right, mover);

		int temp = node.data;

		node.data = mover.sum;
		mover.sum += temp;

		replacewithSumLarger(node.left, mover);
	}

	public int replacewithSumLarger2(Node node, int sum) {

		if (node == null) {
			return sum;
		}

		int sumofLargervalues = replacewithSumLarger2(node.right, sum);

		int temp = node.data;

		node.data = sumofLargervalues;

		int sumofLargervaluesincludesmaller = replacewithSumLarger2(node.left, sum);

		return sumofLargervaluesincludesmaller;

	}

	public void add(int item) {
		add(this.root, item);

	}

	private void add(Node node, int item) {
		if (item < node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		}
		if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}

		}
	}

	private Node addReturn(Node node, int item) {
		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (item <= node.data) {
			node.left = addReturn(node.left, item);

		} else
			node.right = addReturn(node.right, item);

		return node;
	}

	public void Remove(int item) {
		Remove(this.root, null, item);

	}

	private void Remove(Node node, Node parent, int item) {
		if (item < node.data) {
			Remove(node.left, node, item);
		} else if (item > node.data) {
			Remove(node.right, node, item);

		} else {
			//Leaf Node
			if (node.left == null && node.right == null) {
				if (item < parent.data) {
					parent.left = null;
				} else
					parent.right = null;
			}

			else if (node.left == null && node.right != null) {
				if (item < parent.data) {
					parent.left = node.right;
				} else
					parent.right = node.right;
			}

			else if (node.left != null && node.right == null) {
				if (item < parent.data) {
					parent.left = node.left;
				} else
					parent.right = node.left;
			}

			else {
				int temp = max(node.left);
				Remove(node.left, parent, item);
				node.data = temp;
			}
		}
	}

}
