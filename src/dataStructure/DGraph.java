package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DGraph implements graph{
	Map<Integer, node_data> nodes = new HashMap<Integer, node_data>();	
	Map<Integer , edge_data> edges = new HashMap<Integer , edge_data>();
	int countMC=0;
	public node_data getNode(int key) {
		return nodes.get(key);

	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if(src==dest) return null;
		if(nodes.get(src)==null || nodes.get(dest)==null) return null;
		else
		{
			int key = src*10+dest;
			if(edges.get(key)!= null) return edges.get(key);
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
			try{
				int key = (src*10+dest);
				edgeData e= new edgeData(nodes.get(src), nodes.get(dest), w);
				edges.put(key, e);
				countMC++;

			}
			catch(Exception e) {
				System.out.println("error , cannot build edge , one or more of the nodes are missing");
			}
		}
		else { 
			System.out.println("error , same nodes");
		}
	}

	@Override
	public Collection<node_data> getV() {
		ArrayList<node_data> temp = new ArrayList<node_data>();
		for(int i =0; i<nodes.size();i++)
		{
			temp.add(nodes.get(i));
		}
		return temp;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		ArrayList<edge_data> temp = new ArrayList<edge_data>();
		for(int i =0;i<edges.size();i++) {
			if(edges.get(i).getSrc()==node_id)
				temp.add(edges.get(i));

		}
		return temp;
	}

	@Override
	public node_data removeNode(int key) {
		node_data temp = (nodeData)(nodes.get(key));
		if(temp== null) return null;
		for(int i =0;i<edges.size();i++) {
			if((edges.get(i).getSrc()==key)||(edges.get(i).getDest()==key)) {
				edges.remove(i);
				countMC++;
			}
		}
		return temp;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		int key = src*10 +dest;
		edge_data temp = (edgeData) edges.get(key);
		if(temp == null) return null;
		edges.remove(key);
		countMC++;
		return temp;
	}

	@Override
	public int nodeSize() {
		if(nodes.isEmpty()) return 0;
		return nodes.size();
	}

	@Override
	public int edgeSize() {
		if(edges.isEmpty()) return 0;
		return edges.size();

	}

	@Override
	public int getMC() {
		return countMC;

	}

}
