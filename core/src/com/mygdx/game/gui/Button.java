package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.mygdx.game.CONFIG;
import com.mygdx.game.core.mouseStateT;

public class Button {

    private Texture texture;
    private Texture textureH;
    private Sprite sprite;
    public int x,y,w,h;
    public Button(Texture txt, Texture txtHover, int ix, int iy, int iw, int ih){
        x = ix;
        y = iy;
        w = iw;
        h = ih;
        texture =  txt;
        textureH = txtHover;
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setSize(w,h);
    }
    public void render(SpriteBatch sb){
        sprite.draw(sb);
    }

    public boolean hover(int lx, int ly){
         ly = CONFIG.TRANSLATE_Y_TO_LUC(ly);
       if(lx >= x && lx <= x+w && ly >= y && ly <= y+h  ){
           sprite.setTexture(textureH);
           return true;
       }
       else{
           sprite.setTexture(texture);
           return false;
       }
    }

    public boolean click(int lx, int ly) {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {

            ly = CONFIG.TRANSLATE_Y_TO_LUC(ly);
            if (lx >= x && lx <= x + w && ly >= y && ly <= y + h) {
                sprite.setTexture(textureH);
                return true;
            } else {
                sprite.setTexture(texture);
                return false;
            }
        }
        else return false;
    }

}
