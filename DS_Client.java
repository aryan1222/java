package Lectures;

public class DS_Client {
	static int count1 = 0;
	static int count2 = 0;

	public static void main(String[] args) throws Exception {
		// Dynamic_Stack ds = new Dynamic_Stack();

//		ds.push(10);
//		
//		ds.push(20);
//		
//		ds.push(30);
//		
//		ds.push(40);
//		
//		ds.push(50);
//		
//		ds.push(60);

		// ds.display();

		// DisplayReverse(ds);
		// ds.display();

		// ActualReverse(ds, new Dynamic_Stack());
		// ds.display();

//		String str = "(()";
//		System.out.println(balancedparanthesis(str));

//		int[] arr = { 11, 9, 13, 21, 3 };
//		nextGreaterElement2(arr);

//		int[] prices = { 100, 20, 30, 90, 60, 50, 70, 80, 120, 110, 50 };
//		
//		int[] spans = stockSpan(prices);
//		
//		for (int i = 0; i < spans.length; i++) {
//					System.out.println(spans[i]);
//		}
		int[] arr = { 5, 10, 20, 2, 4, 12, 14, 1, 2 };
		nextgreaterelement(arr);
	}

	public static void DisplayReverse(Dynamic_Stack Stack) throws Exception {

		if (Stack.isEmpty()) {
			return;
		}

		int temp = Stack.pop();
		DisplayReverse(Stack);
		System.out.println(temp);
		Stack.push(temp);

	}

	public static void ActualReverse(Dynamic_Stack Stack, Dynamic_Stack helper) throws Exception {
		if (Stack.isEmpty()) {
			ActualReversehelper(Stack, helper);
			return;
		}

		int temp = Stack.pop();
		helper.push(temp);
		ActualReverse(Stack, helper);

	}

	public static void ActualReversehelper(Dynamic_Stack Stack, Dynamic_Stack helper) throws Exception {
		{
			if (helper.isEmpty()) {
				return;
			}

			int temp = helper.pop();
			ActualReversehelper(Stack, helper);
			Stack.push(temp);
		}
	}

	public static void nextGreaterElement2(int[] arr) throws Exception {

		Dynamic_Stack Stack = new Dynamic_Stack();

		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {

			while (!Stack.isEmpty() && arr[i] > arr[Stack.peek()]) {
				System.out.println(arr[Stack.peek()] + "," + arr[i]);

				ans[Stack.pop()] = arr[i];

			}
			Stack.push(i);

		}
		while (!Stack.isEmpty()) {
			System.out.println(arr[Stack.peek()] + "," + "-1");

			ans[Stack.pop()] = -1;
		}

	}

	public static int[] stockSpan(int[] arr) throws Exception {
		Dynamic_Stack Stack = new Dynamic_Stack();

		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!Stack.isEmpty() && arr[i] > arr[Stack.peek()]) {
				Stack.pop();

			}
			if (Stack.isEmpty()) {
				ans[i] = i + 1;
			} else
				ans[i] = i - Stack.peek();

			Stack.push(i);
		}
		return ans;
	}

//	public static boolean balancedparanthesis(String str) throws Exception {
//
//		for (int i = 0; i < str.length(); i++) {
//
//			char ch = str.charAt(i);
//			
//			if(ch=='('){
//			    stack.push(i);
//			}
//			else {
//			while (!stack.isEmpty() && ch == ')') {
//				return false;
//				
//				if(stack.pop()!=ch) {
//					return false;
//				}
//			}
//		}
//		}
//		if(stack.isEmpty()){
//		    return true;
//		}
//
//		return false;
//
//	}
	public static void nextgreaterelement(int[] arr) throws Exception {
		Dynamic_Stack ds = new Dynamic_Stack();

		ds.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < ds.peek()) {
				ds.push(arr[i]);
			}
			else]
			{
				while (!ds.isEmpty() && arr[i] > ds.peek()) {
					System.out.println(ds.pop() + "->" + arr[i]);
				}
				ds.push(arr[i]);
			}
			
			while(!ds.isEmpty()) {
				System.out.println(ds.pop()+"-> -1");
			}
		}

	}
}
