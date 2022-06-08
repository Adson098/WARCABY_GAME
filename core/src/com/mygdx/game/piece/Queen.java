package com.mygdx.game.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.core.checkers.Board;
import com.mygdx.game.core.checkers.colorT;

public final class Queen extends piece {
    // ATRYBUTY
    private int possMove[] = new int [64];

    // KONSTRUKTORY
    public Queen()
    {
        this.setIndexFigury(11);
        this.setColor(colorT.white);
    }

    public Queen(colorT color)
    {
        this.setIndexFigury(11);
        this.setColor(color);
    }

    // METODY
    @Override
    public int[] possibleMove(Board board, int indexPozycji) {
        // czyszczenie tablicy
        for (int i = 0; i < 64; i++) { possMove[i] = -1; }

        int leftUp [] = new int [8]; for (int i = 0; i < 8; i++) {leftUp[i] = -1;}
        int rightUp [] = new int [8]; for (int i = 0; i < 8; i++) {rightUp[i] = -1;}
        int leftDown [] = new int [8]; for (int i = 0; i < 8; i++) {leftDown[i] = -1;}
        int rightDown [] = new int [8]; for (int i = 0; i < 8; i++) {rightDown[i] = -1;}

        // LEFT UP
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, -i, i, indexPozycji + i * -9, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * -9), board))
                {
                    leftUp[i-1] = indexPozycji + (i * -9);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* -9), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*-9), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, -i, i, indexPozycji + ((i+1) * -9), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * -9), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        leftUp = orderLeftArray(leftUp);

        // RIGHT UP
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, i, i, indexPozycji + i * -7, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * -7), board))
                {
                    rightUp[i-1] = indexPozycji + (i * -7);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* -7), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*-7), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, i, i, indexPozycji + ((i+1) * -7), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * -7), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        rightUp = orderRightArray(rightUp);

        // LEFT DOWN
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, -i, -i, indexPozycji + i * 7, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * 7), board))
                {
                    leftDown[i-1] = indexPozycji + (i * 7);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* 7), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*7), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, -i, -i, indexPozycji + ((i+1) * 7), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * 7), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        leftDown = orderLeftArray(leftDown);

        // RIGHT DOWN
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, i, -i, indexPozycji + i * 9, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * 9), board))
                {
                    rightDown[i-1] = indexPozycji + (i * 9);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* 9), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*9), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, i, -i, indexPozycji + ((i+1) * 9), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * 9), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        rightDown = orderRightArray(rightDown);



        for (int i =0 ; i < 8; i++)
        {
            if (leftUp[i] != -1)
            {
                possMove[i] = leftUp[i];
            }
        }
        for (int i =8 ; i < 16; i++)
        {
            if (rightUp[i-8] != -1)
            {
                possMove[i] = rightUp[i-8];
            }
        }
        for (int i =16 ; i < 24; i++)
        {
            if (leftDown[i-16] != -1)
            {
                possMove[i] = leftDown[i-16];
            }
        }
        for (int i =24 ; i < 32; i++)
        {
            if (rightDown[i-24] != -1)
            {
                possMove[i] = rightDown[i-24];
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
    }


    public int[] possMoveAngle45(Board board, int indexPozycji) {
        // czyszczenie tablicy
        for (int i = 0; i < 64; i++) { possMove[i] = -1; }

        int rightUp [] = new int [8]; for (int i = 0; i < 8; i++) {rightUp[i] = -1;}
        int leftDown [] = new int [8]; for (int i = 0; i < 8; i++) {leftDown[i] = -1;}


        // RIGHT UP
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, i, i, indexPozycji + i * -7, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * -7), board))
                {
                    rightUp[i-1] = indexPozycji + (i * -7);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* -7), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*-7), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, i, i, indexPozycji + ((i+1) * -7), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * -7), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        rightUp = orderRightArray(rightUp);

        // LEFT DOWN
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, -i, -i, indexPozycji + i * 7, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * 7), board))
                {
                    leftDown[i-1] = indexPozycji + (i * 7);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* 7), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*7), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, -i, -i, indexPozycji + ((i+1) * 7), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * 7), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        leftDown = orderLeftArray(leftDown);


        for (int i =8 ; i < 16; i++)
        {
            if (rightUp[i-8] != -1)
            {
                possMove[i] = rightUp[i-8];
            }
        }
        for (int i =16 ; i < 24; i++)
        {
            if (leftDown[i-16] != -1)
            {
                possMove[i] = leftDown[i-16];
            }
        }

        return possMove;
    }

    public int[] possMoveAngle135(Board board, int indexPozycji) {
        // czyszczenie tablicy
        for (int i = 0; i < 64; i++) { possMove[i] = -1; }

        int leftUp [] = new int [8]; for (int i = 0; i < 8; i++) {leftUp[i] = -1;}
        int rightDown [] = new int [8]; for (int i = 0; i < 8; i++) {rightDown[i] = -1;}

        // LEFT UP
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, -i, i, indexPozycji + i * -9, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * -9), board))
                {
                    leftUp[i-1] = indexPozycji + (i * -9);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* -9), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*-9), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, -i, i, indexPozycji + ((i+1) * -9), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * -9), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        leftUp = orderLeftArray(leftUp);



        // RIGHT DOWN
        for (int i = 1; i < 9; i++)
        {
            if (checkIfThisPositionIsLegal(indexPozycji, i, -i, indexPozycji + i * 9, board))
            {
                if (checkIfThisIsFreePozition(indexPozycji + (i * 9), board))
                {
                    rightDown[i-1] = indexPozycji + (i * 9);
                }

                if (checkIfThereIsYourPiece(indexPozycji + (i* 9), board,indexPozycji))
                {
                    break;
                }

                if (checkIfThereIsEnemy(indexPozycji + (i*9), board, indexPozycji))
                {
                    if (checkIfThisPositionIsLegal(indexPozycji, i, -i, indexPozycji + ((i+1) * 9), board))
                    {
                        if (checkIfThisIsFreePozition(indexPozycji + ((i+1) * 9), board))
                        {

                        } else { break; }
                    } else { break; }
                }
            }
        }
        rightDown = orderRightArray(rightDown);



        for (int i =0 ; i < 8; i++)
        {
            if (leftUp[i] != -1)
            {
                possMove[i] = leftUp[i];
            }
        }
        for (int i =24 ; i < 32; i++)
        {
            if (rightDown[i-24] != -1)
            {
                possMove[i] = rightDown[i-24];
            }
        }
        return possMove;
    }


    private int [] orderLeftArray(int leftUp [] )
    {
        for (int i = 0; i < 7; i++)
        {
            if (leftUp[i] == -1 && leftUp[i+1] == -1) {}
            else if (leftUp[i] == -1 && leftUp[i+1] != -1)
            {
                if (i != 0)
                {
                    for (int  j = i; j >= 0; j--) { leftUp[j] = -1; }
                }break;
            }
        }return leftUp;
    }


    private int [] orderRightArray(int rightUp [] )
    {
        for (int i = 0; i < 7; i++)
        {
            if (rightUp[i] == -1 && rightUp[i+1] == -1) {}
            else if (rightUp[i] == -1 && rightUp[i+1] != -1)
            {
                if (i != 0)
                {
                    for (int  j = i; j >= 0; j--) { rightUp[j] = -1; }
                }break;
            }
        }return rightUp;
    }

    private boolean checkIfThereIsEnemy(int indexPozycji, Board board, int indexAktualnejPozycji)
    {
        if (board.plansza[indexPozycji].getPiece().getIndexFigury() != 20)
        {
            if (board.plansza[indexPozycji].getPiece().getColor() != board.plansza[indexAktualnejPozycji].getPiece().getColor())
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfThereIsYourPiece(int indexPozycji, Board board, int indexAktualnejPozycji)
    {
        if (board.plansza[indexPozycji].getPiece().getIndexFigury() != 20)
        {
            if (board.plansza[indexPozycji].getPiece().getColor() == board.plansza[indexAktualnejPozycji].getPiece().getColor())
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfThisIsFreePozition(int indexPozycji, Board board)
    {
        if (board.plansza[indexPozycji].getPiece().getIndexFigury() == 20)
        {
            return true;
        }
        return false;
    }


    /*
        -> zwraca true jeśli pozycja nie wyszła poza plansze
     */
    private boolean checkIfThisPositionIsLegal(int indexObecnejPozycji, int x, int y, int move, Board board) // x -> o ile przesuwamy w osi x, y -> o ile przesuwamy w osi y
    {
        if ( move < 0 ||  move > 63)
        {
            return false;
        }


        if (board.plansza[indexObecnejPozycji].getPosX() + x >= 0 && board.plansza[indexObecnejPozycji].getPosX() + x <= 7)
        {
            if (board.plansza[indexObecnejPozycji].getPosY() + y >= 1 && board.plansza[indexObecnejPozycji].getPosY() + y <= 8)
            {
                return true;
            }
        }
        return false;
    }
}

