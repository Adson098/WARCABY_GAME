package com.mygdx.game.core.checkers;

import com.mygdx.game.piece.Pawn;

public class Board {

    // Atrybuty
    public Cell[] plansza = new Cell[64];


    // Metody
    public void createNewBoard()
    {
        this.plansza[0] = new Cell("A8", colorT.white, 0, 8);
        this.plansza[1] = new Cell("B8", colorT.black, new Pawn(colorT.black), 1, 8);
        this.plansza[2] = new Cell("C8", colorT.white,2,8);
        this.plansza[3] = new Cell("D8", colorT.black, new Pawn(colorT.black),3,8);
        this.plansza[4] = new Cell("E8", colorT.white,4,8);
        this.plansza[5] = new Cell("F8", colorT.black, new Pawn(colorT.black), 5,8);
        this.plansza[6] = new Cell("G8", colorT.white,6,8);
        this.plansza[7] = new Cell("H8", colorT.black, new Pawn(colorT.black),7,8);

        this.plansza[8] = new Cell("A7", colorT.black, new Pawn(colorT.black),0,7);
        this.plansza[9] = new Cell("B7", colorT.white,1,7);
        this.plansza[10] = new Cell("C7", colorT.black, new Pawn(colorT.black),2,7);
        this.plansza[11] = new Cell("D7", colorT.white,3,7);
        this.plansza[12] = new Cell("E7", colorT.black, new Pawn(colorT.black),4,7);
        this.plansza[13] = new Cell("F7", colorT.white,5,7);
        this.plansza[14] = new Cell("G7", colorT.black, new Pawn(colorT.black),6,7);
        this.plansza[15] = new Cell("H7", colorT.white,7,7);

        this.plansza[16] = new Cell("A6", colorT.white,0,6);
        this.plansza[17] = new Cell("B6", colorT.black, new Pawn(colorT.black),1,6);
        this.plansza[18] = new Cell("C6", colorT.white,2,6);
        this.plansza[19] = new Cell("D6", colorT.black, new Pawn(colorT.black),3,6);
        this.plansza[20] = new Cell("E6", colorT.white,4,6);
        this.plansza[21] = new Cell("F6", colorT.black, new Pawn(colorT.black),5,6);
        this.plansza[22] = new Cell("G6", colorT.white,6,6);
        this.plansza[23] = new Cell("H6", colorT.black, new Pawn(colorT.black),7,6);

        this.plansza[24] = new Cell("A5", colorT.black,0,5);
        this.plansza[25] = new Cell("B5", colorT.white,1,5);
        this.plansza[26] = new Cell("C5", colorT.black,2,5);
        this.plansza[27] = new Cell("D5", colorT.white,3,5);
        this.plansza[28] = new Cell("E5", colorT.black,4,5);
        this.plansza[29] = new Cell("F5", colorT.white,5,5);
        this.plansza[30] = new Cell("G5", colorT.black,6,5);
        this.plansza[31] = new Cell("H5", colorT.white,7,5);

        this.plansza[32] = new Cell("A4", colorT.white,0,4);
        this.plansza[33] = new Cell("B4", colorT.black,1,4);
        this.plansza[34] = new Cell("C4", colorT.white,2,4);
        this.plansza[35] = new Cell("D4", colorT.black,3,4);
        this.plansza[36] = new Cell("E4", colorT.white,4,4);
        this.plansza[37] = new Cell("F4", colorT.black,5,4);
        this.plansza[38] = new Cell("G4", colorT.white,6,4);
        this.plansza[39] = new Cell("H4", colorT.black,7,4);

        this.plansza[40] = new Cell("A3", colorT.black, new Pawn(colorT.white),0,3);
        this.plansza[41] = new Cell("B3", colorT.white,1,3);
        this.plansza[42] = new Cell("C3", colorT.black, new Pawn(colorT.white),2,3);
        this.plansza[43] = new Cell("D3", colorT.white,3,3);
        this.plansza[44] = new Cell("E3", colorT.black, new Pawn(colorT.white),4,3);
        this.plansza[45] = new Cell("F3", colorT.white,5,3);
        this.plansza[46] = new Cell("G3", colorT.black, new Pawn(colorT.white),6,3);
        this.plansza[47] = new Cell("H3", colorT.white,7,3);

        this.plansza[48] = new Cell("A2", colorT.white,0,2);
        this.plansza[49] = new Cell("B2", colorT.black, new Pawn(colorT.white),1,2);
        this.plansza[50] = new Cell("C2", colorT.white,2,2);
        this.plansza[51] = new Cell("D2", colorT.black, new Pawn(colorT.white),3,2);
        this.plansza[52] = new Cell("E2", colorT.white,4,2);
        this.plansza[53] = new Cell("F2", colorT.black, new Pawn(colorT.white),5,2);
        this.plansza[54] = new Cell("G2", colorT.white,6,2);
        this.plansza[55] = new Cell("H2", colorT.black, new Pawn(colorT.white),7,2);

        this.plansza[56] = new Cell("A1", colorT.black, new Pawn(colorT.white),0,1);
        this.plansza[57] = new Cell("B1", colorT.white,1,1);
        this.plansza[58] = new Cell("C1", colorT.black, new Pawn(colorT.white),2,1);
        this.plansza[59] = new Cell("D1", colorT.white,3,1);
        this.plansza[60] = new Cell("E1", colorT.black, new Pawn(colorT.white),4,1);
        this.plansza[61] = new Cell("F1", colorT.white,5,1);
        this.plansza[62] = new Cell("G1", colorT.black, new Pawn(colorT.white),6,1);
        this.plansza[63] = new Cell("H1", colorT.white,7,1);

    }

}
