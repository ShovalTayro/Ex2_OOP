package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class DGraph implements graph{
	Hashtable <Integer, node_data> nodes = new Hashtable<Integer, node_data>();	
	Hashtable<node_data , Hashtable<Integer,edge_data>> edges = new Hashtable<node_data, Hashtable<Integer, edge_data>>();
	int countMC=0;
	int countE = 0;
	public node_data getNode(int key) {
		return nodes.get(key);

	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if(src==dest) return null;
		if(nodes.get(src)==null || nodes.get(dest)==null) return null;
		else
		{
			node_data key= nodes.get(src);
			if(edges.get(key)!= null) return edges.get(key).get(dest);
			else {		
				return null;
			}
		}
	}

	@Override
	public void addNode(node_data n) {
		nodes.put(n.getKey(), n); 
		countMC++;
	}

	@Override
	public void connect(int src, int dest, double w) {
		if(src!=dest) {

			node_data key = nodes.get(src);
			node_data desti = nodes.get(dest);
			if (key!= null&& desti!= null) {
				edgeData e= new edgeData(nodes.get(src), nodes.get(dest), w);
				edges.get(key).put(dest, e);
				countMC++;
				countE++;
			}
			else {
				System.out.println("error , src/dest does not exist");
			}
		}
		else {
			System.out.println("error , same nodes");
		}
	}

	@Override
	public Collection<node_data> getV() {

		return nodes.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		node_data key = nodes.get(node_id);
		return  edges.get(key).values();
	}

	@Override
	public node_data removeNode(int key) {
		node_data temp = nodes.get(key);
		if(temp== null) return null;
		countE -= edges.get(temp).size();
		edges.get(temp).clear();
		for(int i = 0; i < nodes.size(); i++) {
			node_data tempR = nodes.get(i);
			edges.get(tempR).remove(key);
			countE--;

		}
		countMC++;
		return temp;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		node_data temp = nodes.get(src);
		node_data temp2 = nodes.get(dest);
		edge_data ans = null;
		if(temp != null&& temp2!= null) {
			ans=  edges.get(temp).remove(dest);
			if (ans != null)
			{
				countMC++ ;
				countE--;
			}
		}
		return ans;
	}

	@Override
	public int nodeSize() {
		if(nodes.isEmpty()) return 0;
		return nodes.size();
	}

	@Override
	public int edgeSize() {
		return countE;
	}

	@Override
	public int getMC() {
		return countMC;

	}

}
