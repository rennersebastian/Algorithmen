package de.htw.algo.hw8;

import java.util.HashMap;

public class Vertex {
	private int d;
	private int p;
	private String name;
	private HashMap<Vertex,Integer> adj = new HashMap<Vertex,Integer>();

	public Vertex(int d, String name){
		setD(d);
		setName(name);
	}
	
	public HashMap<Vertex,Integer> adj(){
		return this.adj;
	}
	
	public void addAdjVertex(Vertex v, Integer cost){
		this.adj.put(v, cost);
	}
	
	public HashMap<Vertex,Integer> getAdj(){
		return this.adj;
	}
	
	public int getD() {
		return this.d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getP() {
		return this.p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printAdj(){		
		if(this.adj.isEmpty())
			System.out.println("No edges found for vertex " + this.getName());
		else{
			System.out.println("Adj for vertex " + this.getName());
			for(Vertex key : this.adj.keySet()){
				System.out.println(key.getName() + " : " + this.adj.get(key));
			}
			System.out.println("----------------------------");
		}
	}
}
