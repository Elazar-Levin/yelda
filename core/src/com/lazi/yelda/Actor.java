package com.lazi.yelda;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;


public class Actor {
	
	private TileMap map;
	private int x;
	private int y;
	private DIRECTION facing;
	
	private float worldX, worldY;
	private int srcX, srcY;
	private int destX, destY;
	private float animTimer;
	private float ANIM_TIME = 0.25f;
	
	private float walkTimer;
	private float fightTimer;
	private boolean moveRequestThisFrame;
	private int attackingStage=4;
	private ACTOR_STATE state;
	
	private AnimationSet animations;
	
	private double lives;
	private double damage;
	public Actor(TileMap map, int x, int y, AnimationSet animations) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.worldX = x;
		this.worldY = y;
		this.animations = animations;
		map.getTile(x, y).setActor(this);
		this.state = ACTOR_STATE.STANDING;
		this.facing = DIRECTION.SOUTH;
	}
	public Actor(TileMap map, int x, int y, AnimationSet animations,double lives,double damage) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.worldX = x;
		this.worldY = y;
		this.animations = animations;
		map.getTile(x, y).setActor(this);
		this.state = ACTOR_STATE.STANDING;
		this.facing = DIRECTION.SOUTH;
		this.lives=lives;
		this.damage=damage;
	}
	
	public enum ACTOR_STATE {
		WALKING,
		STANDING,
		FIGHTING,
		IDLE
		;
	}
	
	public void update(float delta) {
		if(attackingStage>=4)
		{
			if(state == ACTOR_STATE.WALKING) {
				animTimer += delta;
				walkTimer += delta;
				worldX = Interpolation.linear.apply(srcX, destX, animTimer/ANIM_TIME);
				worldY = Interpolation.linear.apply(srcY, destY, animTimer/ANIM_TIME);
				if(animTimer > ANIM_TIME) {
					float leftOverTime = animTimer-ANIM_TIME;
					walkTimer -= leftOverTime;
					finishMove();
					if(moveRequestThisFrame) {
						if (move(facing)) {//TODO: make it so that the red background doesn't show, when he reaches a certain point, his actual coords change.
							animTimer += leftOverTime;
							worldX = Interpolation.linear.apply(srcX, destX, animTimer / ANIM_TIME);
							worldY = Interpolation.linear.apply(srcY, destY, animTimer / ANIM_TIME);
						}
					}else {
						walkTimer = 0f;
					}
				}
			}
		}
		else
		{
			fightTimer+=delta;
			state=ACTOR_STATE.FIGHTING;
		}
		moveRequestThisFrame = false;
	}

	public boolean move(DIRECTION dir) {
		if(state == ACTOR_STATE.WALKING) {
			if(facing == dir) {
				moveRequestThisFrame = true;
			}
			return false;
		}
		if(x+dir.getDx() >= map.getWidth() || x+dir.getDx() < 0 || y+dir.getDy() >= map.getHeight() || y+dir.getDy() < 0) {
			return false;	
		}
		if(map.getTile(x+dir.getDx(), y+dir.getDy()).getActor() != null) {
			return false;
		}
		if(ObjectArrays.walls.contains(map.getTile(x+dir.getDx(), y+dir.getDy()).getTerrain(), false))
		{
			return false;
		}
	//	if(y-((Gdx.graphics.getHeight()/2)+16)>=0)
	//	{
	//		return false;
	//	}
		//TODO: make clause for colissions eg water, walls etc
		initializeMove(dir);
		map.getTile(x, y).setActor(null);
		x += dir.getDx();
		y += dir.getDy();
		map.getTile(x, y).setActor(this);
		return true;
	}
	
	private void initializeMove(DIRECTION dir) {
		this.facing = dir;
		this.srcX = x;
		this.srcY = y;
		this.destX = x+dir.getDx();
		this.destY = y+dir.getDy();
		this.worldX = x;
		this.worldY = y;
		animTimer = 0f;
		state = ACTOR_STATE.WALKING;
	}
	
	public float getWorldX() {
		return worldX;
	}

	public float getWorldY() {
		return worldY;
	}
	
	public TextureRegion getSprite() {
		if(state == ACTOR_STATE.WALKING) {
			return (TextureRegion) animations.getWalking(facing).getKeyFrame(walkTimer);
		}
		else if(state == ACTOR_STATE.STANDING) {
			return animations.getStanding(facing);
		}
		else if(state==ACTOR_STATE.FIGHTING)
		{
			//increment attackingStage here
			if(attackingStage==3)
			{
				attackingStage=4;
				float hold=fightTimer;
				fightTimer=0;
				state=ACTOR_STATE.STANDING;
				return (TextureRegion)animations.getFighting(facing).getKeyFrame(hold);
			}
			else
			{
				attackingStage=animations.getFighting(facing).getKeyFrameIndex(fightTimer);
			}
			return (TextureRegion)animations.getFighting(facing).getKeyFrame(fightTimer);
		}
		return animations.getStanding(DIRECTION.SOUTH);
	}
	
	private void finishMove() 
	{
		state = ACTOR_STATE.STANDING;
		this.worldX = destX;
		this.worldY = destY;
		this.srcX = 0;
		this.srcY = 0;
		this.destX = 0;
		this.destY = 0;
	}
	public void attack()
	{
		//TODO: do attack method
		state=ACTOR_STATE.FIGHTING;
		attackingStage=0;
		//TODO:make sure character only tries to attack valid tiles, ie no red background.also, (0,0) throws an errror for some reason 
		//attacking mehod for now. migt make enemies an insance of the actor class, in which case this will be very different
		if(facing==DIRECTION.NORTH)
		{
			if(y != map.getHeight()-1 && map.getTile(x, y+1).getActor()!=null )
			{
				map.getTile(x, y+1).getActor().hit(map.getTile(x, y+1).getActor().getDamage());
			}
		}
		if(facing==DIRECTION.SOUTH)
		{
			if(y!=0 && map.getTile(x, y-1).getActor()!=null )
			{
				map.getTile(x, y-1).getActor().hit(map.getTile(x, y-1).getActor().getDamage());
			}
		}
		if(facing==DIRECTION.EAST)
		{
			if(x != map.getWidth()-1 && map.getTile(x+1, y).getActor()!=null )
			{
				map.getTile(x+1, y).getActor().hit(map.getTile(x+1, y).getActor().getDamage());
			}
		}
		if(facing==DIRECTION.WEST)
		{
			if(x != 0 && map.getTile(x-1, y).getActor()!=null )
			{
				map.getTile(x-1, y).getActor().hit(map.getTile(x-1, y).getActor().getDamage());
			}
		}
		
	}
	public void hit(double damage)
	{
		lives-=damage;
		//maybe do animation or flashing or something
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public DIRECTION getFacing()
	{
		return facing;
	}
	public boolean isAttacking()
	{
		return state==ACTOR_STATE.FIGHTING;
	}
	public double getDamage()
	{
		return damage;
	}
}
