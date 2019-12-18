package dataStructure;

public class edgeData implements edge_data{
	int key;
	nodeData src;
	nodeData dest;
	double weight;
	int tag;
	String info;
	
	public edgeData(nodeData src, nodeData dest, double weight, int tag) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
		this.tag = tag;
		this.key = (src.key*10+dest.key);
	}
	public edgeData(node_data node_data, node_data node_data2, double weight) {
	
		this.src= (nodeData) node_data;
		this.dest=(nodeData) node_data2; 
		this.weight=weight;
		this.tag=0;
		this.key = (src.key*10+dest.key);
		}
	public edgeData(edgeData e) {
		this.src = e.src;
		this.dest = e.dest;
		this.weight = e.weight;
		this.tag = e.tag;
		this.key =e.key;
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
		this.info =s;
		
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
