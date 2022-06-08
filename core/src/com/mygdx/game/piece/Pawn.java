package com.mygdx.game.piece;


import com.mygdx.game.core.checkers.Board;
import com.mygdx.game.core.checkers.colorT;

public class Pawn extends piece {
    //ATRYBUTY
    private int possMove[] = {-1,-1};


    public Pawn()
    {
        this.setIndexFigury(10);
        this.setColor(colorT.white);
    }

    public Pawn(colorT color)
    {
        this.setIndexFigury(10);
        this.setColor(color);
    }

    // METODY
    @Override
    public int[] possibleMove(Board board, int indexPozycji) {
        // JESLI PIONEK JEST BIALY
        if (getColor() == colorT.white) {
            // sprawdzamy LEWY
            if (indexPozycji - 9 >= 0 && board.plansza[indexPozycji-9].getPiece().getIndexFigury() == 20 && board.plansza[indexPozycji].getPosX()-1 >= 0) // jeśli na pozycji pośreniej nie stoi żadna figura możemy zrobić zwykły ruch
            {
                this.possMove[0] = indexPozycji - 9;
            }
            else if (indexPozycji - 18 >= 0 && board.plansza[indexPozycji].getPosX() -2 >= 0) {  // sparwdzamy czy te dwie pozycje w lewo to juz nie koniec planszy
                if (board.plansza[indexPozycji-9].getPiece().getIndexFigury() != 20 // sprawdzamy czy na pozycji pośredniej stoi jakaś figura
                        && board.plansza[indexPozycji-18].getPiece().getIndexFigury() == 20 )  // sprawdzamy czy pozycja końcowa jest pusta
                {
                    if (board.plansza[indexPozycji-9].getPiece().getColor() != colorT.white) // srawddzamy czy na pozycji pośreniej jest figura przeciwnika czy nasza
                    {
                        this.possMove[0] = indexPozycji - 18; // zwracamy możliwą pozycje na którą możemy się ruszyć
                    }
                }
            }
            // sprawdzamy PRAWY
            if (indexPozycji - 7 >= 0 && board.plansza[indexPozycji-7].getPiece().getIndexFigury() == 20 && board.plansza[indexPozycji].getPosX() +1 < 8) // jeśli na pozycji pośreniej nie stoi żadna figura możemy zrobić zwykły ruch
            {
                this.possMove[1] = indexPozycji - 7;
            }
            else if (indexPozycji - 14 >= 0 && board.plansza[indexPozycji].getPosX() +2 < 8){
                if (board.plansza[indexPozycji-7].getPiece().getIndexFigury() != 20
                        && board.plansza[indexPozycji-14].getPiece().getIndexFigury() == 20)
                {
                    if (board.plansza[indexPozycji-7].getPiece().getColor() != colorT.white)
                    {
                        this.possMove[1] = indexPozycji - 14;
                    }
                }
            }
        }

        // JESLI PIONEK JEST CZARNY
        if (getColor() == colorT.black){
            //spraedzamy LEWY
            if (indexPozycji+7 <= 63 && board.plansza[indexPozycji+7].getPiece().getIndexFigury() == 20 && board.plansza[indexPozycji].getPosX() - 1 >= 0) // napierw sprawdzamy czy na pozycji pośrednie nie ma pustego pola
            {
                this.possMove[0] = indexPozycji + 7; // jesli jest puste to mozemy tam zrobić ruch
            }
            else if (indexPozycji + 14 < 64 && board.plansza[indexPozycji].getPosX() - 2 >= 0 ) // jeśli na pozycji pośredniej coś istnieje, ale też spr czy możemy wykonac ewentualne bicie
            {
                if (board.plansza[indexPozycji+7].getPiece().getIndexFigury() != 20
                        && board.plansza[indexPozycji+14].getPiece().getIndexFigury() == 20)
                {
                    if (board.plansza[indexPozycji+7].getPiece().getColor() != colorT.black)
                    {
                        this.possMove[0] = indexPozycji + 14;
                    }
                }
            }

            // sprawdzamy PRAWY
            if (indexPozycji+9  <= 63 && board.plansza[indexPozycji+9].getPiece().getIndexFigury() == 20 && board.plansza[indexPozycji].getPosX() + 1 < 8)
            {
                this.possMove[1] = indexPozycji + 9;
            }
            else if (indexPozycji + 18 < 64 && board.plansza[indexPozycji].getPosX() + 2 < 8)
            {
                if (board.plansza[indexPozycji+9].getPiece().getIndexFigury() != 20
                        && board.plansza[indexPozycji+18].getPiece().getIndexFigury() == 20)
                {
                    if (board.plansza[indexPozycji+9].getPiece().getColor() != colorT.black)
                    {
                        this.possMove[1] = indexPozycji + 18;
                    }
                }
            }
        }

        return possMove;
    }

    @Override
    public void move(Board board, int startPoint, int endPoint) {
        int add =  Math.abs(startPoint - endPoint);

        if (add%7 == 0)
        {
            if (startPoint > endPoint)
            {
                for (int i = endPoint; i < startPoint; i = i+ 7)
                {
                    board.plansza[i].setcpiece(new EmptyField());
                }
                board.plansza[endPoint].setcpiece(board.plansza[startPoint].getPiece());
                board.plansza[startPoint].setcpiece(new EmptyField());
            }
            else if (startPoint < endPoint)
            {
                for (int i = startPoint; i < endPoint; i = i + 7)
                {
                    if (i != startPoint)
                        board.plansza[i].setcpiece(new EmptyField());
                }
                board.plansza[endPoint].setcpiece(board.plansza[startPoint].getPiece());
                board.plansza[startPoint].setcpiece(new EmptyField());
            }

        }
        else if (add%9 == 0)
        {
            if (startPoint > endPoint)
            {
                for (int i = endPoint; i < startPoint; i = i+ 9)
                {
                    board.plansza[i].setcpiece(new EmptyField());
                }
                board.plansza[endPoint].setcpiece(board.plansza[startPoint].getPiece());
                board.plansza[startPoint].setcpiece(new EmptyField());

            }
            else if (startPoint < endPoint)
            {
                for (int i = startPoint; i < endPoint; i = i + 9)
                {
                    if (i != startPoint)
                        board.plansza[i].setcpiece(new EmptyField());
                }
                board.plansza[endPoint].setcpiece(board.plansza[startPoint].getPiece());
                board.plansza[startPoint].setcpiece(new EmptyField());
            }

        }


        if ( getColor() == colorT.white)
        {
            if (board.plansza[endPoint].getPosY() == 8)
                board.plansza[endPoint].setcpiece(new Queen());
        }

        if ( getColor() == colorT.black)
        {
            if (board.plansza[endPoint].getPosY() == 1)
            {
                board.plansza[endPoint].setcpiece(new Queen(colorT.black));
            }
        }
    }
}
