package Lectures;

//             L I F O

public class Stack {
//IN java we have four access modifiers: default,private ,protected and public
	
	//private (which are accessisble in a class,class and interface are never private)
	//protected (are accessible by classes of same package)
	//public (can be accessed anywhere)

	
   	protected int[] data;   //array named data to store item i.e pushed to Stack
  	protected int tos;      //top of stack 

  	
  	
	public Stack() {//DEFAULT Constructor
		this.data = new int[5];
		this.tos = -1;        
	}
	

	public Stack(int cap) {//PARAMETRIZED Constructor
		this.data = new int[cap];
		this.tos = -1;
	}
	

	public void push(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is Full");
		}

		this.tos++;
		this.data[this.tos] = item;

	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int rv;
		rv = this.data[this.tos];

		//data[tos] = 0;   //not compulsory to make it zero
		
		this.tos--;

		return rv;//bcoz we need to tell which value is removed 

	}

	public int peek() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int rv;
		rv = this.data[this.tos];

		return rv;

	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;

	}

	public boolean isFull() {
		return this.size() == this.data.length;
		//or this.toss==this.data.length-1;

	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i]);
		}
	}
}
