package dataStructure;

public class edgeData implements edge_data{
	nodeData src;
	nodeData dest;
	double weight;
	int tag;
	
	public edgeData(nodeData src, nodeData dest, double weight, int tag) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
		this.tag = tag;
	}
	
	public edgeData(edgeData e) {
		this.src = e.src;
		this.dest = e.dest;
		this.weight = e.weight;
		this.tag = e.tag;
	}
	
	public edgeData(node_data n1, node_data n2, double weight) {
		
	}

	@Override
	public int getSrc() {
		return this.src.key;
	}

	@Override
	public int getDest() {
		return this.dest.key;
	}

	@Override
	public double getWeight() {
		return this.dest.weight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		this.tag = t;
	}

}
