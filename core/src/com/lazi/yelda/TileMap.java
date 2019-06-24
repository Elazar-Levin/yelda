package com.lazi.yelda;


public class TileMap {
	private int width, height;
	private Tile[][] tiles;
	
	public TileMap(int width, int height,int[][]map) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height; y++) {
				
				tiles[x][y]=new Tile(ObjectArrays.terrainMap.get(map[y][x]));
				
				
			//	if(Math.random() > 0.5d) {
			//		tiles[x][y] = new Tile(TERRAIN.MAIN_GRASS);
			//	}
			//	else {
			//		tiles[x][y] = new Tile(TERRAIN.MAIN_GRASS);
			//	}
			}
		}
			/*
		tiles[30][30]=new Tile(TERRAIN.WATERFOUNTAIN_1);
		tiles[31][30]=new Tile(TERRAIN.WATERFOUNTAIN_2);
		tiles[32][30]=new Tile(TERRAIN.WATERFOUNTAIN_3);
		tiles[30][29]=new Tile(TERRAIN.WATERFOUNTAIN_4);
		tiles[31][29]=new Tile(TERRAIN.WATERFOUNTAIN_5);
		tiles[32][29]=new Tile(TERRAIN.WATERFOUNTAIN_6);
		tiles[30][28]=new Tile(TERRAIN.WATERFOUNTAIN_7_1);
		tiles[31][28]=new Tile(TERRAIN.WATERFOUNTAIN_8_1);
		tiles[32][28]=new Tile(TERRAIN.WATERFOUNTAIN_9_1);
		*/
	}
	
	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
