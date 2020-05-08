package Lectures;

public class Array_Demo {
public static void main(String[] args) {
	//Declare
	int arr[]=null;
	
	//Space Allocation
	arr=new int[5];
	
	//Set
	arr[0]=10;
	arr[1]=20;
	arr[2]=30;
	arr[3]=40;
	arr[4]=50;
	
	//Enhanced Forloop to print values
	for(int val:arr) {
		System.out.println(val);
	}

	
	int i=0,j=2;
	//non working swap           SWAP1
	System.out.println();
	System.out.println(arr[i]+","+arr[j]);
	Swap1(arr[i],arr[j]);
	System.out.println(arr[i]+","+arr[j]);
	
	
	//working swap               SWAP2
	System.out.println();
	System.out.println(arr[i]+","+arr[j]);
	Swap2(arr,i,j);
	System.out.println(arr[i]+","+arr[j]);

	//                           SWAP3
	System.out.println();
	int other[]= {100,200,300};
	System.out.println(arr[0]+","+other[0]);
	Swap3(arr,other);
	System.out.println(arr[0]+","+other[0]);

	
	
}
public static void Swap1(int one,int two ) {
	int temp=one;
	one=two;
	two=temp;
}

public static void Swap2(int[]arr,int i,int j) {
	System.out.println(arr[i]+","+arr[j]);

	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
	System.out.println(arr[i]+","+arr[j]);

}

public static void Swap3(int[] one,int[] two) {
	int[]temp=one;
	one=two;
	two=temp;
}
}
