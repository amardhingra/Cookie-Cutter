package cc2.g5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cc2.sim.Dough;
import cc2.sim.Move;
import cc2.sim.Shape;

public class MoveComparator implements Comparator<Move> {
	public Shape[] self;
	public Shape[] oponent;
	public Dough dough;
	public ArrayList<Move> moveHistory;
	public MoveComparator(Shape[] self, Shape[] oponet, Dough dough, ArrayList<Move> moveHistory) {
		this.self = self;
		this.oponent = oponet;
		this.dough = dough;
		this.moveHistory = moveHistory;
	}
	@Override
	public int compare(Move o1, Move o2) {
	    int n11 = depending(o1, self, dough);
	    int n12 = depending(o1, oponent, dough);
	    double dis1 = Utils.averageDistanceFromOurMoves(o1.point, moveHistory, self);
	    int n21 = depending(o2, oponent, dough);
	    int n22= depending(o2, oponent, dough);
	    double dis2 = Utils.averageDistanceFromOurMoves(o2.point, moveHistory, self);
		return n11 / n12 - n21 / n22;
	}
	public int depending(Move move, Shape[] shape, Dough dough){
		return 0;
	}

//	public double cost(int numOfMovesOfUs, int numOfMovesOfOp, double dis){
//		//
//	}
}
