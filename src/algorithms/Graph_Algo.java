package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	graph ourGraph;
	@Override
	public void init(graph g) {
		this.ourGraph =g;

	}

	@Override
	public void init(String file_name) {
		try
		{    
			FileInputStream file = new FileInputStream(file_name); 
			ObjectInputStream in = new ObjectInputStream(file);         
			this.ourGraph = (graph)in.readObject(); 

			in.close(); 
			file.close(); 
		} 

		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 
		catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught"); 
		} 
	} 

	@Override
	public void save(String file_name) {  
		try
		{    
			FileOutputStream file = new FileOutputStream(file_name); 
			ObjectOutputStream out = new ObjectOutputStream(file); 
			out.writeObject(this.ourGraph); 

			out.close(); 
			file.close(); 
		}   
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 
	}

	@Override
	public boolean isConnected() {
		//undirectional graph had n choose 2 edges , directional had (n choose 2)*2
		int x = this.ourGraph.nodeSize();
		int y= this.ourGraph.edgeSize();
		if(x*(x-1)==y) return true;
		else return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {

		for (int i = 0; i < ourGraph.getV().size(); i++) {
			ourGraph.getNode(i).setWeight(Double.MAX_VALUE);
		}

		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		graph temp;
		return null;
	}

}


