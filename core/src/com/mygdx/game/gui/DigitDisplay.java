package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class DigitDisplay {

    private Texture t1;
    private Texture t2;
    private Texture t3;
    private Texture t4;
    private Texture t5;
    private Texture t6;
    private Texture t7;
    private Texture t8;
    private Texture t9;

    private Sprite sprite;

    private int currentNum;

    public DigitDisplay(){
        t1 = new Texture(Gdx.files.internal("png/menu/digits/1.png"));
        t2 = new Texture(Gdx.files.internal("png/menu/digits/2.png"));
        t3 = new Texture(Gdx.files.internal("png/menu/digits/3.png"));
        t4 = new Texture(Gdx.files.internal("png/menu/digits/4.png"));
        t5 = new Texture(Gdx.files.internal("png/menu/digits/5.png"));
        t6 = new Texture(Gdx.files.internal("png/menu/digits/6.png"));
        t7 = new Texture(Gdx.files.internal("png/menu/digits/7.png"));
        t8 = new Texture(Gdx.files.internal("png/menu/digits/8.png"));
        t9 = new Texture(Gdx.files.internal("png/menu/digits/9.png"));

        sprite = new Sprite(t3);
    }

    public Sprite getSprite(){
        return sprite;
    }

    public void plusOne(){
        currentNum++;
        if(currentNum >9) currentNum = 1;
        setSprite(currentNum);
    }

    public void minusOne(){
        currentNum--;
        if(currentNum  <1)currentNum =9;
        setSprite(currentNum);

    }

    private void setSprite(int i){
        switch(i){
            case 1:
                sprite.setTexture(t1);
                break;
            case 2:
                sprite.setTexture(t2);
                break;
            case 3:
                sprite.setTexture(t3);
                break;
            case 4:
                sprite.setTexture(t4);
                break;
            case 5:
                sprite.setTexture(t5);
                break;
            case 6:
                sprite.setTexture(t6);
                break;
            case 7:
                sprite.setTexture(t7);
                break;
            case 8:
                sprite.setTexture(t8);
                break;
            case 9:
                sprite.setTexture(t9);
                break;
        }
    }
}
