package Lectures;

import java.util.ArrayList;

public class Heap {

	private ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return data.size();

	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public void add(int item) {
		this.data.add(item);
		Upheapify(this.data.size() - 1);

	}

	private void Upheapify(int ci) {
		int pi = (ci - 1) / 2;

		int i = data.get(ci);
		int j = data.get(pi);

		if (i < j) {
			swap(pi, ci);
			Upheapify(pi);
		}
	}

	private void swap(int i, int j) {

		int ith = data.get(i);
		int jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public int remove() {
		swap(0, data.size() - 1);

		int rv = data.remove(data.size() - 1);

		downheapify(0);

		return rv;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}
		if (rci < data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}

	}

	public int getHP() {
		return data.get(0);
	}
}
