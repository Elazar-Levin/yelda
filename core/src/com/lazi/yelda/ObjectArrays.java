package com.lazi.yelda;

import com.badlogic.gdx.utils.Array;



public class ObjectArrays {
	public static Array<TERRAIN> walls;
	public static Array<TERRAIN> animated;
	public static Array<TERRAIN> canGoBehind;
	public static int[][] map;
	
	public static void initialise()
	{
		walls=new Array<TERRAIN>();
		animated=new Array<TERRAIN>();
		canGoBehind =new Array<TERRAIN>();
		map=new int[500][500];
		addWalls();
		addAnimated();
		
	}
	private static void addWalls()
	{
		walls.add(TERRAIN.WATERFOUNTAIN_1);
		walls.add(TERRAIN.WATERFOUNTAIN_2);
		walls.add(TERRAIN.WATERFOUNTAIN_3);
		walls.add(TERRAIN.WATERFOUNTAIN_4);
		walls.add(TERRAIN.WATERFOUNTAIN_5);
		walls.add(TERRAIN.WATERFOUNTAIN_6);
	}
	private static void addAnimated()
	{
		animated.add(TERRAIN.WATERFOUNTAIN_1);
		animated.add(TERRAIN.WATERFOUNTAIN_2);
		animated.add(TERRAIN.WATERFOUNTAIN_3);
		animated.add(TERRAIN.WATERFOUNTAIN_4);
		animated.add(TERRAIN.WATERFOUNTAIN_5);
		animated.add(TERRAIN.WATERFOUNTAIN_6);
	}
	
	
	
}
