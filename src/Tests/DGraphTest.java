package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.edgeData;
import dataStructure.edge_data;
import dataStructure.nodeData;
import dataStructure.node_data;
import utils.Point3D;

class DGraphTest {
	DGraph g = new DGraph();

	@BeforeEach
	public void createGraph() {
		for (int i = 0; i < 5; i++) {
			Point3D p = new Point3D(i, i+1, i+2);
			nodeData n = new nodeData(i, i, p);
			g.addNode(n);
		}
	}

	@Test
	void testAddNode() {
		DGraph a = new DGraph();
		for (int i = 0; i < 1000000; i++) {
			Point3D p = new Point3D(i, i+1, i+2);
			nodeData n = new nodeData(i, i, p);
			a.addNode(n);
		}
		assertEquals(1000000, a.nodeSize());
	}

	@Test
	void testConnect() {
		DGraph a = new DGraph();
		for (int i = 0; i < 1000000; i++) {
			Point3D p = new Point3D(i, i+1, i+2);
			nodeData n = new nodeData(i, i, p);
			a.addNode(n);
		}
		for (int i = 0; i < 1000000-10; i++) {
			for (int j = 1; j < 11; j++) {
				a.connect(i, i+j, 0);
			}
		}
		assertEquals(9999900, a.edgeSize());
	}


	@Test
	void testGetV() {
		Collection<node_data> actual= g.getV();
		assertTrue(actual.equals(g.getV()));
	}

	@Test
	void testGetE() {
		Collection<node_data> actual= g.getV();
		assertTrue(actual.equals(g.getV()));
	}


	@Test
	void testRemoveNode() {
		for(int j=1;j<5;j++) {
			g.connect(0, j, 0);
		}
		g.removeNode(0);
		assertEquals(0, g.edgeSize());
		assertEquals(4, g.nodeSize());
	}

	@Test
	void testRemoveEdge() {
		g.connect(0, 1, 0);
		g.connect(1, 0, 1);
		g.removeEdge(0, 1);
		g.removeEdge(2, 3);
		assertEquals(1, g.edgeSize());
	}

	@Test
	void testGetMC() {
		DGraph d = new DGraph();
		for (int i = 0; i < 5; i++) {
			Point3D p = new Point3D(i, i+1, i+2);
			nodeData n = new nodeData(i, i, p);
			d.addNode(n);
		}
		assertEquals(5, d.getMC());
		d.connect(0, 1, 0);
		d.removeNode(0);
		assertEquals(7, d.getMC());
	}

}
