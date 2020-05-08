package Lectures;

import java.util.Stack;
import java.util.Scanner;

public class Binary_Tree {
	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public Binary_Tree() {
		this.root = construct(null, false);

	}

	private Node construct(Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("Enter the data for root Node");

		} else {
			if (ilc) {
				System.out.println("Enter the data for left node of" + parent.data);
			} else
				System.out.println("ENter the data for right node " + parent.data);
		}

		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + "has left child?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + "has right child?");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			nn.right = construct(nn, false);
		}

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

	public int max() {
		return max(this.root);

	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;

		}
		int l = max(node.left);
		int r = max(node.right);

		return Math.max(l, r);
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

	public int diameter() {
		return diameter(this.root);

	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);

		int sp = ht(node.left) + ht(node.right) + 2;

		return Math.max(sp, Math.max(ld, rd));
	}

	private class DiaPair {
		int Diameter = 0;
		int ht = -1;
	}

	public int diameter2() {
		return diameter(this.root);
	}

	private DiaPair diameter2(Node node) {

		if (node == null) {
			DiaPair bdp = new DiaPair();
			return bdp;
		}
		DiaPair ldp = diameter2(node.left);
		DiaPair rdp = diameter2(node.right);

		DiaPair sdp = new DiaPair();

		int ld = ldp.Diameter;
		int rd = rdp.Diameter;

		int sp2 = ldp.ht + rdp.ht + 2;

		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		sdp.Diameter = Math.max(sp2, Math.max(ld, rd));

		return sdp;
	}

	public boolean isBalanced() {
		return isBalanced(this.root);

	}

	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}

		boolean lp = isBalanced(node.left);
		boolean rp = isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (bf == -1 || bf == 0 || bf == 1 & lp & rp) {
			return true;
		} else
			return false;
	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;

	}

	public boolean BalPair() {
		return isBalanced2(this.root).isBal;
	}

	private BalPair isBalanced2(Node node) {

		if (node == null) {
			return new BalPair();
		}
		BalPair ldp = isBalanced2(node.left);
		BalPair rdp = isBalanced2(node.right);

		BalPair sdp = new BalPair();
		int ld = ldp.ht;
		int rd = rdp.ht;

		int sp = ld - rd;

		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		if ((sp == -1 || sp == 0 || sp == 1) && ldp.isBal && rdp.isBal) {
			sdp.isBal = true;
		} else
			sdp.isBal = false;

		return sdp;
	}

	public void preOrder() {
		preOrder(this.root);

	}

	private void preOrder(Node node) { // NLR

		if (node == null) {
			return;
		}

		System.out.println(node.data);

		preOrder(node.left);
		preOrder(node.right);

	}

	private class Pair {
		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preOrderI() {

		Stack<Pair> s = new Stack<>();
		Pair sp = new Pair();
		sp.node = this.root;

		s.add(sp);

		while (!s.isEmpty()) {
			Pair tp = s.peek(); // topPair

			if (tp.sd == false) { // self
				System.out.println(tp.node.data);

				tp.sd = true;
			} else if (tp.ld == false) {

				Pair np = new Pair();
				np.node = tp.node.left;
				if (np.node != null) {
					s.add(np);
				}

				tp.ld = true;

			} else if (tp.rd == false) {
				Pair np = new Pair();
				np.node = tp.node.right;
				if (np.node != null) {
					s.add(np);
				}

				tp.rd = true;
			} else {
				s.pop();
			}
		}

	}

//	public Binary_Tree(int pre[], int in[]) {
//		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
//
//	}
//
//	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
//		if (plo > phi || ilo > ihi) {
//			return null;
//		}
//		Node nn = new Node();
//		nn.data = pre[plo];
//		int s = -1;
//		for (int i = ilo; i <= ihi; i++) {
//			if (in[i] == pre[plo]) {
//				s = i;
//				break;
//			}
//		}
//		int noe = s - ilo;
//
//		nn.left = construct(pre, plo + 1, plo + noe, in, ilo, s - 1);
//		nn.right = construct(pre, plo + noe + 1, phi, in, s + 1, ihi);
//
//		return nn;
//	}

	public Binary_Tree(int post[], int in[]) {
		this.root = construct(post, 0, post.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = post[phi];
		int s = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == post[phi]) {
				s = i;
				break;
			}
		}
		int noe = s - ilo;

		nn.left = construct(post, plo, plo + noe - 1, in, ilo, s - 1);
		nn.right = construct(post, plo + noe, phi - 1, in, s + 1, ihi);

		return nn;
	}

	public class BSTPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

	}

	public boolean isTreeBST() {
		return isTreeBST(this.root).isBST;

	}

	private BSTPair isTreeBST(Node node) {

		if (node == null) {
			return new BSTPair();
		}

		BSTPair lp = isTreeBST(node.left);
		BSTPair rp = isTreeBST(node.right);

		BSTPair sp = new BSTPair();

		sp.max=Math.max(node.data,Math.max(lp.max, rp.max));
		sp.min=Math.min(node.data, Math.min(lp.min, rp.min));
		
		if(lp.isBST&&rp.isBST&&node.data>lp.max&&node.data<rp.min) {
			sp.isBST=true;
		}else
			sp.isBST=false;
		
		
		return sp;
	}

}
