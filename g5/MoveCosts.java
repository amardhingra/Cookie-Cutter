package cc2.g5;

import cc2.sim.Move;

public class MoveCosts {

    public Move move;
    public float playerMoves;
    public float opponentMoves;
    public float cost;

//    public MoveCosts(Move m, float pm, float om, double distance){
//        this.move = m;
//
//        this.playerMoves = pm;
//        this.opponentMoves = om;
//
//        cost = opponentMoves / playerMoves; // + 1 / (float)distance);
//    }
    //TODO: maybe we should create two constructor, one for straight line
    public MoveCosts(Move m, int opDiff, int ourDiff, float distance){
    	this.move = m;
    	if(opDiff == 0){
    		this.cost = Integer.MAX_VALUE;
    	}else{
    		//TODO this.cost = distance * (ourBefore - ourAfter) / (oPbefore - oPafter);
    		//don't know whether this will be better...
    		//smaller better
    		this.cost = ourDiff / opDiff;
    	}
    }
}
