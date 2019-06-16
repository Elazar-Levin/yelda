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
		assetManager.load("res/character.atlas", TextureAtlas.class);
		assetManager.finishLoading();
	
		atlas = new TextureAtlas("res/Overworld.atlas");
		//sprite = atlas.createSprite("basic_grass");
		//sprite.setPosition(10, 10);
		screen = new GameScreen(this);
		this.setScreen(screen);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	//	batch.begin();
	//	batch.draw(img, 0, 0);
	//	batch.end();
		super.render();
		//makeGrass();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	private void makeGrass()
	{
		for(int i=0;i<Gdx.graphics.getWidth()/16;i++)
		{
			for(int j=0;j<Gdx.graphics.getHeight()/16;j++)
			{
				batch.begin();
				sprite.setPosition(i*16,j*16);
				sprite.draw(batch);
				batch.end();
			}
		}
	
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}
	
}
