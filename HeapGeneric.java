package Lectures;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {

	private ArrayList<T> data = new ArrayList<>();

	public int size() {
		return data.size();

	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public void add(T item) {
		this.data.add(item);

		Upheapify(this.data.size() - 1);

	}

	private void Upheapify(int ci) {
		int pi = (ci - 1) / 2;

		T i = data.get((int) ci);
		T j = data.get((int) pi);

		if (isLarger(i, j) > 0) {
			swap(pi, ci);
			Upheapify(pi);

		}

	}

	private void swap(int pi, int ci) {

		T ith = data.get(pi);
		T jth = data.get(ci);

		data.set(pi, jth);
		data.set(ci, ith);

	}

	public T remove() {
		swap(0, data.size() - 1);

		T rv = data.remove(data.size() - 1);

		downheapify(0);

		return rv;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}
		if (rci < data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}

	}
	
	
	// t priority greater -> +ve
	// o priority greater -> -ve

	private int isLarger(T t, T o) {

		return t.compareTo(o);
	}

}
