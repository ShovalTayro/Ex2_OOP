package gui;

import utils.Point3D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import algorithms.Graph_Algo;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class Graph_GUI extends JFrame implements ActionListener , Serializable{
	graph gr;
	Graph_Algo a = new Graph_Algo();

	public Graph_GUI() {
		initGUI();
	}

	public Graph_GUI(graph graph) {
		this.gr = graph;
		this.a.init(graph);
		initGUI();
	}

	private void initGUI(){
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		MenuBar menuBar = new MenuBar();
		Menu File = new Menu("File");
		menuBar.add(File);
		this.setMenuBar(menuBar);
		MenuItem Draw = new MenuItem("Draw graph");
		Draw.addActionListener(this);
		MenuItem Save = new MenuItem("Save");
		Save.addActionListener(this);
		MenuItem Load = new MenuItem("Load");
		Load.addActionListener(this);
		File.add(Save);
		File.add(Load);
		File.add(Draw);


		Menu Algo = new Menu("Algo");
		menuBar.add(Algo);
		this.setMenuBar(menuBar);
		MenuItem sp = new MenuItem("Shortest Path");
		sp.addActionListener(this);
		MenuItem spd = new MenuItem("Shortest Path Dist");
		spd.addActionListener(this);
		MenuItem ic = new MenuItem("Is Connceted");
		ic.addActionListener(this);
		MenuItem tsp = new MenuItem("TSP");
		tsp.addActionListener(this);

		Algo.add(sp);
		Algo.add(spd);
		Algo.add(ic);
		Algo.add(tsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		if(str.equals("Save")) {
			saveWindow();
		}

		if(str.equals("Load")) {
			Graph_Algo a = new Graph_Algo();
			a.init(gr);
			loadWindow();
		}

		if(str.equals("Draw graph")) {
			repaint();
		}

		if(str.equals("Shortest Path")) {
			clear();
			repaint();
			a.init(gr);
			windowSP();
		}

		if(str.equals("Shortest Path Dist")) {
			clear();
			repaint();
			a.init(gr);
			windowSPD();
		}

		if(str.equals("Is Connceted")) {
			a.init(gr);
			connectedWindow();
		}

		if(str.equals("TSP")) {
			clear();
			repaint();
			a.init(gr);
			windowTSP();
		}
	}


	public void paint(Graphics g) {
		super.paint(g);
		Collection<node_data> nodes = gr.getV();
		Iterator<node_data> it = nodes.iterator();
		while(it.hasNext()){
			node_data n = it.next();
			Collection<edge_data> edges = gr.getE(n.getKey());
			Point3D p = n.getLocation();
			g.setColor(Color.RED);
			g.fillOval(p.ix(), p.iy(), 8, 8);	
			g.drawString("" + n.getKey(), p.ix(), p.iy());
			Iterator<edge_data> it2 = edges.iterator();
			while(it2.hasNext()) {
				g.setColor(Color.black);
				edge_data e= it2.next();
				if(e.getTag() == -16777116) g.setColor(Color.BLUE);
				node_data p2 = gr.getNode(e.getDest());
				g.drawLine(p.ix(), p.iy(), p2.getLocation().ix(), p2.getLocation().iy());
				g.drawString(""+ e.getWeight(), (p.ix()+p2.getLocation().ix())/2, (p.iy()+p2.getLocation().iy())/2);
				g.setColor(Color.ORANGE);
				int midx = (p.ix()+p2.getLocation().ix())/2;
				int midy = (p.iy()+p2.getLocation().iy())/2;


				g.fillOval((midx+p2.getLocation().ix())/2, (midy+p2.getLocation().iy())/2, 8, 8);
			}
		}
	}


	private void clear() {
		Collection<node_data> v = gr.getV();
		Iterator<node_data> it = v.iterator();
		while(it.hasNext()) {
			node_data n = it.next();
			Collection<edge_data> e = gr.getE(n.getKey());
			Iterator<edge_data> it2 = e.iterator();
			while(it2.hasNext()) {
				edge_data ed = it2.next();
				gr.getEdge(ed.getSrc(), ed.getDest()).setTag(0);
			}
		}

	}


	private void windowTSP() {
		JFrame f=new JFrame("TSP");  
		String name = JOptionPane.showInputDialog(f, "Enter list of nodes with ',' between them :");
		String[] ans = name.split(",");
		List<Integer> targets = new ArrayList<Integer>();
		for (int j = 0; j < ans.length; j++) {
			targets.add(Integer.parseInt(ans[j]));
		}
		List<node_data> nodes =a.TSP(targets);
		for (int i = 0; i < nodes.size()-1; i++) {
			gr.getEdge(nodes.get(i).getKey(), nodes.get(i+1).getKey()).setTag(100);	
		}
		repaint();
		String answer = "";
		for (int i = 0; i < nodes.size(); i++) {
			if(i == nodes.size()-1) answer += nodes.get(i).getKey();
			else
				answer+= nodes.get(i).getKey() + "-> ";
		}
		JOptionPane.showMessageDialog(f, answer);
	}


	private void windowSP() {
		JFrame f=new JFrame("Shortest Path");  
		String src = JOptionPane.showInputDialog(f, "Enter src: ");
		String dest = JOptionPane.showInputDialog(f, "Enter dest: ");
		if(src != null && dest != null) {
			List<node_data> list = a.shortestPath(Integer.parseInt(src), Integer.parseInt(dest));
			String answer = "";
			if(list == null) answer= "There is no path between " + src + " and " + dest;
			else {
				for (int j = 0; j < list.size()-1; j++) {
					gr.getEdge(list.get(j).getKey(), list.get(j+1).getKey()).setTag(100);
				}
				repaint();
				for (int i = 0; i < list.size(); i++) {
					if(i == list.size()-1) answer += list.get(i).getKey();
					else
						answer+= list.get(i).getKey() + "-> ";
				}
			}
			JOptionPane.showMessageDialog(f, answer);
		}
	}         


	private void windowSPD() {
		JFrame f=new JFrame("Shortest Path Dist"); 
		String src = JOptionPane.showInputDialog(f, "Enter src: ");
		String dest = JOptionPane.showInputDialog(f, "Enter dest: ");
		if(src != null && dest != null) {
			double answer = a.shortestPathDist(Integer.parseInt(src), Integer.parseInt(dest));
			JOptionPane.showMessageDialog(f, "The shortest dist between " + src + " and " + dest +" is: " + answer);
		}
	}



	private void saveWindow() {
		JFrame f=new JFrame("Save to file"); 
		String name = JOptionPane.showInputDialog(f, "Enter a file name: ");
		try {
			a.save(name+".txt");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(f, "The save failed: ");
		}
		JOptionPane.showMessageDialog(f, "The save succeed");
	}         

	private void loadWindow() {
		JFrame f=new JFrame("Load from file"); 
		String name = JOptionPane.showInputDialog(f, "Enter a file name: ");
		try {
			a.init(name+".txt");
			gr = a.copy();
			repaint();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(f, "The load failed");
		}
		JOptionPane.showMessageDialog(f, "The load succeed");
	}     

	private void connectedWindow() {
		JFrame f=new JFrame("Is Connected"); 
		if(a.isConnected()) JOptionPane.showMessageDialog(f, "Is connected? TRUE");
		else {
			JOptionPane.showMessageDialog(f, "Is connected? FALSE");
		}
	}
}