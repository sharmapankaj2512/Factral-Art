
public class CantorSet {  	
	public static void main(String[] args) {
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);			
		generate(new Point2D(0, 0), new Point2D(600, 0), 6);
	}

	private static void generate(Point2D p1, Point2D p2, int level) {		
		if (level > 0) {					 
			StdDraw.line(p1.x(), p1.y(), p2.x(), p2.y());			
			double offset = Math.abs(p2.x() - p1.x()) / 3;
			generate(new Point2D(p1.x(), p1.y() + 30), new Point2D(p1.x() + offset, p2.y() + 30), level - 1);									
			generate(new Point2D(p1.x() + 2 * offset, p1.y() + 30), new Point2D(p2.x(), p2.y() + 30), level - 1);
			StdDraw.show(50);
		}						
	}	
}
