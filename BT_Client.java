package Lectures;

public class BT_Client {
public static void main(String[] args) {
	// 10 true 20 true 40 false false true 50 false false true 30 false true 70 false false 
	
	//Binary_Tree bt=new Binary_Tree();
	
//	bt.display();
//	
//	System.out.println(bt.size());
//	System.out.println(bt.ht());
//	
//	
//	System.out.println(bt.diameter2());
	int in[]= {40,20,50,60};
	int pre[]= {20 ,40,50,60};
	Binary_Tree bt=new Binary_Tree(in,pre);
	bt.display();
	
	System.out.println(bt.isTreeBST());
	
}
}
