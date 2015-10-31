package cc2.g5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
	    int n11 = getOptMove(o1, self, dough);
	    int n12 = getOptMove(o1, oponent, dough);
	    //double dis1 = Utils.averageDistanceFromOurMoves(o1.point, moveHistory, self);
	    int n21 = getOptMove(o2, oponent, dough);
	    int n22= getOptMove(o2, oponent, dough);
	    //double dis2 = Utils.averageDistanceFromOurMoves(o2.point, moveHistory, self);
//		if(n12 == 0)
//			return -1;
//		if(n22 == 0)
//			return 1;
//		if(n21 / n22 > n11 / n12){
//			return 1;
//		}else if(n21 / n22 < n11 / n12)
//			return -1;
	    return n21 - n11;
	}
	
	// Input required: Current dough, move to be made, set of all shapes(by opponent/ours) depending on the one we are computing for
    public int getOptMove(Move move, Shape[] shapes, Dough dough)
    {
//    	System.out.println("calling opt move");
        ModdableDough curr_dough = new ModdableDough(dough);
        ModdableDough cut_dough = cut_with_move(curr_dough, move, shapes);
        HashMap<Integer, ArrayList<Move>> move_set = Utils.generateMoves(cut_dough, shapes);
        int totalMoves = Utils.totalMoves(move_set);
        System.out.println("Total moves are : "+totalMoves);
        return totalMoves;
    }


    public ModdableDough cut_with_move(ModdableDough dough, Move move, Shape[] shapes)
    {   // For a given move, this method returns the cut dough
//    	System.out.println(move.shape + " " + move.rotation + " len: " + shapes.length + "; "+ shapes[2].rotations().length);
//        System.out.println("calling cut with move");
    	try{
    	Shape shape = shapes[move.shape].rotations()[move.rotation];
        dough.cut(shape, move.point); 
//        System.out.println("done calling cut with move");
        }catch(Exception e){
        	System.out.println(move.shape + " " + move.rotation + " len: " + shapes.length + "; "+ shapes[2].rotations().length);
      
        }
        return dough;
    }
//	public double cost(int numOfMovesOfUs, int numOfMovesOfOp, double dis){
//		//
//	}
}
