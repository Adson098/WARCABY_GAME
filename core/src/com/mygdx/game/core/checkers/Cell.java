package warcaby;

enum cellColor
{
    BLACK,
    WHITE
}

public class Cell {

    // ATRUBUTY
    private String name;
    private Figura figura;
    private cellColor color;
    private boolean backLight;
    private int posX, posY;

    public Cell (String name, cellColor color)
    {
        this.name = name;
        this.color = color;
        this.figura = new EmptyField();
    }

    public Cell (String name, cellColor color, int posX, int posY)
    {
        this.name = name;
        this.color = color;
        this.figura = new EmptyField();
        this.posX = posX;
        this.posY = posY;
    }

    public Cell (String name, cellColor color, Figura figura)
    {
        this.name = name;
        this.color = color;
        this.figura = figura;
    }

    public Cell (String name, cellColor color, Figura figura, int posX, int posY)
    {
        this.name = name;
        this.color = color;
        this.figura = figura;
        this.posX = posX;
        this.posY = posY;
    }


    // Metody

    public Figura getFigura()
    {
        return this.figura;
    }


    public void setFigura( Figura figura )
    {
        this.figura = figura;
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
