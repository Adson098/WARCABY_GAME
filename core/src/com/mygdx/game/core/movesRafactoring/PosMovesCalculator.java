package com.mygdx.game.core.movesRafactoring;

import com.mygdx.game.core.chess.Board;
import com.mygdx.game.core.chess.Cell;
import com.mygdx.game.vector2i;

public class PosMovesCalculator {

    public PosMovesCalculator(){ }// possible moves calculator

     public int[][] calculate(Board iboard, Cell icell) {
       return Stage1.calculate(iboard,icell);
    }

    public static class Stage1{
        public Stage1(){ }

        public static int[][] calculate(Board iboard, Cell icell){
            int[][] tempMatrix = new int[8][8];
            if (icell != null) {
                vector2i posMatrixSize = icell.getPiece().getMoves().size;
                vector2i posPieceLocation = icell.getPiece().getMoves().location;
                int[][] posMatrix = icell.getPiece().getMoves().MOVES;
                int startPointY = icell.i - posPieceLocation.y;
                int startPointX = icell.j - posPieceLocation.x;
                int posStartPointY = 0;
                int posStartPointX = 0;
                if(posMatrixSize.x >8 && posMatrixSize.y>8){
                    posStartPointY = posPieceLocation.y - icell.i ;
                    posStartPointX = posPieceLocation.x - icell.j ;
                }
                for (int i = 0; i < posMatrixSize.y ; i++) {
                    for (int j = 0; j < posMatrixSize.x ; j++) {

                        if ((j + startPointX )>= 0 && (j + startPointX )< 8) {
                            if ((i + startPointY) >= 0 &&( i + startPointY) < 8) {
                                tempMatrix[startPointX + j][startPointY + i] = posMatrix[i][j];
                            }
                        }
                    }
                }
            }
            return tempMatrix;
        }
    }


    public class Stage2{
        public Stage2(){ }
        public void calculate(Board iboard){ }
    }

}

