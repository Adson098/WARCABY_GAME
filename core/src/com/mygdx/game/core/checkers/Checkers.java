package com.mygdx.game.core.checkers;

import com.mygdx.game.core.movesRafactoring.PosMovesCalculator;


public class Checkers {

    protected colorT currentColor;
    protected PosMovesCalculator movesCalculator;
    private colorT turn;

    public Checkers(){
        currentColor = colorT.white;
        turn = colorT.white;
       // board = new Board(currentColor);
        movesCalculator = new PosMovesCalculator();
        //currentCell = new Cell();

    }
    /*
    public void clickCell(Cell cell){
        if(!(cell.getPiece() instanceof Empty)&&cell.getPiece().getColor() == currentColor) {
            currentCell = cell;
            board.setPosMoves(movesCalculator.calculate(board,cell));
           // board.printMatrixBoardState();
        }
        else{
            makeMove(cell);
        }
    }

     */
    /*
    public void makeMove(Cell cell){
        int cellX = cell.j;
        int cellY = cell.i;
        if(board.getPosMoves().matrix[cellX][cellY] == 4 || board.getPosMoves().matrix[cellX][cellY] == 3 || board.getPosMoves().matrix[cellX][cellY] == 2){
            cell.setPiece(currentCell.getPiece());
            currentCell.setPiece(new Empty(colorT.white));
            if(currentColor == colorT.white){
                currentColor = colorT.black;
            }
            else currentColor = colorT.white;
            board.changeOrientation(colorT.black);
        }


    }

     */


    public PosMovesCalculator getMovesCalculator() {
        return movesCalculator;
    }

    public colorT getCurrentColor() {
        return currentColor;
    }
}
