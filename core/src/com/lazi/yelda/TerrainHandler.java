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
	public static TextureRegion getTextureRegion(TERRAIN terrain)
	{
		
		TextureAtlas atlas=app.getAssetManager().get("res/Overworld.atlas", TextureAtlas.class);
		
		
		switch(terrain)
		{
			case MAIN_GRASS:
				return atlas.findRegion("basic_grass");
			case MAIN_WATER:
				return atlas.findRegion("basic_water");
			case BANK_T:
				return atlas.findRegion("bank_t");
			case BANK_B:
				return atlas.findRegion("bank_b");
			case BANK_L:
				return atlas.findRegion("bank_l");
			case BANK_R:
				return atlas.findRegion("bank_r");
			case BANK_T_L:
				return atlas.findRegion("bank_t_l");
			case BANK_T_R:
				return atlas.findRegion("bank_t_r");
			case BANK_B_L:
				return atlas.findRegion("bank_b_l");
			case BANK_B_R:
				return atlas.findRegion("bank_b_r");
			case BRIDGE_L_1:
				return atlas.findRegion("bridge_l_1");
			case BRIDGE_L_2:
				return atlas.findRegion("bridge_l_2");
			case BRIDGE_L_3:
				return atlas.findRegion("bridge_l_3");
			case BRIDGE_L_4:
				return atlas.findRegion("bridge_l_4");
			case BRIDGE_L_5:
				return atlas.findRegion("bridge_l_5");
			case BRIDGE_L_6:
				return atlas.findRegion("bridge_l_6");
			case BRIDGE_L_7:
				return atlas.findRegion("bridge_l_7");
				
			default:
				return atlas.findRegion("basic_grass");
		}
		
	}
	public static TextureRegion getTextureRegion(TERRAIN terrain,float animationTimer)
	{
		TextureAtlas atlas=app.getAssetManager().get("res/Overworld.atlas", TextureAtlas.class);
		
		
		switch(terrain)
		{
			case WATERFOUNTAIN_1:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_2:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_2"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_3:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_3"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_4:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_4"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_5:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_5"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_6:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_6"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_7:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_7"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_8:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_8"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_9:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_9"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_7_1:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_7_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_8_1:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_8_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WATERFOUNTAIN_9_1:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_9_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
			case WAVE:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("wave"),PlayMode.LOOP).getKeyFrame(animationTimer);
			
			default:
				return (TextureRegion) new Animation(0.3f,atlas.findRegions("water_fountain_1"),PlayMode.LOOP).getKeyFrame(animationTimer);
		}
	}
		
}
