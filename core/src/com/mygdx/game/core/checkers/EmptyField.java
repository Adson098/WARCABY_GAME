package warcaby;

public class EmptyField extends Figura{
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
}
