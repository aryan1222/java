package Lectures;

public class DQ_Client {
	public static void main(String[] args) throws Exception {

		Dynamic_Queue dq = new Dynamic_Queue();

		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		dq.enqueue(60);
		dq.enqueue(70);

		// dq.display();

		// displayReverse(dq, 0);
		// dq.display();

		// actualReverse(dq);
		// dq.display();
	}

	public static void displayReverse(Dynamic_Queue Queue, int count) throws Exception {
		if (count == Queue.size()) {
			return;
		}
		int temp = Queue.dequeue();
		Queue.enqueue(temp);
		displayReverse(Queue, count + 1);
		System.out.println(temp);
	}

	public static void actualReverse(Dynamic_Queue Queue) throws Exception {
		if (Queue.isEmpty()) {
			return;
		}
		int temp = Queue.dequeue();
		actualReverse(Queue);
		Queue.enqueue(temp);
	}
	
}
