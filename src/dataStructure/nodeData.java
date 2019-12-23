package dataStructure;

import java.awt.Color;

import utils.Point3D;

public class nodeData implements node_data {
	int key;
	double weight;
	Point3D point;
	Color tag;
	String info;

	public nodeData() {
		this.point= Point3D.ORIGIN;	
		this.key= 0;
		this.tag= Color.black;
		this.weight = 0;
	}
	
	public nodeData(int key, int weight, Point3D point) {
		this.key=key;
		this.weight=weight;
		this.point=point;
		this.tag = Color.black;
	}

	public nodeData(nodeData a) {
		this.key = a.key;
		this.weight = a.weight;
		this.point=a.point;
		this.tag=a.tag;
	}


	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public Point3D getLocation() {
		return this.point;
	}

	@Override
	public void setLocation(Point3D p) {
		this.point=p;		
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		this.weight= w;
	}

	@Override
	public String getInfo() {
		String s ="";
		return s;
	}

	@Override
	public void setInfo(String s) {
		this.info=s;
	}

	@Override
	public int getTag() {
		return this.tag.getRGB();
	}

	@Override
	public void setTag(int t) {
		this.tag= new Color(t);
	}

}
