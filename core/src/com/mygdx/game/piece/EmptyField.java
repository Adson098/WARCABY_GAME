package com.mygdx.game.piece;

import com.mygdx.game.core.checkers.Board;

public class EmptyField extends piece {
    //ATRYBUTY
    public EmptyField()
    {
        setIndexFigury(20);
    }

    // METODY
    @Override
    public int[] possibleMove(Board board, int indexPozycji) {
        return new int[0];
    }

    @Override
    public void move(Board board, int startPoint, int endPoint) {

    }
}
