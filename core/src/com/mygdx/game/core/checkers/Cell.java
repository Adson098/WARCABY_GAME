package com.mygdx.game.core.checkers;


import com.mygdx.game.piece.EmptyField;
import com.mygdx.game.piece.piece;

public class Cell {

    // ATRUBUTY
    private String name;
    private piece cpiece; // current piece
    private colorT color;
    private boolean backLight;
    private int posX, posY;

    public Cell (String name, colorT color)
    {
        this.name = name;
        this.color = color;
        this.cpiece = new EmptyField();
    }

    public Cell (String name, colorT color, int posX, int posY)
    {
        this.name = name;
        this.color = color;
        this.cpiece = new EmptyField();
        this.posX = posX;
        this.posY = posY;
    }

    public Cell (String name, colorT color, piece cpiece)
    {
        this.name = name;
        this.color = color;
        this.cpiece = cpiece;
    }

    public Cell (String name, colorT color, piece cpiece, int posX, int posY)
    {
        this.name = name;
        this.color = color;
        this.cpiece = cpiece;
        this.posX = posX;
        this.posY = posY;
    }


    // Metody

    public piece getPiece()
    {
        return this.cpiece;
    }


    public void setcpiece( piece cpiece )
    {
        this.cpiece = cpiece;
    }


    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean getBackLight()
    {
        return this.backLight;
    }

    public void setBackLight(boolean backLight)
    {
        this.backLight = backLight;
    }

    public int getPosX() { return  this.posX; }

    public int getPosY() { return this.posY; }

}
