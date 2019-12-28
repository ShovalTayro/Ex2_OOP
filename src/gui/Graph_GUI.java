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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import algorithms.Graph_Algo;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class Graph_GUI extends JFrame implements ActionListener , Serializable{
	graph gr;
	//	graph_algorithms g;

	Graph_Algo a = new Graph_Algo();


	public Graph_GUI() {
		initGUI();
		//	g.init(gr);
	}

	public Graph_GUI(graph graph) {
		this.gr = graph;
		this.a.init(graph);
		initGUI();
		//	g.init(gr);
	}

	private void initGUI(){
		this.setSize(500, 500);
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
		MenuItem ic = new MenuItem("Is Connceted");
		ic.addActionListener(this);
		MenuItem tsp = new MenuItem("TSP");
		tsp.addActionListener(this);

		Algo.add(sp);
		Algo.add(ic);
		Algo.add(tsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		if(str.equals("Save")) {
			saveWindow();
			//a.save("graph");

		}
		if(str.equals("Load")) {
			Graph_Algo a = new Graph_Algo();
			a.init(gr);
			loadWindow();
			//a.init("graph");
		}
		if(str.equals("Draw graph")) {
			repaint();
		}

		if(str.equals("Shortest Path")) {
			a.init(gr);
			windowSP();
		}
		if(str.equals("Is Connceted")) {
			a.init(gr);
			connectedWindow();
		}
		if(str.equals("TSP")) {
		}
	}




	private void windowSP() {
		JFrame f=new JFrame("Shortest Path"); 
		//submit button
		JButton b=new JButton("Submit");    
		b.setBounds(80,150,140, 40);    
		//enter name label
		JLabel label = new JLabel();		
		label.setText("Enter Src :");
		label.setBounds(10, 10, 100, 100);
		JLabel label1 = new JLabel();
		label1.setText("Enter Dest :");
		label1.setBounds(10, 50, 100, 100);
		//textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
		JTextField textfield1= new JTextField();
		textfield1.setBounds(110, 90, 130, 30);
		//add to frame
		f.add(label1);
		f.add(textfield);
		f.add(label);
		f.add(b);    
		f.add(textfield1);
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);       

		//action listener
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<node_data> list = a.shortestPath(Integer.parseInt(textfield.getText()), Integer.parseInt(textfield1.getText()))	;	
				for (int j = 0; j < list.size()-1; j++) {
					gr.getEdge(list.get(j).getKey(), list.get(j+1).getKey()).setTag(100);
				}
				repaint();
				f.setVisible(false);
			}     
		});
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


				g.fillOval((midx+p2.getLocation().iy())/2, (midy+p2.getLocation().iy())/2, 8, 8);
			}
		}
	}


	private void saveWindow() {

		JFrame f=new JFrame("Save to file"); 
		//submit button
		JButton b=new JButton("Submit");    
		b.setBounds(100,100,140, 40);    
		//enter name label
		JLabel label = new JLabel();		
		label.setText("Enter file name :");
		label.setBounds(10, 10, 100, 100);
		//empty label which will show event after button clicked
		//JLabel label1 = new JLabel();
		//label1.setBounds(10, 110, 200, 100);
		//textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
		//add to frame
		//f.add(label1);
		f.add(textfield);
		f.add(label);
		f.add(b);    
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		//action listener
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				a.save(textfield.getText()+".txt");		
				f.setVisible(false);    

			}          
		});
	}         

	private void loadWindow() {
		JFrame f=new JFrame("Load from file"); 
		//submit button
		JButton b=new JButton("Load");    
		b.setBounds(100,100,140, 40);    
		//enter name label
		JLabel label = new JLabel();		
		label.setText("Enter file name :");
		label.setBounds(10, 10, 100, 100);
		//textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
		f.add(textfield);
		f.add(label);
		f.add(b);    
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		//action listener
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				a.init(textfield.getText()+".txt");	
				gr = a.copy();
				f.setVisible(false);
				repaint();

			}          
		});
	}     

	private void connectedWindow() {
		JFrame f=new JFrame("Is Connected"); 
		JButton b=new JButton("close");    
		b.setBounds(60,100,140, 40); 
		//enter name label
		JLabel label = new JLabel();
		label.setBounds(30, 30, 200	, 100);
		if(a.isConnected()) label.setText("is connected? true ");
		else {
			label.setText("is connected? false ");
		}
		f.add(b);
		f.add(label);
		f.setSize(300,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {	
				f.setVisible(false);
			}          
		});

	}
}






