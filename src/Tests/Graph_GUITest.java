package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.nodeData;
import dataStructure.node_data;
import gui.Graph_GUI;
import gui.main;
import utils.Point3D;

class Graph_GUITest {

	public static void main(String[] args) {
		DGraph g = new DGraph();
		Random r = new Random();
		for (int i = 0; i < 5; i++) {

			Point3D p = new Point3D(r.nextInt(400), r.nextInt(400));
			nodeData n = new nodeData(i, 0, p);
			g.addNode(n);
		}
		Collection<node_data> nodes = g.getV();
		Iterator<node_data> it = nodes.iterator();
		while(it.hasNext()) {
			node_data d = it.next();
			int edges= r.nextInt(20);
			for (int i = 0; i < edges; i++) {
				int dest = r.nextInt(2);
				while(dest == d.getKey())
				{
					dest = r.nextInt(100);
				}
				double weight = r.nextInt(100);
				g.connect(d.getKey(), dest, weight);
			}
		}


		Graph_GUI gr = new Graph_GUI(g);
		gr.setVisible(true);
	}
}
//	DGraph g = new DGraph();
//	Graph_Algo a = new Graph_Algo();
//
//	@BeforeEach
//	public void createGraph() {
//		for (int i = 0; i < 5; i++) {
//			Point3D p = new Point3D(i, i+1, i+2);
//			nodeData n = new nodeData(i, i, p);
//			g.addNode(n);
//		}
//		g.connect(0, 1, 5);
//		g.connect(1, 2, 4);
//		g.connect(2, 3, 3);
//		g.connect(3, 4, 2);
//		g.connect(4, 0, 1);
//		a.init(g);
//	}
//
//	@Test
//	void testGraph_GUI() {
//		Graph_GUI gr = new Graph_GUI(g);
//		
//	}
//
//	@Test
//	void testActionPerformed() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testPaintGraphics() {
//		fail("Not yet implemented");
//	}
//
//}
