package Lectures;

public class BST_Client {

	public static void main(String[] args) {
		int in[] = { 10, 20, 30, 40, 50, 60, 70 };

		BST bst = new BST(in);

		bst.display();
		System.out.println(bst.size());
		System.out.println(bst.ht());
		System.out.println(bst.max());
		System.out.println(bst.find(45));
		
		bst.display();
		
		System.out.println();
		

	}
}
