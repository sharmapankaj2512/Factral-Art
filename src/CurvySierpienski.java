
public class CurvySierpienski {


	public static void main(String[] args) {		
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);
		StdDraw.setPenRadius(.003);
		curvySierpinski( new Point2D(0, 0), new Point2D(600, 0), new Point2D(300, 600), 5);
	}
	
	private static void curvySierpinski(Point2D p1, Point2D p2, Point2D p3, int level) {
		if (level == 1) {									
			int r = 20;
			StdDraw.arc(p1.x(), p1.y(), r, 0, 270);
			StdDraw.arc(p1.x() + 2 * r, p1.y(), r, 270, 180);
			StdDraw.arc(p1.x(), p1.y() - 2 * r, r, 0, 90);
			StdDraw.arc(p1.x() + 2 * r, p1.y() - 2 * r, r, 90, 180);
			StdDraw.show(50);
			
			StdDraw.arc(p2.x(), p2.y(), r, 0, 270);
			StdDraw.arc(p2.x() + 2 * r, p2.y(), r, 270, 180);
			StdDraw.arc(p2.x(), p2.y() - 2 * r, r, 0, 90);
			StdDraw.arc(p2.x() + 2 * r, p2.y() - 2 * r, r, 90, 180);
			StdDraw.show(50);
			
			StdDraw.arc(p3.x(), p3.y(), r, 0, 270);
			StdDraw.arc(p3.x() + 2 * r, p3.y(), r, 270, 180);
			StdDraw.arc(p3.x(), p3.y() - 2 * r, r, 0, 90);
			StdDraw.arc(p3.x() + 2 * r, p3.y() - 2 * r, r, 90, 180);
			StdDraw.show(50);
		}
		else {
			Point2D p4 = midpoint(p1, p3);
			Point2D p5 = midpoint(p1, p2);
			Point2D p6 = midpoint(p2, p3);
			
			curvySierpinski(p1, p5, p4, level - 1);
			curvySierpinski(p2, p5, p6, level - 1);
			curvySierpinski(p3, p4, p6, level - 1);			
		}
	}
	
	private static Point2D midpoint(Point2D p1, Point2D p2) {
		return new Point2D((p1.x() + p2.x())/2, (p1.y()+p2.y())/2);
	}
}
