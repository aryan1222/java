package Lectures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Generic_Tree {
	Scanner scn = new Scanner(System.in);
	static int sum=0;

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public Generic_Tree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {
		if (parent == null) {
			System.out.println("Enter data for root node");
		} else
			System.out.println("Enter data for" + ith + "child of" + parent.data);

		Node nn = new Node();

		int item = scn.nextInt();

		nn.data = item;
		sum+=item;
		System.out.println(sum);
		System.out.println("Enter number of children");
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {
			Node child = construct(nn, i);

			nn.children.add(child);

		}
		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		String str = node.data + "->";

		for (Node child : node.children) {
			str += child.data + " ";

		}
		str += " ";
		System.out.println(str);

		for (int i = 0; i < node.children.size(); i++) {
			display(node.children.get(i));
		}
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}
		return ts + 1;

	}

	public int max() {
		return max(this.root);

	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int a = max(child);
			if (max < a) {
				max = a;
			}
		}
		return max;
	}

	public boolean find(int item) {

		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean cf = find(child, item);

			if (cf) {
				return true;
			}
		}
		return false;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {
		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);
			if (ch > th) {
				th = ch;
			}

		}
		return th + 1;
	}

	public void mirror() {
		mirror(this.root);

	}

	private void mirror(Node node) {

		for (int i = 0, j = node.children.size() - 1; i < j; i++, j--) {
			Node a = node.children.get(i);
			Node b = node.children.get(j);

			node.children.set(i, b);
			node.children.set(j, a);

		}
		for (Node child : node.children) {
			mirror(child);

		}

	}

	public void printatlevel(int level) {
		printatlevel(this.root, level, 0);

	}

	private void printatlevel(Node node, int level, int cl) {
		if (cl == level) {
			System.out.print(node.data + " ");
			return;
		}

		for (Node child : node.children) {
			printatlevel(child, level, cl + 1);

		}

	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {
		System.out.println(node.data);
		for (Node child : node.children) {
			preorder(child);

		}

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {
		System.out.println(node.data);
		for (Node child : node.children) {
			postorder(child);
		}

	}

	
	public void levelorder() {

		LinkedList<Node> q = new LinkedList<>();

		q.addLast(this.root);
		while (!q.isEmpty()) {
			Node rn = q.removeFirst();
			System.out.println(rn.data);

			for (Node child : rn.children) {
				q.addLast(child);
			}
		}
	}

}
