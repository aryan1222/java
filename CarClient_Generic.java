package Lectures;

public class CarClient_Generic {

	public static void main(String[] args) {

		Car[] cars = new Car[5];

		cars[0] = new Car(100, 20, "Black");
		cars[1] = new Car(200, 30, "Black");

		cars[2] = new Car(150, 45, "Green");
		cars[3] = new Car(220, 40, "Blue");
		cars[4] = new Car(130, 80, "Grey");

		display(cars);
		System.out.println();
		bubblesort(cars);
		display(cars);

	}

	private static <T> void display(T[] cars) {
		// TODO Auto-generated method stub

		for (T val : cars) {
			System.out.println(val);
		}

	}

	public static <T extends Comparable<T>> void bubblesort(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
