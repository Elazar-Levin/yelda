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

	private TileMap map;
	//private TileMap background;
	private Main appp;
	private float animationTimer=0f;
	private boolean goBehind=false;
	
	
	public GameScreen(Main app) {
		super(app);
		this.appp = app;
		ObjectArrays.initialise();
		TerrainHandler TerrainHandler= new TerrainHandler(app);
		//standingSouth = new Texture("res/player1_front.png");//TODO: update sprites
		
		
	
		
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
		
		map = new TileMap(500,500,ObjectArrays.map);
		//background = new TileMap(500,500,ObjectArrays.background);
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
		
		//for(int x = 0; x < map.getWidth();x++) {
		int hold1=0;
		if(player.getX()-11<=0)
		{
			hold1=0;
		}
		else
		{
			hold1=player.getX()-11;
		}
		for(int x = hold1; (x <= player.getX()+11)&&x<map.getWidth();x++) {
			int hold2=0;
			if(player.getY()-8<=0)
			{
				hold2=0;
			}
			else
			{
				hold2=player.getY()-8;
			} 
			//for(int y = 0; y < map.getHeight(); y++) {
			for(int y = hold2; y <=player.getY()+8 && y<map.getHeight(); y++) {
				TextureRegion render = null;
				
				if(ObjectArrays.needsGrass.contains(map.getTile(x, y).getTerrain(),false))//TODO: replace this with a layered map, so instead of always having grass behind certain tiles, we decide for each specifically
				{
					batch.draw(TerrainHandler.getTextureRegion(TERRAIN.MAIN_GRASS),worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
				}
				if(ObjectArrays.isAnimated(map.getTile(x, y).getTerrain()))
				{
					map.getTile(x, y).setAnimated(true);
				}
				if(map.getTile(x, y).isAnimated())//tile is animated
				{
					//do animated tilesets here
				
					
					render=TerrainHandler.getTextureRegion(map.getTile(x, y).getTerrain(), animationTimer);
					
					
				}
				else//tile isnt animated
				{
					
					render=TerrainHandler.getTextureRegion(map.getTile(x, y).getTerrain());
				}
				 
			//	batch.draw(TerrainHandler.getTextureRegion(background.getTile(x, y).getTerrain(), animationTimer),worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
				batch.draw(render,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
				
			}
		}
		Array<FancyTile> tileArray=new Array();//array holding the 9 squares around and including the character
		
		//add values to tileArray
		if(player.getX()!=0)
		{
			if(player.getY()!=0)
			{
				tileArray.add(new FancyTile(map,player.getX()-1,player.getY()-1));
			}
			tileArray.add(new FancyTile(map,player.getX()-1,player.getY()));
			if(player.getY()!=map.getHeight()-1)
			{
				tileArray.add(new FancyTile(map,player.getX()-1,player.getY()+1));
			}
		}
		if(player.getY()!=0)
		{
			tileArray.add(new FancyTile(map,player.getX(),player.getY()-1));
		}
		tileArray.add(new FancyTile(map,player.getX(),player.getY()));
		if(player.getY()!=map.getHeight()-1)
		{
			tileArray.add(new FancyTile(map,player.getX(),player.getY()+1));
		}
		if(player.getY()!=0)
		{
			tileArray.add(new FancyTile(map,player.getX()+1,player.getY()-1));
		}
		tileArray.add(new FancyTile(map,player.getX()+1,player.getY()));
		if(player.getY()!=map.getHeight()-1)
		{
			tileArray.add(new FancyTile(map,player.getX()+1,player.getY()+1));
		}
		
		
		batch.draw(player.getSprite(), 
				worldStarX+player.getWorldX()*Settings.SCALED_TILE_SIZE, 
				worldStarY+player.getWorldY()*Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE*1.5f);
		
		for(int i=0;i<tileArray.size;i++)
		{
			
			if(ObjectArrays.canGoBehind.contains(tileArray.get(i).getTile().getTerrain(),false))//if this tile must must be rendered in front of the player
			{
				if(tileArray.get(i).getTile().isAnimated())
				{
			
					batch.draw(TerrainHandler.getTextureRegion(tileArray.get(i).getTile().getTerrain(), animationTimer),
							worldStarX+tileArray.get(i).getX()*Settings.SCALED_TILE_SIZE,
							worldStarY+tileArray.get(i).getY()*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE,
							Settings.SCALED_TILE_SIZE);
					
				}
				else
				{
					batch.draw(TerrainHandler.getTextureRegion(tileArray.get(i).getTile().getTerrain()),
							worldStarX+tileArray.get(i).getX()*Settings.SCALED_TILE_SIZE,
							worldStarY+tileArray.get(i).getY()*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE,
							Settings.SCALED_TILE_SIZE);
				}
				
				
				
			}
		}
		
		
		
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
