package Lectures;

public class Linked_list {

	private class Node {
		int data;
		Node next;
	}

	private Node tail;
	private Node head;
	private int size;

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");

		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");

		}
		return this.tail.data;
	}

	public int getAt(int k) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");

		}
		if (k < 0 || k >= size) {
			throw new Exception("Invalid access");
		}
		Node temp = this.head;

		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		return temp.data;

	}

	public void Display() {
		for (Node temp = this.head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " ");
		}
//		Node temp = this.head;
//		while (temp != null) {
//
//			System.out.print(temp.data + " ");
//			temp = temp.next;
//		}
		System.out.println();
	}

	public void addLast(int item) {
		// Create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// Attach
		if (this.size > 0) {
			this.tail.next = nn;
		}

		// update data members
		if (size == 0) {
			this.tail = nn;
			this.head = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;

		}
	}

	public void addFirst(int item) {
		// Create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// Attach

		nn.next = this.head;

		// update data members
		if (size == 0) {
			this.tail = nn;
			this.head = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;

		}
	}

	private Node getAtNode(int k) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (k < 0 || k >= size) {
			throw new Exception("Invalid ");
		}
		Node temp = this.head;

		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		return temp;

	}

	public void addAt(int k, int item) throws Exception {
		if (k < 0 || k > this.size) {
			throw new Exception("Invalid.");

		}
		if (k == 0) {
			addFirst(item);

		}
		if (k == this.size) {
			addLast(item);

		} else {
			// Create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			Node nm1 = getAtNode(k - 1);
			Node np1 = getAtNode(k);

			nm1.next = nn;
			nn.next = np1;

			this.size++;

		}
	}

	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		int temp = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;

		} else {
			this.head = head.next;
			this.size--;
		}
		return temp;
	}

	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		int temp = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;

		} else {
			Node sm2 = getAtNode(this.size - 2);
			sm2.next = null;
			this.tail = sm2;
			this.size--;
		}
		return temp;
	}

	public int removeAt(int k) throws Exception {
		if (k < 0 || k >= this.size) {
			throw new Exception("Invalid.");
		}
		if (k == 0) {
			return removeFirst();
		} else if (k == this.size - 1) {
			return removeLast();
		} else {
			Node nm1 = getAtNode(k - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;
			return n.data;
		}
	}

	public void ReverseDataIteratively() throws Exception {
		int f = 0;
		int l = this.size - 1;

		while (f < l) {
			Node i = getAtNode(f);
			Node j = getAtNode(l);

			int temp = i.data;
			i.data = j.data;
			j.data = temp;

			l--;
			f++;
		}

	}

	public void ReversePointerIteratively() {
		Node prev = this.head;
		Node curr = this.head.next;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;

		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;
	}

	public void ReversePointerRecursively() {
		ReversePointerRecursively(this.head, this.head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void ReversePointerRecursively(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		ReversePointerRecursively(curr, curr.next);
		curr.next = prev;
	}

	public void RDataRecursively() {
//	RDataRecursively(this.head,this.head,0);
		heapmover mover = new heapmover();

		mover.left = this.head;
		RDataRecursively(mover, this.head, 0);

	}

	private Node RDataRecursively(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}
		Node cl = RDataRecursively(left, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;

		}
		return cl.next;
	}

	private class heapmover {
		Node left;
	}

	private void RDataRecursively(heapmover mover, Node right, int count) {
		if (right == null) {
			return;
		}
		RDataRecursively(mover, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;

			mover.left = mover.left.next;
		}

	}

	public void fold() {
		fold(this.head, this.head, 0);

	}

	private Node fold(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}

		Node cl = fold(left, right.next, count + 1);
		if (count > this.size / 2) {
			Node ahead = cl.next;
			cl.next = right;
			right.next = ahead;

//			return ahead;
		}
		if (count == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
//		return null;
		return right.next;
	}

	public int midRec() {

		return (midRec(this.head, this.head));
	}

	private int midRec(Node fast, Node slow) {

		if (fast.next == null || fast.next.next == null) {
			return slow.data;
		}

		return midRec(fast.next.next, slow.next);

	}

	public int kthfromLast(int k) {
		Node slow = this.head;
		Node fast = this.head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;

		}
		return slow.data;
	}

	public void kReverse(int k) throws Exception {

		Linked_list prev = null;

		while (this.size != 0) {
			Linked_list curr = new Linked_list();

			for (int i = 1; i <= k && this.size != 0; i++) {
				curr.addFirst(this.removeFirst());

			}
			if (prev == null) {
				prev = curr;

			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.head;
				prev.size += curr.size;
			}
		}
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}
}
