package com.mygdx.game.piece;

import com.mygdx.game.core.checkers.Board;
import com.mygdx.game.core.checkers.colorT;

public abstract class piece {
    //Atrybuty
    private int indexFigury;
    private colorT color;

    // Metody
    public abstract int [] possibleMove (Board board, int indexPozycji);

    public void setIndexFigury(int indexFigury) {
        this.indexFigury = indexFigury;
    }

    public int getIndexFigury()
    {
        return this.indexFigury;
    }

    public colorT getColor()
    {
        return this.color;
    }

    public void setColor(colorT color)
    {
        this.color = color;
    }
}
