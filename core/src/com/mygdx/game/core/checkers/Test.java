package com.mygdx.game.core.checkers;

public class Test {
    public static void main(String[] args) {
        // write your code here

        Board board = new Board();
        board.createNewBoard();

        int tablica [] = new int[2];

        tablica = board.plansza[40].getPiece().possibleMove(board, 40);

        for (int i = 0; i < 2; i++)
        {
            System.out.println(tablica[i]);
        }
    }
}
