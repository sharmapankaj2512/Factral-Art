
public class Pankenski {
	public static void main(String[] args) {
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
		while(true) {
			Pankenski( new Point2D(300, 0), new Point2D(0, 300), new Point2D(600, 300), new Point2D(300, 600), 20);		
			StdDraw.clear();
		}
	}
	
	private static void Pankenski(Point2D p1, Point2D p2, Point2D p3, Point2D p4, int level) {
		if (level > 0) {			
			p1.drawTo(p2);
			p2.drawTo(p4);
			p4.drawTo(p3);
			p3.drawTo(p1);
			StdDraw.show(50);
		
			Point2D p5 = midpoint(p1, p2);
			Point2D p6 = midpoint(p2, p4);
			Point2D p7 = midpoint(p4, p3);
			Point2D p8 = midpoint(p3, p1);
			
			Pankenski(p5, p6, p8, p7, level - 1);
											
		}
	}
	
	private static Point2D midpoint(Point2D p1, Point2D p2) {
		return new Point2D((p1.x() + p2.x())/2, (p1.y()+p2.y())/2);
	}
}