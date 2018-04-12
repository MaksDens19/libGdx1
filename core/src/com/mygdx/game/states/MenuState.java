package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyDemo;
import com.sun.media.jfxmedia.events.PlayerStateEvent;

public class MenuState extends State{
    private Texture background;
    private Texture playBtn;

    protected MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("android/assets/background.jpg");
        playBtn = new Texture("android/assets/playBtn.jpg");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gameStateManager.set(new PlayState(gameStateManager));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background,0,0, FlappyDemo.WIDTH, FlappyDemo.HEIGHT);
        spriteBatch.draw(playBtn,(FlappyDemo.WIDTH/2)-50,FlappyDemo.HEIGHT/2, 100, 100);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
