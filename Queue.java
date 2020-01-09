package Lectures;

//          F I F O

public class Queue {

	protected int[] data;
	protected int front;
	protected int size;

	public Queue() {
		this.data = new int[5];
		this.front = 0;
		this.size = 0;
	}

	public Queue(int cap) {
		this.data = new int[cap];
		this.front = 0;
		this.size = 0;

	}

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is Full");
		}

		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = item;
		this.size++;

	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int rv;
		rv = this.data[this.front];

		this.data[this.front] = 0;

		this.front = (this.front + 1) % this.data.length;

		this.size--;

		return rv;

	}

	public int getfront() {
		
		int rv;
		rv = this.data[this.front];

		return rv;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;

	}

	public boolean isFull() {
		return this.size() == this.data.length;

	}

	public void display() {
		for (int i = this.size - 1; i >= 0; i--) {
			int idx = (this.front + i) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
	}

}

