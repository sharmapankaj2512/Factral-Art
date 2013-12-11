
public class Sierpinski {
	public static void main(String[] args) {
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
		sierpinski( new Point2D(0, 0), new Point2D(600, 0), new Point2D(300, 600), 10);
	}
	
	private static void sierpinski(Point2D p1, Point2D p2, Point2D p3, int level) {
		if (level == 1) {			
			p1.drawTo(p2);
			p2.drawTo(p3);
			p3.drawTo(p1);
		}
		else {
			Point2D p4 = midpoint(p1, p3);
			Point2D p5 = midpoint(p1, p2);
			Point2D p6 = midpoint(p2, p3);
			
			sierpinski(p1, p5, p4, level - 1);
			sierpinski(p2, p5, p6, level - 1);
			sierpinski(p3, p4, p6, level - 1);
		}
	}
	
	private static Point2D midpoint(Point2D p1, Point2D p2) {
		return new Point2D((p1.x() + p2.x())/2, (p1.y()+p2.y())/2);
	}
}
