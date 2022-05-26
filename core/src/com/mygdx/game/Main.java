package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.core.MenuState;
import com.mygdx.game.core.PlayState;
import com.mygdx.game.engine.ChessEngine;
import com.mygdx.game.engine.GameStateManager;

public class Main extends ApplicationAdapter {
	GameStateManager gsm;
	ChessEngine gm;

	@Override
	public void create () {
		gsm = new GameStateManager();
		gm = new ChessEngine();
		gsm.push(new MenuState(gsm));

		try {
			gm.init(gsm);

		}
		finally {
			System.out.println("finally");
		}
	}

	@Override
	public void render () {
		gm.loop();
	}

	public void dispose(){
		System.out.println("dispose");
		gm.dispose();
	}
}