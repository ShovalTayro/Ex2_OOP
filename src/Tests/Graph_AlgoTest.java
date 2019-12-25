package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.nodeData;
import dataStructure.node_data;
import utils.Point3D;

class Graph_AlgoTest {

	DGraph g = new DGraph();
	Graph_Algo a = new Graph_Algo();

	@BeforeEach
	public void createGraph() {
		for (int i = 0; i < 5; i++) {
			Point3D p = new Point3D(i, i+1, i+2);
			nodeData n = new nodeData(i, i, p);
			g.addNode(n);
		}
		a.init(g);
	}
//	@Test
	void testSave() {
		try {
			a.save("graph.txt");
			Graph_Algo b = new Graph_Algo();
			b.init("graph.txt");
//			assertEqual(a,b);
		}
		catch(Exception e)
		{
			System.out.println("can not save to file");
		}
	}

		@Test
		void testInitString() {
			fail("not yet implemented");
		}

		@Test
		void testIsConnected() {
			g.connect(0, 1, 5);
			g.connect(1, 2, 4);
			g.connect(2, 3, 3);
			g.connect(3, 4, 2);
			g.connect(4, 0, 1);
			assertTrue(a.isConnected());
			
			g.removeEdge(0, 1);
			assertFalse(a.isConnected());
			
			DGraph graph = new DGraph();
			Graph_Algo graphA = new Graph_Algo();
			graph.addNode(new nodeData(0, 1, new Point3D(0,0,0)));
			graphA.init(graph);
			assertTrue(graphA.isConnected());		
	}

	@Test
	void testShortestPathDist() {
		g.connect(0, 1, 1);
		g.connect(0, 4, 1);
		g.connect(1, 2, 1);
		g.connect(1, 3, 5);
		g.connect(2, 3, 2);
		g.connect(4, 3, 1);
		g.connect(4, 1, 2);
		Graph_Algo graphA = new Graph_Algo();
		graphA.init(g);
		double ans = graphA.shortestPathDist(0, 3);
		assertEquals(2, ans);
		g.removeEdge(4, 3);
		ans = graphA.shortestPathDist(4, 3);
		assertEquals(5, ans);		
	}

	@Test
	void testShortestPath() {
		g.connect(0, 1, 1);
		g.connect(0, 4, 1);
		g.connect(1, 2, 1);
		g.connect(1, 3, 5);
		g.connect(2, 3, 2);
		g.connect(4, 1, 2);
		Graph_Algo graphA = new Graph_Algo();
		graphA.init(g);
		List<node_data> ans = graphA.shortestPath(4, 3);
		nodeData a = new nodeData(4, 4, new Point3D(4,5,6));
		nodeData b = new nodeData(1, 1, new Point3D(1,2,3));
		nodeData c = new nodeData(2, 2, new Point3D(2,3,4));
		nodeData d = new nodeData(3, 3, new Point3D(3,4,5));
				
		List<node_data> exp = new ArrayList<node_data>();
		exp.add(a);
		exp.add(b);
		exp.add(c);
		exp.add(d);
		String actual = null;
		String expected = null;
		for (int i = 0; i < ans.size(); i++) {
			actual = ""+ans.get(i).getKey();
		}
		for (int i = 0; i < exp.size(); i++) {
			expected = ""+exp.get(i).getKey();
		}
		assertTrue(expected.equals(actual));
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
