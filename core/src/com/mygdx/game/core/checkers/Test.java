package com.mygdx.game.core.checkers;
import com.mygdx.game.core.checkers.MoveCalc;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Board board = new Board();
        board.createNewBoard();
        MoveCalc cals = new MoveCalc(board);

        int tablica [][] = cals.returnBestPath(40,board);
        for (int i = 0;i < tablica.length; i++)
        {
            for(int j = 0; j < tablica[i].length; j++)
            {
                System.out.print(tablica[i][j] + " ");
            }
            System.out.println();
        }
    }
}
