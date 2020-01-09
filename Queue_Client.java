package Lectures;

public class Queue_Client {
	public static void main(String[] args) throws Exception {
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		System.out.println();
		System.out.println(q.dequeue());
		q.enqueue(60);
		q.display();
	}

}
