package Lectures;

public class Heap_Client {

	public static void main(String[] args) {
		Heap heap=new Heap();
		
		heap.add(10);
		heap.add(20);
		heap.add(30);
		heap.add(40);
		heap.add(5);
		heap.add(70);
		
		heap.display();
		while(!heap.isEmpty()) {
			System.out.println(heap.remove());
		}
	}
}
