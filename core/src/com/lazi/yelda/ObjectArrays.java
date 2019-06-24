package com.lazi.yelda;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;
import java.util.HashMap;
import java.util.Map;
//  7
//10p10 number of squares around player, number of squares neccesary to render
//  7
public class ObjectArrays {
	private static Array<TERRAIN> walls;
	private static Array<TERRAIN> animated;
	public static Array<TERRAIN> canGoBehind;
	public static Array<TERRAIN> needsGrass;
	public static int[][] map;
	public static int[][] background;
	public static Map<Integer,TERRAIN> terrainMap;
	
	
	public static void initialise()
	{
		walls=new Array<TERRAIN>();
		animated=new Array<TERRAIN>();
		canGoBehind =new Array<TERRAIN>();
		needsGrass =new Array<TERRAIN>();
		map=new int[501][501];
		background=new int[501][501];
		terrainMap=new HashMap<Integer,TERRAIN>() ;
		addWalls();
		addAnimated();
		addCanGoBehind();
		addNeedsGrass();
		addTerrainMap();
		handleMap();
	}
	private static void addWalls()
	{
		walls.add(TERRAIN.MAIN_WATER);
		walls.add(TERRAIN.WATERFOUNTAIN_4);
		walls.add(TERRAIN.WATERFOUNTAIN_5);
		walls.add(TERRAIN.WATERFOUNTAIN_6);
		//walls.add(TERRAIN.WATERFOUNTAIN_7);//not sure if these should be in or not
		walls.add(TERRAIN.WATERFOUNTAIN_8);
	//	walls.add(TERRAIN.WATERFOUNTAIN_9);//not sure if these should be in or not
	//	walls.add(TERRAIN.WATERFOUNTAIN_7_1);//not sure if these should be in or not
		walls.add(TERRAIN.WATERFOUNTAIN_8_1);
	//	walls.add(TERRAIN.WATERFOUNTAIN_9_1);  //not sure if these should be in or not
		walls.add(TERRAIN.WAVE);
		walls.add(TERRAIN.BRIDGE_L_1);
		walls.add(TERRAIN.BRIDGE_L_2);
		walls.add(TERRAIN.BRIDGE_L_3);
		walls.add(TERRAIN.BRIDGE_L_4);
		walls.add(TERRAIN.BRIDGE_L_5);
		walls.add(TERRAIN.BRIDGE_L_6);
		walls.add(TERRAIN.BRIDGE_L_7);
		
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
		animated.add(TERRAIN.WAVE);
		
	}
	private static void addCanGoBehind()
	{
		canGoBehind.add(TERRAIN.WATERFOUNTAIN_1);
		canGoBehind.add(TERRAIN.WATERFOUNTAIN_2);
		canGoBehind.add(TERRAIN.WATERFOUNTAIN_3);
	}
	private static void addNeedsGrass()
	{
		needsGrass.add(TERRAIN.WATERFOUNTAIN_1);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_2);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_3);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_7);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_8);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_9);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_7_1);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_8_1);
		needsGrass.add(TERRAIN.WATERFOUNTAIN_9_1);
	}
	private static void addTerrainMap()
	{
		terrainMap.put(0,TERRAIN.MAIN_GRASS);
		terrainMap.put(283,TERRAIN.MAIN_WATER);
		terrainMap.put(382,TERRAIN.WATERFOUNTAIN_1);
		terrainMap.put(383,TERRAIN.WATERFOUNTAIN_2);
		terrainMap.put(384,TERRAIN.WATERFOUNTAIN_3);
		terrainMap.put(422,TERRAIN.WATERFOUNTAIN_4);
		terrainMap.put(423,TERRAIN.WATERFOUNTAIN_5);
		terrainMap.put(424,TERRAIN.WATERFOUNTAIN_6);
		terrainMap.put(462,TERRAIN.WATERFOUNTAIN_7);
		terrainMap.put(463,TERRAIN.WATERFOUNTAIN_8);
		terrainMap.put(464,TERRAIN.WATERFOUNTAIN_9);
		terrainMap.put(351,TERRAIN.WATERFOUNTAIN_7_1);
		terrainMap.put(352,TERRAIN.WATERFOUNTAIN_8_1);
		terrainMap.put(353,TERRAIN.WATERFOUNTAIN_9_1);
		terrainMap.put(243,TERRAIN.BANK_T);
		terrainMap.put(284,TERRAIN.BANK_R);
		terrainMap.put(282,TERRAIN.BANK_L);
		terrainMap.put(323,TERRAIN.BANK_B);
		terrainMap.put(242,TERRAIN.BANK_T_L);
		terrainMap.put(244,TERRAIN.BANK_T_R);
		terrainMap.put(322,TERRAIN.BANK_B_L);
		terrainMap.put(324,TERRAIN.BANK_B_R);
		terrainMap.put(40,TERRAIN.WAVE);
		terrainMap.put(1139,TERRAIN.BRIDGE_L_1);
		terrainMap.put(1179,TERRAIN.BRIDGE_L_2);
		terrainMap.put(1219,TERRAIN.BRIDGE_L_3);
		terrainMap.put(1259,TERRAIN.BRIDGE_L_4);
		terrainMap.put(1299,TERRAIN.BRIDGE_L_5);
		terrainMap.put(1339,TERRAIN.BRIDGE_L_6);
		terrainMap.put(1379,TERRAIN.BRIDGE_L_7);
		//TODO: GET RID OF TERRAINS
		
	}
	
	private static void handleMap()
	{
		FileHandle handle =Gdx.files.internal("res/mainlevel.csv");
		String text=handle.readString();
		//System.out.println(text);
		String[] lines=text.split("\n");
		
		
		Array<String[]> entries=new Array<String[]>();
		
		
		for(int i=0;i<lines.length;i++)
		{
			entries.add(lines[500-i].split(","));
		}
		
		for(int i=0;i<entries.size;i++)
		{
			for(int j=0;j<entries.get(i).length-1;j++)//not sure why, but using full length throws error
			{
				
				map[i][j]=Integer.parseInt(entries.get(i)[j]);
			}
		}
		
		handle =Gdx.files.internal("res/mainlevel1_background.csv");
		text=handle.readString();
		//System.out.println(text);
		lines=text.split("\n");
		
		
		entries=new Array<String[]>();
		
		
		for(int i=0;i<lines.length;i++)
		{
			entries.add(lines[500-i].split(","));
		}
		
		for(int i=0;i<entries.size;i++)
		{
			for(int j=0;j<entries.get(i).length-1;j++)//not sure why, but using full length throws error
			{
			
				background[i][j]=Integer.parseInt(entries.get(i)[j]);
			}
		}
		
		
	}
	public static boolean isAnimated(TERRAIN terrain)
	{
		return animated.contains(terrain, false);
	}
	public static boolean isWall(TERRAIN terrain, int level)//TODO: possibly add another terrain for the background, so we can check the background too
	{
		if(walls.contains(terrain, false))
		{
			return true;//TODO: hardcoded for now, later will check if is wall based on current level
		}
		else
		{
			return false;
		}
	}
	public static boolean isWall(TERRAIN terrain, int level,int x,int y)//TODO: possibly add another terrain for the background, so we can check the background too
	{
		if(walls.contains(terrain, false))
		{
			return true;//TODO: hardcoded for now, later will check if is wall based on current level
		}
		else
		{
			return false;
		}
	}
	//TODO: do canGoBehind method
}
