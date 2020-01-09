package Lectures;
//STack is parent of Dynamic stack

//Therefore dynamic stack is child of Stack & have access to all functions in Stack
//But Stack can't access functions of dynamic stack

public class Dynamic_Stack extends Stack {
//dynamic stack is created to store more items>5

	@Override
	// override annotation checks in parent class for the similar type of funcn,if
	// names of both funcns are dissimilar then it gives an error

	public void push(int item) throws Exception {

		if (isFull()) {
			int[] na = new int[2 * this.data.length];// when the stack is full we make the new array which is twice the
														// size of old array

			for (int i = 0; i <= this.tos; i++) {
				na[i] = this.data[i];// then copy previous elements
			}

			this.data = na;// we need to change the reference bcoz first data was pointing to previous
							// array and now it will point to new array

		}
//and now we need to add a new item by using tos+1 and this thing we have in push funcn of parent class
		super.push(item);
		// super is a keyword used to access data members & funcns of parent class of
		// current class
	}
}
