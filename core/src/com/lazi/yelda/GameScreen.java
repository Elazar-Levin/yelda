package com.lazi.yelda;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.Animation;



public class GameScreen extends AbstractScreen {
	
	private PlayerController controller;
	private Camera camera;
	private Actor player;
	private SpriteBatch batch;
	private Texture standingSouth;
	private TextureRegion grass;
	private TextureRegion water;
	private TileMap map;
	private Main appp;
	


	public GameScreen(Main app) {
		super(app);
		this.appp = app;
		
		
		//standingSouth = new Texture("res/player1_front.png");//TODO: update sprites
		
		
		TextureAtlas atlas1 = new TextureAtlas("res/Overworld.atlas");
		water = atlas1.findRegion("basic_water");
		grass = atlas1.findRegion("basic_grass");//TODO: update sprites
		
		batch = new SpriteBatch();
		
		TextureAtlas atlas = app.getAssetManager().get("res/character.atlas", TextureAtlas.class);
		Array<AtlasRegion> tr=atlas.findRegions("player1_fight_east");
		for(int i=0;i<4;i++)
		{
			tr.get(i).flip(true, false);
			
		}
		
		//TextureAtlas atlas= new TextureAtlas("res/character.atlas");
		AnimationSet animations = new AnimationSet(
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_north"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_south"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_east"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_west"), PlayMode.LOOP_PINGPONG),
			atlas.findRegion("player1_stand_north"),
			atlas.findRegion("player1_stand_south"),
			atlas.findRegion("player1_stand_east"),
			atlas.findRegion("player1_stand_west"),//TODO
			new Animation(0.3f/2f, atlas.findRegions("player1_fight_north"), PlayMode.NORMAL),
			new Animation(0.3f/2f, atlas.findRegions("player1_fight_south"), PlayMode.NORMAL),
			new Animation(0.3f/2f, atlas.findRegions("player1_fight_east"), PlayMode.NORMAL),
			new Animation(0.3f/2f, tr, PlayMode.NORMAL)
		);
		
		map = new TileMap(1000, 1000);
		player = new Actor(map, 20, 20, animations);
		camera = new Camera();
		controller = new PlayerController(player);
		
		//user = new Pokemon("charizard",100,20,30,6);
		//enemy = new Pokemon("ekans",100,15,2,1);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	public void newScreen() {
	//	int delay = 1000; // number of milliseconds to sleep

    //    long start = System.currentTimeMillis();
    //    while(start >= System.currentTimeMillis() - delay);
	//	appp.battle = true;
	//	battleScreen battleScreen = new battleScreen(appp, enemy, user);
	//	appp.setScreen(battleScreen);
        
	}

	@Override
	public void render(float delta) {


  

		//controller.update(delta);
//			if(controller.update(delta)) {

			//	newScreen();
			
		//}
		controller.update(delta);
		player.update(delta);
		camera.update(player.getWorldX()+0.5f, player.getWorldY()+0.5f);
		
		batch.begin();
		
		float worldStarX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
		float worldStarY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;
		for(int x = 0; x < map.getWidth();x++) {
			for(int y = 0; y < map.getHeight(); y++) {
				TextureRegion render = null;
				
				 
				if(map.getTile(x, y).getTerrain() == TERRAIN.MAIN_GRASS) {//TODO:put in all values
					render = grass;
				}else if(map.getTile(x, y).getTerrain() == TERRAIN.MAIN_WATER) {
					render = water;
				}
				else if(map.getTile(x, y).getTerrain() == TERRAIN.WATERFOUNTAIN_1)
				{
					map.getTile(x, y).setAnimated(true);
				}
				if(map.getTile(x, y).isAnimated())
				{
					//do animated tilesets here
				}
				else 
				{	
					batch.draw(render,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
				}
			}
		}
		
		batch.draw(player.getSprite(), 
				worldStarX+player.getWorldX()*Settings.SCALED_TILE_SIZE, 
				worldStarY+player.getWorldY()*Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE*1.5f);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
		
	}

}
