package com.lazi.yelda;


public class Tile {
	private int terrain;
	private Actor actor;
	private boolean animated;
	
	public Tile(int terrain) {
		this.terrain = terrain;
		animated=false;
	}
	
	public int getTerrain() {
		return terrain;
	}
	
	public Actor getActor() {
		return actor;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public boolean isAnimated()
	{
		return animated;
	}
	public void setAnimated(boolean b)
	{
		animated=b;
	}
	
}
