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
		addCanGoBehind();
	}
	private static void addWalls()
	{
		//walls.add(TERRAIN.WATERFOUNTAIN_1);
		//walls.add(TERRAIN.WATERFOUNTAIN_2);
		//walls.add(TERRAIN.WATERFOUNTAIN_3);
		walls.add(TERRAIN.WATERFOUNTAIN_4);
		walls.add(TERRAIN.WATERFOUNTAIN_5);
		walls.add(TERRAIN.WATERFOUNTAIN_6);
		walls.add(TERRAIN.WATERFOUNTAIN_7);
		walls.add(TERRAIN.WATERFOUNTAIN_8);
		walls.add(TERRAIN.WATERFOUNTAIN_9);
		walls.add(TERRAIN.WATERFOUNTAIN_7_1);
		walls.add(TERRAIN.WATERFOUNTAIN_8_1);
		walls.add(TERRAIN.WATERFOUNTAIN_9_1);
	}
	private static void addAnimated()
	{
		animated.add(TERRAIN.WATERFOUNTAIN_1);
		animated.add(TERRAIN.WATERFOUNTAIN_2);
		animated.add(TERRAIN.WATERFOUNTAIN_3);
		animated.add(TERRAIN.WATERFOUNTAIN_4);
		animated.add(TERRAIN.WATERFOUNTAIN_5);
		animated.add(TERRAIN.WATERFOUNTAIN_6);
		animated.add(TERRAIN.WATERFOUNTAIN_7);
		animated.add(TERRAIN.WATERFOUNTAIN_8);
		animated.add(TERRAIN.WATERFOUNTAIN_9);
		animated.add(TERRAIN.WATERFOUNTAIN_7_1);
		animated.add(TERRAIN.WATERFOUNTAIN_8_1);
		animated.add(TERRAIN.WATERFOUNTAIN_9_1);
	}
	private static void addCanGoBehind()
	{
		canGoBehind.add(TERRAIN.WATERFOUNTAIN_1);
		canGoBehind.add(TERRAIN.WATERFOUNTAIN_2);
		canGoBehind.add(TERRAIN.WATERFOUNTAIN_3);
	}
	
	
}
