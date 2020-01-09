package Lectures;

public class GT_Client {

	public static void main(String[] args) {
		
	 //10 3 200 2 50 0 60 0 30 0 40 2 70 0 80 0 
		Generic_Tree gt=new Generic_Tree();
	
		gt.display();
	
		System.out.println(gt.size());
		System.out.println(gt.max());
		System.out.println(gt.find(2));
		
		System.out.println(gt.ht());
		gt.mirror();
		//gt.display();
		
		//gt.printatlevel(1);
		gt.preorder();
		gt.postorder();
		
		gt.levelorder();
	}
}
