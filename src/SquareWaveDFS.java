
public class SquareWaveDFS {
	static final int MAXLEVEL = 4;
	public static void main(String[] args) {
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);		
		generate(new Point2D(0, 0), new Point2D(600, 0), MAXLEVEL);
	}

	private static void generate(Point2D p1, Point2D p2, int level) {
		if (level > 0) {
			drawParent(p1, p2);				
			eraseParent(p1, p2);
			Point2D[] children = children(p1, p2);
			drawChildren(children);
			for (int i = 0; i < children.length - 1; i++)
				generate(children[i], children[i + 1], level - 1);
		}
	}

	private static void drawParent(Point2D p1, Point2D p2) {
		p1.drawTo(p2);
		StdDraw.show(50);
	}

	private static void drawChildren(Point2D[] children) {
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = 0; i < children.length - 1; i++)
			children[i].drawTo(children[i + 1]);
	}
	
	private static Point2D[] children(Point2D p1, Point2D p2) {
		Point2D[] children = new Point2D[6];
		double xoffset = Math.abs(p2.x() - p1.x()) * 0.2;
		children[0] =  new Point2D(p1.x(), p1.y());
		children[1] =  new Point2D(p1.x() + xoffset, p1.y());
		children[2] =  new Point2D(p1.x() + xoffset, p1.y() + xoffset);
		children[3] = new Point2D(p1.x() + 2 * xoffset, p1.y() + xoffset);
		children[4] = new Point2D(p1.x() + 2 * xoffset, p1.y());
		children[5] = p2;
		return children;
	}
	
	private static void eraseParent(Point2D p1, Point2D p2) {
		StdDraw.setPenColor(StdDraw.WHITE);
		p1.drawTo(p2);
	}
}
