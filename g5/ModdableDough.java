package cc2.g5;

import cc2.sim.Dough;
import cc2.sim.Point;
import cc2.sim.Shape;

public class ModdableDough extends Dough {

	private boolean[][] dough;

	public ModdableDough(Dough dough) {
		super(dough.side());
		Point[] s = {new Point(0,0)};
		Shape shape = new Shape(s);
		for(int i = 0; i < dough.side(); ++i) {
			for(int j = 0; j < dough.side(); ++j) {
				if(!dough.uncut(i, j))
					cut(shape, new Point(i,j));
			}
		}
	}

	// perform cut using shape (simulator calls this)
	public boolean undoCut(Shape shape, Point q)
	{
		for (Point p : shape) {
			dough[p.i + q.i][p.j + q.j] = false;
		}
		
		return true;
	}

}
