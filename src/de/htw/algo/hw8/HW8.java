package de.htw.algo.hw8;

public class HW8 {
	private static Vertex s, t, x, y, z;	
	
	public static void main(String[] args) {
		s = new Vertex(0,"s");
		t = new Vertex(2147483647,"t");
		x = new Vertex(2147483647,"x");
		y = new Vertex(2147483647,"y");
		z = new Vertex(2147483647,"z");

		s.addAdjVertex(t, Integer.valueOf(10));
		s.addAdjVertex(y, Integer.valueOf(5));
		
		t.addAdjVertex(x, Integer.valueOf(1));
		t.addAdjVertex(y, Integer.valueOf(2));
		
		x.addAdjVertex(z, Integer.valueOf(4));

		y.addAdjVertex(t, Integer.valueOf(3));
		y.addAdjVertex(z, Integer.valueOf(2));

		z.addAdjVertex(x, Integer.valueOf(6));
		z.addAdjVertex(s, Integer.valueOf(7));

		s.printAdj();
		t.printAdj();
		x.printAdj();
		y.printAdj();
		z.printAdj();
	}
}
