package warcaby;

public class Board {

    // Atrybuty
    public Cell[] plansza = new Cell[64];


    // Metody
    public void createNewBoard()
    {
        this.plansza[0] = new Cell("A8", cellColor.WHITE, 0, 8);
        this.plansza[1] = new Cell("B8", cellColor.BLACK, new Pawn(figuraColor.BLACK), 1, 8);
        this.plansza[2] = new Cell("C8", cellColor.WHITE,2,8);
        this.plansza[3] = new Cell("D8", cellColor.BLACK, new Pawn(figuraColor.BLACK),3,8);
        this.plansza[4] = new Cell("E8", cellColor.WHITE,4,8);
        this.plansza[5] = new Cell("F8", cellColor.BLACK, new Pawn(figuraColor.BLACK), 5,8);
        this.plansza[6] = new Cell("G8", cellColor.WHITE,6,8);
        this.plansza[7] = new Cell("H8", cellColor.BLACK, new Pawn(figuraColor.BLACK),7,8);

        this.plansza[8] = new Cell("A7", cellColor.BLACK, new Pawn(figuraColor.BLACK),0,7);
        this.plansza[9] = new Cell("B7", cellColor.WHITE,1,7);
        this.plansza[10] = new Cell("C7", cellColor.BLACK, new Pawn(figuraColor.BLACK),2,7);
        this.plansza[11] = new Cell("D7", cellColor.WHITE,3,7);
        this.plansza[12] = new Cell("E7", cellColor.BLACK, new Pawn(figuraColor.BLACK),4,7);
        this.plansza[13] = new Cell("F7", cellColor.WHITE,5,7);
        this.plansza[14] = new Cell("G7", cellColor.BLACK, new Pawn(figuraColor.BLACK),6,7);
        this.plansza[15] = new Cell("H7", cellColor.WHITE,7,7);

        this.plansza[16] = new Cell("A6", cellColor.WHITE,0,6);
        this.plansza[17] = new Cell("B6", cellColor.BLACK, new Pawn(figuraColor.BLACK),1,6);
        this.plansza[18] = new Cell("C6", cellColor.WHITE,2,6);
        this.plansza[19] = new Cell("D6", cellColor.BLACK, new Pawn(figuraColor.BLACK),3,6);
        this.plansza[20] = new Cell("E6", cellColor.WHITE,4,6);
        this.plansza[21] = new Cell("F6", cellColor.BLACK, new Pawn(figuraColor.BLACK),5,6);
        this.plansza[22] = new Cell("G6", cellColor.WHITE,6,6);
        this.plansza[23] = new Cell("H6", cellColor.BLACK, new Pawn(figuraColor.BLACK),7,6);

        this.plansza[24] = new Cell("A5", cellColor.BLACK,0,5);
        this.plansza[25] = new Cell("B5", cellColor.WHITE,1,5);
        this.plansza[26] = new Cell("C5", cellColor.BLACK,2,5);
        this.plansza[27] = new Cell("D5", cellColor.WHITE,3,5);
        this.plansza[28] = new Cell("E5", cellColor.BLACK,4,5);
        this.plansza[29] = new Cell("F5", cellColor.WHITE,5,5);
        this.plansza[30] = new Cell("G5", cellColor.BLACK,6,5);
        this.plansza[31] = new Cell("H5", cellColor.WHITE,7,5);

        this.plansza[32] = new Cell("A4", cellColor.WHITE,0,4);
        this.plansza[33] = new Cell("B4", cellColor.BLACK,1,4);
        this.plansza[34] = new Cell("C4", cellColor.WHITE,2,4);
        this.plansza[35] = new Cell("D4", cellColor.BLACK,3,4);
        this.plansza[36] = new Cell("E4", cellColor.WHITE,4,4);
        this.plansza[37] = new Cell("F4", cellColor.BLACK,5,4);
        this.plansza[38] = new Cell("G4", cellColor.WHITE,6,4);
        this.plansza[39] = new Cell("H4", cellColor.BLACK,7,4);

        this.plansza[40] = new Cell("A3", cellColor.BLACK, new Pawn(figuraColor.WHITE),0,3);
        this.plansza[41] = new Cell("B3", cellColor.WHITE,1,3);
        this.plansza[42] = new Cell("C3", cellColor.BLACK, new Pawn(figuraColor.WHITE),2,3);
        this.plansza[43] = new Cell("D3", cellColor.WHITE,3,3);
        this.plansza[44] = new Cell("E3", cellColor.BLACK, new Pawn(figuraColor.WHITE),4,3);
        this.plansza[45] = new Cell("F3", cellColor.WHITE,5,3);
        this.plansza[46] = new Cell("G3", cellColor.BLACK, new Pawn(figuraColor.WHITE),6,3);
        this.plansza[47] = new Cell("H3", cellColor.WHITE,7,3);

        this.plansza[48] = new Cell("A2", cellColor.WHITE,0,2);
        this.plansza[49] = new Cell("B2", cellColor.BLACK, new Pawn(figuraColor.WHITE),1,2);
        this.plansza[50] = new Cell("C2", cellColor.WHITE,2,2);
        this.plansza[51] = new Cell("D2", cellColor.BLACK, new Pawn(figuraColor.WHITE),3,2);
        this.plansza[52] = new Cell("E2", cellColor.WHITE,4,2);
        this.plansza[53] = new Cell("F2", cellColor.BLACK, new Pawn(figuraColor.WHITE),5,2);
        this.plansza[54] = new Cell("G2", cellColor.WHITE,6,2);
        this.plansza[55] = new Cell("H2", cellColor.BLACK, new Pawn(figuraColor.WHITE),7,2);

        this.plansza[56] = new Cell("A1", cellColor.BLACK, new Pawn(figuraColor.WHITE),0,1);
        this.plansza[57] = new Cell("B1", cellColor.WHITE,1,1);
        this.plansza[58] = new Cell("C1", cellColor.BLACK, new Pawn(figuraColor.WHITE),2,1);
        this.plansza[59] = new Cell("D1", cellColor.WHITE,3,1);
        this.plansza[60] = new Cell("E1", cellColor.BLACK, new Pawn(figuraColor.WHITE),4,1);
        this.plansza[61] = new Cell("F1", cellColor.WHITE,5,1);
        this.plansza[62] = new Cell("G1", cellColor.BLACK, new Pawn(figuraColor.WHITE),6,1);
        this.plansza[63] = new Cell("H1", cellColor.WHITE,7,1);

    }

}
