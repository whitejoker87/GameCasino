package com.orehovai.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bird {

    private static final int MOVEMENT = 100;
    private static final int GRAVITY = -15;
    private Vector2 position;
    private Vector2 velosity;
    private Rectangle bounds;

    private Texture bird;

    public Bird(int x, int y) {
        position = new Vector2(x, y);
        velosity = new Vector2(0 , 0);
        bird = new Texture("bird.png");
        bounds = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public void update(float dt) {

        if (position.y > 0)
            velosity.add(0, GRAVITY);
        velosity.scl(dt);
        position.add(MOVEMENT * dt, velosity.y);
        if (position.y < 0)
            position.y = 0;

        velosity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);

    }

    public void jump() {
        velosity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
