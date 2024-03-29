package com.lazi.yelda;

import com.badlogic.gdx.Screen;


public abstract class AbstractScreen implements Screen {

	private Main app;
	
	public AbstractScreen(Main app) {
		this.app = app;
	}
	
	@Override
	public abstract void dispose();

	@Override
	public abstract void hide();

	@Override
	public abstract void pause();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int width, int height);

	@Override
	public abstract void resume();

	@Override
	public abstract void show();

}
