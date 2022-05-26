package com.mygdx.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.mygdx.game.engine.GameState;
import com.mygdx.game.engine.GameStateManager;
import com.mygdx.game.gui.Button;

public class MenuState implements GameState {

    private Texture button1;
    private Texture button1H;
    private Texture button2;
    private Texture button2H;
    private Texture button3;
    private Texture button3H;
    private Texture button4;
    private Texture button4H;
    private Texture text1;
    private Texture text2;
    private Texture logo;
    private Texture bg;
    private Texture board;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    private SpriteBatch sb;
    private GameStateManager gsm;

    private Sprite spriteBG;
    private Sprite spriteText1;
    private Sprite spriteText2;
    private Sprite spriteBoard;
    private Sprite spriteLogo;
    //private Sprite

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void create() {
        this.gsm = gsm;
        text1 = new Texture(Gdx.files.internal("png/menu/text1.png"));
        text2 = new Texture(Gdx.files.internal("png/menu/text2.png"));
        button1 = new Texture(Gdx.files.internal("png/menu/button1.png"));
        button1H = new Texture(Gdx.files.internal("png/menu/button1_h.png"));
        button2 = new Texture(Gdx.files.internal("png/menu/button2.png"));
        button2H = new Texture(Gdx.files.internal("png/menu/button2_h.png"));
        button3 = new Texture(Gdx.files.internal("png/menu/button3.png"));
        button3H = new Texture(Gdx.files.internal("png/menu/button3_h.png"));
        button4 = new Texture(Gdx.files.internal("png/menu/button4.png"));
        button4H = new Texture(Gdx.files.internal("png/menu/button4_h.png"));
        board = new Texture(Gdx.files.internal("png/menu/board.png"));
        logo = new Texture(Gdx.files.internal("png/menu/logo.png"));
        bg = new Texture(Gdx.files.internal("png/menu/menuBG.png"));

        b1 = new Button(button1, button1H,75,225,175,50);
        b2 = new Button(button2, button2H,75,300,175,50);
        b3 = new Button(button3, button3H, 225,160,25,25);
        b4 = new Button(button4, button4H, 300, 160, 25,25);

        spriteBG = new Sprite(bg);
        spriteText1 = new Sprite(text2);
        spriteText1.setPosition(50,150);
        spriteText1.setSize(175,50);
        spriteText2 = new Sprite(text1);
        spriteText2.setPosition(50,375);
        spriteText2.setSize(175,50);
        spriteBoard = new Sprite(board);
        spriteBoard.setPosition(600,125);
        spriteBoard.setSize(400,400);
        spriteLogo = new Sprite(logo);
        spriteLogo.setPosition(600,550);
        spriteLogo.setSize(200,75);

        sb = new SpriteBatch();
    }

    @Override
    public void render() {
        sb.begin();
        spriteBG.draw(sb);
        spriteText1.draw(sb);
        spriteText2.draw(sb);
        spriteBoard.draw(sb);
        spriteLogo.draw(sb);
        b1.render(sb);
        b2.render(sb);
        b3.render(sb);
        b4.render(sb);
        sb.end();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void input() {
        int x = Gdx.input.getX();
        int y = Gdx.input.getY();

        b1.hover(x,y);
        b2.hover(x,y);
        b3.hover(x,y);
        b4.hover(x,y);
        if(b1.click(x,y)){
            gsm.push(new PlayState(gsm));
        }
    }

    @Override
    public void update(double deltaTime) {

    }
}
