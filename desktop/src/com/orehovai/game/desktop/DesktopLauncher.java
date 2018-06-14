package com.orehovai.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.orehovai.game.CasinoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = CasinoGame.WIDTH;
		config.height = CasinoGame.HEIGHT;
		config.title = CasinoGame.TITLE;
		new LwjglApplication(new CasinoGame(), config);
	}
}
