package com.lazi.yelda;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import java.util.HashMap;
import java.util.Map;
//  7
//10p10 number of squares around player, number of squares neccesary to render
//  7
public class ObjectArrays {
	private static Array<Integer> walls;
	private static Array<Integer> animated;
	public static Array<Integer> canGoBehind;
	public static Array<Integer> needsGrass;
	public static int[][] map;
	public static int[][] background;
	public static Map<Integer,TextureRegion> Textures;
	
	
	public static void initialise()
	{
		walls=new Array<Integer>();
		animated=new Array<Integer>();
		canGoBehind =new Array<Integer>();
		needsGrass =new Array<Integer>();
		Textures=new HashMap<Integer,TextureRegion>();
		map=new int[501][501];
		background=new int[501][501];
		addWalls();
		addAnimated();
		addCanGoBehind();
		addNeedsGrass();
		addTextures();
		handleMap();
	}
	private static void addTextures()
	{
		
	}
	
	private static void addWalls()
	{
		walls.add(283);
		walls.add(422);
		walls.add(423);
		walls.add(424);
		//walls.add(462);//not sure if these should be in or not
		walls.add(463);
	//	walls.add(464);//not sure if these should be in or not
	//	walls.add(351);//not sure if these should be in or not
		walls.add(352);
	//	walls.add(353);  //not sure if these should be in or not
		walls.add(40);
		walls.add(1139);
		walls.add(1179);
		walls.add(1219);
		walls.add(1259);
		walls.add(1299);
		walls.add(1339);
		walls.add(1379);
		
	}
	private static void addAnimated()
	{
		animated.add(382);
		animated.add(383);
		animated.add(384);
		animated.add(422);
		animated.add(423);
		animated.add(424);
		animated.add(462);
		animated.add(463);
		animated.add(464);
		animated.add(351);
		animated.add(352);
		animated.add(353);
		animated.add(40);
		
	}
	private static void addCanGoBehind()
	{
		canGoBehind.add(382);
		canGoBehind.add(383);
		canGoBehind.add(384);
	}
	private static void addNeedsGrass()
	{
		needsGrass.add(382);
		needsGrass.add(383);
		needsGrass.add(384);
		needsGrass.add(462);
		needsGrass.add(463);
		needsGrass.add(464);
		needsGrass.add(351);
		needsGrass.add(352);
		needsGrass.add(353);
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
	public static boolean isAnimated(Integer terrain)
	{
		return animated.contains(terrain, false);
	}
	public static boolean isWall(Integer terrain, int level)//TODO: possibly add another terrain for the background, so we can check the background too
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
	public static boolean isWall(Integer terrain, int level,int x,int y)//TODO: possibly add another terrain for the background, so we can check the background too
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
