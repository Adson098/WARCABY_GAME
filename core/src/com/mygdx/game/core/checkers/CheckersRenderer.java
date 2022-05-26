package com.mygdx.game.core.checkers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.CONFIG;

public class CheckersRenderer extends Checkers{

    private Texture blackPawn;
    private Texture whitePawn;
    private Sprite whitePawnSprite;
    private Sprite blackPawnSprite;

    private Texture whiteCell;
    private Texture blackCell;
    private Sprite blackCellSprite;
    private Sprite whiteCellSprite;
    private Sprite[] boardSprite;
    private SpriteBatch sb;

    public CheckersRenderer(){
        blackCell = new Texture(Gdx.files.internal("png/blackFiled.png"));
        whiteCell = new Texture(Gdx.files.internal("png/whiteFiled.png"));

        blackPawn = new Texture(Gdx.files.internal("png/Pawn2.png"));
        whitePawn = new Texture(Gdx.files.internal("png/Pawn1.png"));
        blackCellSprite = new Sprite(blackCell);
        whiteCellSprite = new Sprite(whiteCell);

        whitePawnSprite = new Sprite(whitePawn);
        blackPawnSprite = new Sprite(blackPawn);
        boardSprite = new Sprite[64];
        sb = new SpriteBatch();

        setupBoard();
    }
    public void render(){
        sb.begin();
        for(int i= 0; i<64;i++){
            boardSprite[i].draw(sb);
        }
        sb.end();
    }

    public void setupBoard(){
        for(int i = 0, x=0, c=0;i<8;i++){
            x+=1;
            for(int j = 0;j <8; j++,x++){

                if(x%2==0) {
                    boardSprite[c] = new Sprite(whiteCellSprite);
                    boardSprite[c].setSize(CONFIG.CELL_WIDTH, CONFIG.CELL_HEIGHT);
                    boardSprite[c].setPosition((j*CONFIG.CELL_WIDTH)+CONFIG.CHESS_BOARD_X,(i*CONFIG.CELL_HEIGHT)+CONFIG.CHESS_BOARD_Y);
                }
                else {
                    boardSprite[c] = new Sprite(blackCellSprite);
                    boardSprite[c].setSize(CONFIG.CELL_WIDTH, CONFIG.CELL_HEIGHT);
                    boardSprite[c].setPosition((j*CONFIG.CELL_WIDTH)+CONFIG.CHESS_BOARD_X,(i*CONFIG.CELL_HEIGHT)+CONFIG.CHESS_BOARD_Y);
                }
                c++;
            }
        }
    }

}
