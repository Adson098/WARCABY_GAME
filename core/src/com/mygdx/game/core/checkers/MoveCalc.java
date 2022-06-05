package com.mygdx.game.core.checkers;

import com.mygdx.game.piece.EmptyField;
import com.mygdx.game.piece.Pawn;
import com.mygdx.game.piece.Queen;

public class MoveCalc {

    public int possiblePath[][] = new int[15][10]; // na razie publiczna
    public int rightX = 0;
    public int x = 0;
    private boolean firstLoop;
    // private int y = 0;

    public MoveCalc(Board board) {
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                possiblePath[i][j] = -1;
            }
        }
        this.firstLoop = true;
    }

    public void cleanArray()
    {
        this.x = 0;

        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                possiblePath[i][j] = -1;
            }
        }
        this.firstLoop = true;
        this.angle45 = false;
    }

    public void possiblePathPawn(int indexPozycji, Board board, colorT color, int [] path)
    {
        board.plansza[indexPozycji].setcpiece(new Pawn(color));
        int possMove [] = new int [2];
        possMove = board.plansza[indexPozycji].getPiece().possibleMove(board, indexPozycji);
        board.plansza[indexPozycji].setcpiece(new EmptyField());

        int paths[];

        if (possMove[0] != -1 && (indexPozycji - possMove[0] == 18 || indexPozycji - possMove[0] == -14))
        {
            int arrayLength = 0;
            if (path[0] == -1)
            {
                possiblePath[x][0] = possMove[0];
                paths = possiblePath[x];
                x++;
            }
            else
            {
                for (int i = 0; i < path.length; i++)
                {
                    if (path[i] != -1) {
                        possiblePath[x][i] = path[i];
                        arrayLength++;
                    }
                }
                possiblePath[x][arrayLength] = possMove[0];
                paths = possiblePath[x];
                x++;
            }
            possiblePathPawn(possMove[0], board, color, paths);
        }
        if (possMove[1] != -1 && (indexPozycji - possMove[1] == 14 || indexPozycji - possMove[1] == -18))
        {
            int arrayLength = 0;
            if (path[0] == -1)
            {
                possiblePath[x][0] = possMove[1];
                paths = possiblePath[x];
                x++;
            }
            else
            {
                for (int i = 0; i < path.length; i++)
                {
                    if (path[i] != -1) {
                        possiblePath[x][i] = path[i];
                        arrayLength++;
                    }
                }
                possiblePath[x][arrayLength] = possMove[1];
                paths = possiblePath[x];
                x++;
            }
            possiblePathPawn(possMove[1], board, color, paths);
        }


        if ( (indexPozycji - possMove[0] == -7 && indexPozycji - possMove[1] == -9) || (indexPozycji - possMove[0] == 9 && indexPozycji - possMove[1] == 7) )
        {
            this.x = 2;
            possiblePath[0][0] = possMove[0];
            possiblePath[1][0] = possMove[1];
        }
        if (possMove[0] == -1 && possMove[1]  != -1)
        {
            this.x = 1;
            possiblePath[0][0] = possMove[1];
        }
        if (possMove[1] == -1 && possMove[0] != -1)
        {
            this.x = 1;
            possiblePath[0][0] = possMove[0];
        }
    }

    private boolean angle45 = false;

    public void possiblePathQueen(int indexPozycji, Board board, colorT color, int [] path)
    {
        int paths[];

        /////////////////////  45  ///////////////////////////

        if (firstLoop == true)
        {
            int y = 0; x = 2;
            boolean first = true, second = true;
            int possMove [] = new int [64];
            Queen queen = (Queen) board.plansza[indexPozycji].getPiece();
            possMove = queen.possMoveAngle45(board, indexPozycji);
            for (int i = 0; i < 64; i++)
            {
                if (possMove[i] != -1) { possiblePath[0][y] = possMove[i]; y++; }
            }
            for (int i = 0; i < 64; i++)
            {
                if (possMove[i] != -1) { detectCollision(indexPozycji, possMove[i],possMove); }
            }
            for (int i = 0; i < 64; i++)
            { if (possMove[i] != -1) { first = false; } }
            y = 0;
            possMove = queen.possMoveAngle135(board, indexPozycji);

            for (int i = 0; i < 64; i++)
            { if (possMove[i] != -1) { possiblePath[1][y] = possMove[i]; y++; } }

            for (int i = 0; i < 64; i++)
            { if (possMove[i] != -1) { detectCollision(indexPozycji, possMove[i],possMove); } }

            for (int i = 0; i < 64; i++)
            { if (possMove[i] != -1) { second = false; } }

            if (first == true && second == true) { return; }
            else { cleanArray(); }
        }


        if (angle45)
        {
            if (firstLoop == true)
            {
                firstLoop = false;
                angle45 = false;
                possiblePathQueen(indexPozycji, board, color, path);
            }

            int arrayLength = 0;
            board.plansza[indexPozycji].setcpiece(new Queen(color));
            int possMove [] = new int [64];
            Queen queen = (Queen) board.plansza[indexPozycji].getPiece();
            possMove = queen.possMoveAngle45(board, indexPozycji);
            board.plansza[indexPozycji].setcpiece(new EmptyField());

            for (int i = 0; i < 64; i++)
            {
                if (possMove[i] != -1) { detectCollision(indexPozycji, possMove[i],possMove); }
            }

            for (int i = 0; i < 64; i++)
            {
                if(possMove[i] != -1)
                {

                    ////////////////////////////////////////////
                    for (int j = 0; j < path.length; j++)
                    {
                        if (path[j] != -1) {
                            possiblePath[x][j] = path[j];
                            arrayLength++;
                        }
                    }
                    possiblePath[x][arrayLength] = possMove[i];
                    paths = possiblePath[x];
                    x++;
                    ////////////////////////////////////////////////

                    deletePiece45(indexPozycji, possMove[i], board);
                    angle45 = false;
                    possiblePathQueen(possMove[i], board, color, paths);
                }
            }
            return;

        }
        ///////////////////// 135 ////////////////////////////
        if (!angle45)
        {
            if (firstLoop == true)
            {
                firstLoop = false;
                angle45 = true;
                possiblePathQueen(indexPozycji, board, color, path);
            }



            int arrayLength = 0;
            board.plansza[indexPozycji].setcpiece(new Queen(color));
            int possMove [] = new int [64];
            Queen queen = (Queen) board.plansza[indexPozycji].getPiece();
            possMove = queen.possMoveAngle135(board, indexPozycji);
            board.plansza[indexPozycji].setcpiece(new EmptyField());

            for (int i = 0; i < 64; i++)
            {
                if (possMove[i] != -1) { detectCollision(indexPozycji, possMove[i],possMove); }
            }

            for (int i = 0; i < 64; i++)
            {
                if(possMove[i] != -1 )
                {

                    ///////////////////////////////////////////
                    for (int j = 0; j < path.length; j++)
                    {
                        if (path[j] != -1) {
                            possiblePath[x][j] = path[j];
                            arrayLength++;
                        }
                    }
                    possiblePath[x][arrayLength] = possMove[i];
                    paths = possiblePath[x];
                    x++;
                    ///////////////////////////////////////////////

                    deletePiece135(indexPozycji, possMove[i], board);
                    angle45 = true;
                    possiblePathQueen(possMove[i], board, color, paths);
                }
            }
            return;

        }

    }

    private void detectCollision(int indexPozycji, int  path, int [] possMove)
    {
        if (path == indexPozycji-7 || path == indexPozycji + 7
                || path == indexPozycji -9 || path == indexPozycji + 9)
        {
            if (path > indexPozycji)
            {
                for(int i = 0; i < 64; i++)
                {
                    if (possMove[i] > indexPozycji)
                    {
                        possMove[i] = -1;
                    }
                }
            }
            else if (path < indexPozycji)
            {
                for (int i = 0; i < 64; i++)
                {
                    if (possMove[i] < indexPozycji)
                    {
                        possMove[i] = -1;
                    };
                }
            }

        }
    }

    private void deletePiece45(int start, int end, Board board)
    {
        if (start > end)
        {
            for (int i = end + 7; i < start; i = i + 7)
            {
                board.plansza[i].setcpiece(new EmptyField());
            }
        }

        if (end > start)
        {
            for (int i = end - 7; i < start; i = i - 7)
            {
                board.plansza[i].setcpiece(new EmptyField());
            }
        }
    }

    private void deletePiece135(int start, int end, Board board)
    {
        if (start > end)
        {
            for (int i = end + 9; i < start; i = i + 9)
            {
                board.plansza[i].setcpiece(new EmptyField());
            }
        }

        if (end > start)
        {
            for (int i = end - 9; i < start; i = i - 9)
            {
                board.plansza[i].setcpiece(new EmptyField());
            }
        }
    }

    //  W BUDOWIE ...
    public int [][] returnBestPath(int indexPozycji, Board board) throws CloneNotSupportedException {
        this.cleanArray();
        int path [] = {-1};
        Board bufforBoard;
        bufforBoard = (Board) board.clone();
        int length = 0; int check [] = new int[20];

        if (board.plansza[indexPozycji].getPiece().getIndexFigury() == 10)
        {
            possiblePathPawn(indexPozycji, bufforBoard, bufforBoard.plansza[indexPozycji].getPiece().getColor(), path);
            int path1, path2;


            for (int i = 0; i < this.x; i++)
            {
                for(int j = 0; j < possiblePath[i].length; j++)
                {
                    if (possiblePath[i][j] != -1)
                    {
                        length ++;
                    }
                }
                check[i] = length;
                length = 0;
            }
            path1 = 0;
            int check2 [] = new int[check.length];
            for (int i = 0; i < check.length; i++)
            {
                check2[i] = check[i];
            }
            // TAK JAK BY SORTOWANIE
            for (int i =0; i < 20; i++)
            {
                if (check[0] < check[i])
                {
                    int bufor = check[0];
                    check[0] = check[i];
                    check[i] = bufor;
                    path1 = i;
                }
            }

            check2[path1] = 0;


            path2 = 1;
            for (int i = 0; i < 20; i++)
            {
                if (check2[0] < check2[i])
                {
                    int bufor = check2[0];
                    check2[0] = check2[i];
                    check2[i] = bufor;
                    path2 = i;
                }
            }




            if (check[0] > check2[0])
            {
                int  possPath[][] = { possiblePath[path1] };
                return possPath;
            }
            else if (check[0] < check2[0])
            {
                int  possPath[][] = { possiblePath[path2] };
                return possPath;
            }
            else if (check[0] == check2[0])
            {
                int  possPath[][] = {possiblePath[path1], possiblePath[path2]};
                return  possPath;
            }

        }
        else if (board.plansza[indexPozycji].getPiece().getIndexFigury() == 11)
        {
            int path1, path2;
            possiblePathQueen(indexPozycji, bufforBoard, bufforBoard.plansza[indexPozycji].getPiece().getColor(), path);

            for (int i = 0; i < this.x; i++)
            {
                for(int j = 0; j < possiblePath[i].length; j++)
                {
                    if (possiblePath[i][j] != -1)
                    {
                        length ++;
                    }
                }
                check[i] = length;
                length = 0;
            }

            int check2 [] = new int[check.length];
            for (int i = 0; i < check.length; i++)
            {
                check2[i] = check[i];
            }
            path1 = 0;
            // TAK JAK BY SORTOWANIE
            for (int i =0; i < 20; i++)
            {
                if (check[0] < check[i])
                {
                    int bufor = check[0];
                    check[0] = check[i];
                    check[i] = bufor;
                    path1 = i;
                }
            }

            check2[path1] = 0;

            path2 = 1;
            for (int i = 0; i < 20; i++)
            {
                if (check2[0] < check2[i])
                {
                    int bufor = check2[0];
                    check2[0] = check2[i];
                    check2[i] = bufor;
                    path2 = i;
                }
            }


            if (check[0] > check2[0])
            {
                int  possPath[][] = { possiblePath[path1] };
                return possPath;
            }
            else if (check[0] < check2[0])
            {
                int  possPath[][] = { possiblePath[path2] };
                return possPath;
            }
            else if (check[0] == check2[0])
            {
                int  possPath[][] = {possiblePath[path1], possiblePath[path2]};
                return  possPath;
            }

        }
        else
        {
            return new int[0][0];
        }
        return new int[0][0];
    }
}
