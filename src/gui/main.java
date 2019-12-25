package gui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import dataStructure.DGraph;
import dataStructure.nodeData;
import utils.Point3D;

public class main {

	public static void main(String[] args) {
		Color b = Color.white;
		System.out.println(b.getRGB());
		System.out.println(b);
		Color a = new Color(0);
		System.out.println(a.getRGB());
//		DGraph a = new DGraph();
//		for (int i = 0; i < 1000000; i++) {
//			Point3D p = new Point3D(i, i+1, i+2);
//			nodeData n = new nodeData(i, i, p);
//			a.addNode(n);
//		}
//		for (int i = 0; i < 1000000-10; i++) {
//			for (int j = 1; j < 11; j++) {
//				a.connect(i, i+j, 0);
//			}
//		}
//		
//		Graph_GUI window = a;
//		window.setVisible(true);

	}

}
