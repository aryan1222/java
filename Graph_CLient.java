package Lectures;

public class Graph_CLient {

	public static void main(String[] args) {

		Graph g = new Graph();

		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 2);
		g.addEdge("A", "D", 3);
		g.addEdge("B", "C", 1);
		g.addEdge("C", "D", 8);
		g.addEdge("D", "E", 10);
		g.addEdge("E", "F", 45);
		g.addEdge("E", "G", 7);
		g.addEdge("F", "G", 8);
		g.Display();

		System.out.println(g.numVertex());
		System.out.println(g.numEdges());

		System.out.println(g.containsEdge("A", "C"));

		g.removeEdge("A", "B");//
		g.removeVertex("F");
		g.addVertex("F");
		g.addEdge("A", "F", 10);
		g.Display();
		
		System.out.println(g.Bfs("A", "F"));
		g.Bft();
	}
}
