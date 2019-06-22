package com.lazi.yelda;

public class FancyTile {
	private Tile tile;
	private int x;
	private int y;
	
	public FancyTile(TileMap tileMap,int x,int y)
	{
		this.tile=tileMap.getTile(x, y);
		this.x=x;
		this.y=y;
	}
	public Tile getTile()
	{
		return tile;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}
