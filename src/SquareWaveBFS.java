public class SquareWaveBFS {
	private static final int MAXLEVEL = 100;
	private static Queue<Line> segments = new Queue<Line>();
	
	private static class Line {
		private final Point2D p1;
		private final Point2D p2;
		private Line parent;
		
		public Line(Point2D p1, Point2D p2, Line parent) {
			this.p1 = p1; 
			this.p2 = p2;
			this.parent = parent;
		}
		
		public void drawBlack() {
			StdDraw.setPenColor(StdDraw.BLACK);
			p1.drawTo(p2);
		}
		
		public void drawWhite() {
			StdDraw.setPenColor(StdDraw.WHITE);
			p1.drawTo(p2);
		}
	}
	
	public static void main(String[] args) {
		StdDraw.setXscale(0, 600);
		StdDraw.setYscale(0, 600);	
		segments.enqueue(new Line(new Point2D(0, 0), new Point2D(600, 0), null));		
		generate(MAXLEVEL);
	}

	private static void generate(int level) {
		if (level > 0 && !segments.isEmpty()) {
			Line line = segments.dequeue();
			line.drawBlack();
			StdDraw.show(100);	
			line.drawWhite();
			children(line);
			generate(level - 1);
		}		
	}		
	
	private static void children(Line line) {		
		double xoffset = Math.abs(line.p2.x() - line.p1.x()) * 0.2;
		
		
		Point2D  p3 =  new Point2D(line.p1.x() + xoffset, line.p1.y());		
		Point2D  p4 =  new Point2D(line.p1.x() + 2 * xoffset, line.p1.y());
		Point2D  p5 = new Point2D(line.p1.x() + 2 * xoffset, line.p1.y() + xoffset);
		Point2D  p6 = new Point2D(line.p1.x() + 3 * xoffset, line.p1.y() + xoffset);
		Point2D  p7 = new Point2D(line.p1.x() + 3 * xoffset, line.p1.y());
		Point2D  p8 = new Point2D(line.p1.x() + 4 * xoffset, line.p1.y());
		
		
		Line line1 = new Line(line.p1, p3, line);
		line1.drawBlack();
		segments.enqueue(line1);
		
		Line line2 = new Line(p3, p4, line);
		line2.drawBlack();
		segments.enqueue(line2);
		
		Line line3 = new Line(p4, p5, line);
		line3.drawBlack();
		segments.enqueue(line3);
		
		Line line4 = new Line(p5, p6, line);
		line4.drawBlack();
		segments.enqueue(line4);
		
		Line line5 = new Line(p6, p7, line);
		line5.drawBlack();
		segments.enqueue(line5);
		
		Line line6 = new Line(p7, p8, line);
		line6.drawBlack();
		segments.enqueue(line6);
		
		Line line7 = new Line(p8, line.p2, line);
		line7.drawBlack();
		segments.enqueue(line7);
	}
	
}
