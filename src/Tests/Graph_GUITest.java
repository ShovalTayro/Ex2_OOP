package Tests;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import dataStructure.DGraph;
import dataStructure.nodeData;
import dataStructure.node_data;
import gui.Graph_GUI;
import utils.Point3D;

class Graph_GUITest {

	public static void main(String[] args) throws InterruptedException {
		DGraph g = new DGraph();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {

			Point3D p = new Point3D(70+r.nextInt(400), 70+r.nextInt(400));
			nodeData n = new nodeData(i, 0, p);
	    	g.addNode(n);
			
		}
		Collection<node_data> nodes = g.getV();
		Iterator<node_data> it = nodes.iterator();
		while(it.hasNext()) {
			node_data d = it.next();
			int edges= r.nextInt(10);
			for (int i = 0; i < edges; i++) {
				int dest = r.nextInt(10);
				while(dest == d.getKey())
				{
					dest = r.nextInt(100);
				}
				double weight = r.nextInt(100);
				try {
				g.connect(d.getKey(), dest, weight);
				}
				catch(Exception e) {
				}
			}
		}
		Graph_GUI gr = new Graph_GUI(g);
		gr.setVisible(true);
		g.addNode(new nodeData(400,0, new Point3D(400,400,0)));
		g.addNode(new nodeData(480,0, new Point3D(480,480,0)));
		g.addNode(new nodeData(490,0, new Point3D(490,480,0)));
		}
}