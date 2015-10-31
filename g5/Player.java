package cc2.g5;

import cc2.sim.Point;
import cc2.sim.Shape;
import cc2.sim.Dough;
import cc2.sim.Move;

import java.util.*;

public class Player implements cc2.sim.Player {

    public Shape cutter(int length, Shape[] shapes, Shape[] opponentShapes) {
        Shape shape = null;
        if (length == 11) {
            shape = ShapeGenerator.getNextElevenShape(shapes, opponentShapes);
        } else if (length == 8) {
            shape = ShapeGenerator.getNextEightShape(shapes, opponentShapes);
        } else if (length == 5) {
            shape = ShapeGenerator.getNextFiveShape(shapes, opponentShapes);
        }

        return shape;
    }

    public Move getBestMove(Dough dough, ArrayList<Move> elevenMoves, ArrayList<Move> eightMoves, ArrayList<Move> fiveMoves){
        if(dough.uncut()){
        	return fiveMoves.get(0);
        }
    	if(elevenMoves.size() > 0) {
    		if(elevenMoves.size() > 1)
    			return elevenMoves.get(1);
            return elevenMoves.get(0);
        } else if(eightMoves.size() > 0){
        	if(eightMoves.size() > 1)
    			return eightMoves.get(1);
            return eightMoves.get(0);
        } else {
        	if(fiveMoves.size() > 1)
    			return fiveMoves.get(1);
            return fiveMoves.get(0);
        }
    }

    public Move cut(Dough dough, Shape[] shapes, Shape[] opponent_shapes) {

        HashMap<Integer, ArrayList<Move>> moveSet = Utils.generateMoves(dough, shapes);

        ArrayList<Move> elevenMoves = moveSet.get(11);
        ArrayList<Move> eightMoves = moveSet.get(8);
        ArrayList<Move> fiveMoves = moveSet.get(5);

        System.out.println("Moves: " + Utils.totalMoves(moveSet));
        return getBestMove(dough, elevenMoves, eightMoves, fiveMoves);

    }
}
