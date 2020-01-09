package Lectures;

public class Dynamic_Queue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (isFull()) {
			int[] na = new int[2 * this.data.length];

			
			for (int i = this.size - 1; i >= 0; i--) {
				int idx = (this.front + i) % this.data.length;
				na[i] = data[idx];
			}
			
			
			this.data = na;
			this.front = 0;
		}
		super.enqueue(item);
	}
}
