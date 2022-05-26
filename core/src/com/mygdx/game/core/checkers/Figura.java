package warcaby;

enum figuraColor
{
    BLACK,
    WHITE
}

public abstract class Figura {
    //Atrybuty
    private int indexFigury;
    private figuraColor color;

    // Metody
    public abstract int [] possibleMove (Board board, int indexPozycji);

    public void setIndexFigury(int indexFigury) {
        this.indexFigury = indexFigury;
    }

    public int getIndexFigury()
    {
        return this.indexFigury;
    }

    public figuraColor getColor()
    {
        return this.color;
    }

    public void setColor(figuraColor color)
    {
        this.color = color;
    }
}
