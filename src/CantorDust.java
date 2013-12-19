
public class CantorDust {
	public static void main(String[] args) {		
		StdDraw.setXscale(0, 800);
		StdDraw.setYscale(0, 800);
		generate(new Point2D(300,300), 300, 3);
	}

	private static void generate(Point2D p, int radius, int level) {
		if (level == 1) {
			StdDraw.setPenColor();
			StdDraw.setPenRadius();
			StdDraw.square(p.x(), p.y(), radius);		
			StdOut.print(radius + " "); StdOut.println(p);
		}
		else {						
			Point2D[] vertices = new Point2D[4];
			vertices[0] = new Point2D(p.x() - radius, p.y() - radius);
			vertices[1] = new Point2D(p.x() * 2, p.y() - radius);
			vertices[2] = new Point2D(p.x() - radius, p.y() * 2);
			vertices[3] = new Point2D(p.x() + radius, p.y() + radius);
			
			for (Point2D v : vertices) {				
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.setPenRadius(.009);
				midpoint(v, p).draw();
				generate(midpoint(v, p), radius / 2, level - 1);
			}
		}		
	}
	
	private static Point2D midpoint(Point2D p1, Point2D p2) {
		return new Point2D((p1.x() + p2.x())/2, (p1.y()+p2.y())/2);
	}
}
