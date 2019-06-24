package com.lazi.yelda;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class TerrainHandler {
	private static Main app; 
	
	public TerrainHandler(Main app)
	{
		TerrainHandler.app=app;
	}
	public static TextureRegion getTextureRegion(int terrain)
	{
		
		TextureAtlas atlas=app.getAssetManager().get("res/Overworld.atlas", TextureAtlas.class);
		
		
		switch(terrain)
		{
			case 0:
				return atlas.findRegion("basic_grass");
			case 283:
				return atlas.findRegion("basic_water");
			case 243:
				return atlas.findRegion("bank_t");
			case 323:
				return atlas.findRegion("bank_b");
			case 282:
				return atlas.findRegion("bank_l");
			case 284:
				return atlas.findRegion("bank_r");
			case 242:
				return atlas.findRegion("bank_t_l");
			case 244:
				return atlas.findRegion("bank_t_r");
			case 322:
				return atlas.findRegion("bank_b_l");
			case 324:
				return atlas.findRegion("bank_b_r");
			case 1139:
				return atlas.findRegion("bridge_l_1");
			case 1179:
				return atlas.findRegion("bridge_l_2");
			case 1219:
				return atlas.findRegion("bridge_l_3");
			case 1259:
				return atlas.findRegion("bridge_l_4");
			case 1299:
				return atlas.findRegion("bridge_l_5");
			case 1319:
				return atlas.findRegion("bridge_l_6");
			case 1359:
				return atlas.findRegion("bridge_l_7");
			case 1140:
				return atlas.findRegion("bridge_l_1_1");
			case 1180:
				return atlas.findRegion("bridge_l_1_2");
			case 1220:
				return atlas.findRegion("bridge_l_1_3");
			case 1260:
				return atlas.findRegion("bridge_l_1_4");
			case 1300:
				return atlas.findRegion("bridge_l_1_5");
			case 1320:
				return atlas.findRegion("bridge_l_1_6");
			case 1360:
				return atlas.findRegion("bridge_l_1_7");
			default:
				return atlas.findRegion("basic_grass");
		}
		
	}
	public static TextureRegion getTextureRegion(int terrain,float animationTimer)
	{
		TextureAtlas atlas=app.getAssetManager().get("res/Overworld.atlas", TextureAtlas.class);
		
		
		switch(terrain)//TODO: only use atlas for animations
		{
			case 382:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 383:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_2"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 384:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_3"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 422:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_4"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 423:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_5"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 424:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_6"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 462:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_7"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 463:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_8"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 464:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_9"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 351:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_7_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 352:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_8_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 353:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_9_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case 40:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("wave"),PlayMode.LOOP).getKeyFrame(animationTimer);
			
			default:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
		}
	}
		
}
