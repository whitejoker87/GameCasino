package com.orehovai.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.orehovai.game.CasinoGame;
import com.orehovai.game.sprites.Bird;
import com.orehovai.game.sprites.Tube;



public class PlayState extends State {

    public static final int TUBE_SPASING = 300;
    public static final int TUBE_COUNT = 4;

    private Bird bird;
    private Texture bg;

    private Array<Tube> tubes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 300);
        bg = new Texture("fon.jpg");
        camera.setToOrtho(false, CasinoGame.WIDTH / 2, CasinoGame.HEIGHT / 2);

        tubes = new Array<Tube>();

        for (int i = 0; i < TUBE_COUNT; i++) {
            tubes.add(new Tube(i * TUBE_SPASING + Tube.TUBE_WIDTH));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        camera.position.x = bird.getPosition().x + 80;

        for (Tube tube : tubes) {
            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x +
                    tube.getTopTube().getWidth()) {
                        tube.reposition(tube.getPosTopTube().x +
                        ((Tube.TUBE_WIDTH + TUBE_SPASING) * TUBE_COUNT));
                    }

            //if (tube.collides(bird.getBounds())) gsm.set(new PlayState(gsm));

        }

        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(bird.getBird(),bird.getPosition().x, bird.getPosition().y, bird.getBird().getWidth() - 100, bird.getBird().getHeight() - 100);
        for (Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y, tube.getTopTube().getWidth() - 200,tube.getTopTube().getHeight());
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y, tube.getBottomTube().getWidth() - 200, tube.getBottomTube().getHeight());
        }
        sb.end();

    }

    @Override
    public void dispose() {
        //bird.dispose();
    }
}
