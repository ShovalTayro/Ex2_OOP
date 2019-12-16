package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DGraph implements graph{
	Map<Integer, node_data> nodes = new HashMap<Integer, node_data>();	
	public node_data getNode(int key) {
		return nodes.get(key);
		
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if(nodes.get(src)==null || nodes.get(dest)==null) return null;
		else
		{
			//there is edge? return him else null
		
			return null;
		}
	}

	@Override
	public void addNode(node_data n) {
	nodes.put(n.getKey(), n);
	}

	@Override
	public void connect(int src, int dest, double w) {
		edgeData e= new edgeData(nodes.get(src), nodes.get(dest), w);
		
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
