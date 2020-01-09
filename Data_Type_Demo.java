package Lectures;

public class Data_Type_Demo {

	public static void main(String[] args) {

		byte by = 10;
		short sh = 258;
		int in = 10;
		long lo = 10;

		// Part 1
		// by = sh;
		// by = in;
		// by = lo;
		// sh = by;
		// sh = in ;
		// sh = lo ;
		in = by;
		in = sh;
		// in = lo ;
		lo = by;
		lo = sh;
		lo = in;

		
		// Part 2
		System.out.println();
		by = -128;
		System.out.println(by);
		by = (byte) 259;
		System.out.println(by);

		
		// Part 3
		System.out.println();
		in = (int) 10000000000L;

		
		// Part 4
		System.out.println();
		float fl = 4.5f;
		double db = 5.6;
		// fl = db ;
		db = fl;

		
		// Part 5
		System.out.println();
		in = (int) fl;
		System.out.println(in);
		fl = in;
		System.out.println(fl);

		// Part 6
		System.out.println();
		boolean bl = true;
		if (bl) {
		}
		if (in > 1) {
		}

		
		// Part 7
		System.out.println();
		char ch = 'a';
		System.out.println(ch);
		System.out.println((int) ch);
		// in = ch ;
		// System.out.println(in);
		// ch = (char) in ;
		int ch1 = (ch + 't');

		
		// Part 9
		System.out.println();
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World" +'\n');
		System.out.println("Hello" + "\t" + "World" + "\n");

	}

}
