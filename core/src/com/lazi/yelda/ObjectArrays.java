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
	}
	
	
	
	
}
