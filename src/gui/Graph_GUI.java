package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import utils.Point3D;
import algorithms.graph_algorithms;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class Graph_GUI extends JFrame implements ActionListener{
	graph gr;
	graph_algorithms g;
	Collection<node_data> nodes = gr.getV();
	Collection<edge_data> edges;

	public Graph_GUI() {
		initGUI();
		g.init(gr);
	}
	private void initGUI(){
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MenuBar menuBar = new MenuBar();
		Menu File = new Menu("File");
		menuBar.add(File);
		this.setMenuBar(menuBar);
		MenuItem Save = new MenuItem("Save");
		Save.addActionListener(this);
		MenuItem Load = new MenuItem("Load");
		Load.addActionListener(this);
		File.add(Save);
		File.add(Load);


		Menu Function = new Menu("Function");
		menuBar.add(Function);
		this.setMenuBar(menuBar);
		MenuItem draw = new MenuItem("draw graph");
		draw.addActionListener(this);
		Function.add(draw);
		//	this.addMouseListener(this);
		//
		//		Menu setting = new Menu("Setting");
		//		menuBar.add(setting);
		//		this.setMenuBar(menuBar);
		//		MenuItem canvas = new MenuItem("Set canvas size");
		//		canvas.addActionListener(this);
		//		MenuItem pc = new MenuItem("Set node color");
		//		pc.addActionListener(this);
		//		MenuItem ec = new MenuItem("Set edge color");
		//		ec.addActionListener(this);
		//
		//		setting.add(canvas);
		//		setting.add(pc);
		//		setting.add(ec);
		//		this.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		if(str.equals("Save")) {
			g.save("graph");
		}
		if(str.equals("Load")) {
			g.init("graph");
		}
		if(str.equals("draw graph")) {
			paint((Graphics)gr);
		}
	}


	public void paint(Graphics g)
	{
		super.paint(g);

		Iterator<node_data> it = nodes.iterator();
		while(it.hasNext()){
			edges= gr.getE(it.next().getKey());
			Point3D p = it.next().getLocation();
			g.setColor(Color.RED);
			g.fillOval(p.ix(), p.iy(), 10, 10);	
			g.drawString("" + it.next().getKey(), p.ix(), p.iy());
			Iterator<edge_data> it2 = edges.iterator();
			while(it2.hasNext()) {
				g.setColor(Color.black);
				edge_data e= it2.next();
				node_data p2 = gr.getNode(e.getDest());
				g.drawLine(p.ix(), p.iy(), p2.getLocation().ix(), p2.getLocation().iy());
				g.drawString(""+ e.getWeight(), (p.ix()+p2.getLocation().ix())/2, (p.iy()+p2.getLocation().iy())/2);
				g.setColor(Color.ORANGE);
				g.fillOval((p.ix()+p2.getLocation().ix())/10, (p.iy()+p2.getLocation().iy())/10, 8, 8);
			}
		}
	}
}
