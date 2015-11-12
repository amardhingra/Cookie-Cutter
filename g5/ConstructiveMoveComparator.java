package cc2.g5;

import java.util.Comparator;

public class ConstructiveMoveComparator implements Comparator<MoveCosts> {

	@Override
	public int compare(MoveCosts o1, MoveCosts o2) {
		
		return o1.ourDiff - o2.ourDiff;
	}

}
