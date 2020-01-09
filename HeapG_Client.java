package Lectures;

import java.util.ArrayList;

public class HeapG_Client {

	public static void main(String[] args) {

		HeapGeneric<Car> heapgc = new HeapGeneric<Car>();
		Car[] cars = new Car[5];

		cars[0] = new Car(100, 20, "Black");
		cars[1] = new Car(200, 30, "Black");

		cars[2] = new Car(150, 45, "Green");
		cars[3] = new Car(220, 40, "Blue");
		cars[4] = new Car(130, 80, "Grey");

		for (int i = 0; i <= 4; i++) {
			heapgc.add(cars[i]);
		}
		while (!heapgc.isEmpty()) {
			System.out.println(heapgc.remove());
		}

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(1);
		lists.get(0).add(8);
		lists.get(0).add(9);
		lists.get(0).add(10);
		lists.get(0).add(12);

		lists.get(1).add(5);
		lists.get(1).add(15);
		lists.get(1).add(20);

		lists.get(2).add(7);
		lists.get(2).add(13);
		lists.get(2).add(25);
		lists.get(2).add(30);

		lists.get(3).add(2);
		lists.get(3).add(3);

		System.out.println(lists);
		System.out.println(mergeKSortedLists(lists));

		ArrayList<Integer> arr = new ArrayList<>();

		arr.add(10);
		arr.add(20);
		arr.add(3);
		arr.add(4);
		arr.add(9);
		arr.add(80);

		System.out.println(kLargestElements(arr, 3));
	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int listno;
		int index;

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.data - o.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<Pair>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.index = 0;
			np.listno = 0;

			heap.add(np);

		}

		while (!heap.isEmpty()) {
			// remove
			Pair rp = heap.remove();

			// add to ans
			ans.add(rp.data);

			if (rp.index < lists.get(rp.listno).size()) {
				rp.data = lists.get(rp.listno).get(rp.index);
				rp.index++;
				heap.add(rp);
			}

		}
		return ans;
	}

	public static ArrayList<Integer> kLargestElements(ArrayList<Integer> list, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}
		for (int i = k; i < list.size(); i++) {
			int smaller = heap.getHP();

			if (list.get(i) > smaller) {
				heap.remove();
				heap.add(list.get(i));
			}

		}
		while (!heap.isEmpty()) {
			ans.add(heap.remove());

		}

		return ans;
	}

}
