package com.orehovai.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.orehovai.game.CasinoGame;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("fon.jpg");
        playButton = new Texture("start_64.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, CasinoGame.WIDTH ,CasinoGame.HEIGHT);
        sb.draw(playButton, (CasinoGame.WIDTH / 2) - (playButton.getWidth() / 2), (CasinoGame.HEIGHT / 2) - (playButton.getHeight() / 2), CasinoGame.WIDTH ,CasinoGame.HEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
