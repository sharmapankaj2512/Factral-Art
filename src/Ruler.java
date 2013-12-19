
public class Ruler {
	public static void rule(int l, int r, int h) {
		int m = (l + r) / 2;
		if (h > 0) {
			rule(l, m, h - 1);			
			StdDraw.line(m, 0, m, h);
			StdOut.println("mark(" + m +", " + h + ")");
			rule(m, r, h - 1);
		}
	}
	
	public static void main(String[] args) {
		StdDraw.setXscale(0 , 100);
		StdDraw.setYscale(0 , 50);
		while(true) {
			StdDraw.clear();
			rule(0 , 100, 10);
		}
	}
}
