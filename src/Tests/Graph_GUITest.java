package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.nodeData;
import gui.Graph_GUI;
import gui.main;
import utils.Point3D;

class Graph_GUITest {

	public static void main(String[] args) {
		DGraph g = new DGraph();
	//	Graph_Algo a = new Graph_Algo();

		for (int i = 100; i < 500; i= i+100) {
			Point3D p = new Point3D(i, i+1, i+2);
			nodeData n = new nodeData(i, i, p);
			g.addNode(n);
		}
		g.connect(100, 200, 5);
		g.connect(200, 300, 4);
		g.connect(300, 400, 3);
	//	g.connect(400, 500, 2);
	//	g.connect(4, 0, 1);
	//	a.init(g);

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
