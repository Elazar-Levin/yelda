package com.lazi.yelda;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.Game;

public class Main extends Game {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	TextureAtlas atlas;
	AssetManager assetManager;
	GameScreen screen;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		assetManager = new AssetManager();
		assetManager.load(("res/character.atlas"), TextureAtlas.class);
		assetManager.finishLoading();
		assetManager.load(("res/Overworld.atlas"), TextureAtlas.class);
		assetManager.finishLoading();
	
		atlas = new TextureAtlas("res/Overworld.atlas");
		screen = new GameScreen(this);
		this.setScreen(screen);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}
	
}
