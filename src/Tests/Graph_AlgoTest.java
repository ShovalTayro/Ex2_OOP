package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import algorithms.Edge;
import algorithms.Graph;

class Graph_AlgoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testInitGraph() {
		fail("Not yet implemented");
	}

	@Test
	void testInitString() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testIsConnected() {
		// List of graph edges as per above diagram
				List<Edge> edges = Arrays.asList(
						new Edge(0, 4), new Edge(1, 0), new Edge(1, 2),
						new Edge(2, 1), new Edge(2, 4), new Edge(3, 1),
						new Edge(3, 2) , new Edge(4, 3)
						);

				// Number of vertices in the graph
				final int N = 5;

				// construct graph
				Graph graph = new Graph(edges, N);

				// check if graph is not strongly connected or not
				if (check(graph, N))
					System.out.println("Graph is Strongly Connected");
				else
					System.out.println("Graph is not Strongly Connected");
			}
	}

	@Test
	void testShortestPathDist() {
		fail("Not yet implemented");
	}

	@Test
	void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	void testTSP() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

}
