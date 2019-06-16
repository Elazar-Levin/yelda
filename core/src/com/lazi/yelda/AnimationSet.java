package com.lazi.yelda;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public class AnimationSet {
	
	private Map<DIRECTION, Animation> walking;
	private Map<DIRECTION, TextureRegion> standing;
	private Map<DIRECTION, Animation> fighting;
	
	public AnimationSet(Animation walkNorth, 
			Animation walkSouth, 
			Animation walkEast, 
			Animation walkWest, 
			TextureRegion standNorth, 
			TextureRegion standSouth, 
			TextureRegion standEast, 
			TextureRegion standWest,
			Animation fightNorth,
			Animation fightSouth,
			Animation fightEast,
			Animation fightWest) {
		walking = new HashMap<DIRECTION, Animation>();
		walking.put(DIRECTION.NORTH,walkNorth);
		walking.put(DIRECTION.SOUTH,walkSouth);
		walking.put(DIRECTION.EAST,walkEast);
		walking.put(DIRECTION.WEST,walkWest);
		standing = new HashMap<DIRECTION, TextureRegion>();
		standing.put(DIRECTION.NORTH, standNorth);
		standing.put(DIRECTION.SOUTH, standSouth);
		standing.put(DIRECTION.EAST, standEast);
		standing.put(DIRECTION.WEST, standWest);
		fighting = new HashMap<DIRECTION,Animation>(); 
		fighting.put(DIRECTION.NORTH,fightNorth);
		fighting.put(DIRECTION.SOUTH,fightSouth);
		fighting.put(DIRECTION.EAST,fightEast);
		fighting.put(DIRECTION.WEST,fightWest);
	}
	
	public Animation getWalking(DIRECTION dir) {
		return walking.get(dir);
	}
	
	public TextureRegion getStanding(DIRECTION dir) {
		return standing.get(dir);
	}
	public Animation getFighting(DIRECTION dir) {
		return fighting.get(dir);
	}
}
