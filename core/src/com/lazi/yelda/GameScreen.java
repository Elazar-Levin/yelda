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
import com.badlogic.gdx.graphics.g2d.Animation;


public class GameScreen extends AbstractScreen {
	
	private PlayerController controller;
	private Camera camera;
	private Actor player;
	private SpriteBatch batch;
	private Texture standingSouth;
	private TextureRegion grass;
	private TextureRegion water;
	private Animation wf1; 
	private Animation wf2; 
	private Animation wf3; 
	private Animation wf4; 
	private Animation wf5; 
	private Animation wf6; 
	private Animation wf7; 
	private Animation wf8; 
	private Animation wf9; 
	private Animation wf7_1; 
	private Animation wf8_1; 
	private Animation wf9_1; 
	private TileMap map;
	private Main appp;
	private float animationTimer=0f;
	private boolean goBehind=false;
	
	
	public GameScreen(Main app) {
		super(app);
		this.appp = app;
		ObjectArrays.initialise();
		
		//standingSouth = new Texture("res/player1_front.png");//TODO: update sprites
		
		
	
		TextureAtlas atlas1 = new TextureAtlas(Gdx.files.internal("res/Overworld.atlas"));//TODO: use the terrain handler class to take in a terrain, and optionally a delta, and return a texture region object. will neaten up code a lot
		water = atlas1.findRegion("basic_water");
		grass = atlas1.findRegion("basic_grass");//TODO: update sprites
		wf1=new Animation(0.3f,atlas1.findRegions("water_fountain_1"),PlayMode.LOOP);
		wf2=new Animation(0.3f,atlas1.findRegions("water_fountain_2"),PlayMode.LOOP);
		wf3=new Animation(0.3f,atlas1.findRegions("water_fountain_3"),PlayMode.LOOP);
		wf4=new Animation(0.3f,atlas1.findRegions("water_fountain_4"),PlayMode.LOOP);
		wf5=new Animation(0.3f,atlas1.findRegions("water_fountain_5"),PlayMode.LOOP);
		wf6=new Animation(0.3f,atlas1.findRegions("water_fountain_6"),PlayMode.LOOP);
		wf7=new Animation(0.3f,atlas1.findRegions("water_fountain_7"),PlayMode.LOOP);
		wf8=new Animation(0.3f,atlas1.findRegions("water_fountain_8"),PlayMode.LOOP);
		wf9=new Animation(0.3f,atlas1.findRegions("water_fountain_9"),PlayMode.LOOP);
		wf7_1=new Animation(0.3f,atlas1.findRegions("water_fountain_7_1"),PlayMode.LOOP);
		wf8_1=new Animation(0.3f,atlas1.findRegions("water_fountain_8_1"),PlayMode.LOOP);
		wf9_1=new Animation(0.3f,atlas1.findRegions("water_fountain_9_1"),PlayMode.LOOP);
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
			new Animation(0.3f/2f, tr, PlayMode.NORMAL),
			new Animation(0.3f,atlas.findRegions("player1_idle_north"),PlayMode.LOOP_PINGPONG),
			new Animation(0.3f,atlas.findRegions("player1_idle_south"),PlayMode.LOOP_PINGPONG),
			new Animation(0.3f,atlas.findRegions("player1_idle_east"),PlayMode.LOOP_PINGPONG),
			new Animation(0.3f,atlas.findRegions("player1_idle_west"),PlayMode.LOOP_PINGPONG)
		);
		
		map = new TileMap(500,500);
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
		animationTimer+=delta;
		controller.update(delta);
		player.update(delta);
		camera.update(player.getWorldX()+0.5f, player.getWorldY()+0.5f);
		
		batch.begin();
		
		float worldStarX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
		float worldStarY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;
		int myX=0;
		int myY=0;
		for(int x = 0; x < map.getWidth();x++) {
			for(int y = 0; y < map.getHeight(); y++) {
				TextureRegion render = null;
				Animation anim=null;
				//TODO: might have to keep track of all neccesary attributes fot this specific tile, and then just draw the character and tgen the tile when the tile should go in front				
				if(map.getTile(x, y).getTerrain() == TERRAIN.MAIN_GRASS) {//TODO:put in all values
					render = grass;
				}else if(map.getTile(x, y).getTerrain() == TERRAIN.MAIN_WATER) {
					render = water;
				}
				else if(ObjectArrays.animated.contains(map.getTile(x, y).getTerrain(),false))
				{
					map.getTile(x, y).setAnimated(true);
				}
				if(map.getTile(x, y).isAnimated())
				{
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_1)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						anim=wf1;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_2)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf2;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_3)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf3;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_4)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						anim=wf4;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_5)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf5;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_6)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf6;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_7)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						anim=wf7;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_8)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf8;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_9)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf9;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_7_1)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						anim=wf7_1;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_8_1)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf8_1;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					if(map.getTile(x, y).getTerrain()==TERRAIN.WATERFOUNTAIN_9_1)
					{
						batch.draw(grass,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
						
						anim=wf9_1;
						render=(TextureRegion)anim.getKeyFrame(animationTimer);
						
					}
					//do animated tilesets here
				}
				 
				
				batch.draw(render,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
				
			}
		}
		//if()
		//{
			
	//	}
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
