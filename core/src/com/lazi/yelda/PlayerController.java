package com.lazi.yelda;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;



public class PlayerController extends InputAdapter{
	
	private Actor player;
	public boolean up, down, left, right, newScreen,attack;
	
	
	public PlayerController(Actor p) {
		this.player = p;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if(keycode == Keys.A) {
			newScreen = true;
			return true;
		}
		if(keycode == Keys.UP) {
			up = true;
		}
		if(keycode == Keys.DOWN) {
			down = true;
		}
		if(keycode == Keys.LEFT) {
			left = true;
		}
		if(keycode == Keys.RIGHT) {
			right = true;
		}
		if(keycode==Keys.SPACE) {
			attack=true;
		}
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.A) {
			newScreen = false;
			return true;
		}
		if(keycode == Keys.UP) {
			up = false;
		}
		if(keycode == Keys.DOWN) {
			down = false;
		}
		if(keycode == Keys.LEFT) {
			left = false;
		}
		if(keycode == Keys.RIGHT) {
			right = false;
		}
		if(keycode == Keys.SPACE) {
			attack = false;
		}
		return false;
	}
	
	public void update(float delta) 
	{
		if(!player.isAttacking())
		{
			if(up) {
				player.move(DIRECTION.NORTH);
			
			}
			
			if(down) {
				player.move(DIRECTION.SOUTH);
				
			}
			
			if(left) {
				player.move(DIRECTION.WEST);
			
			}
			
			if(right) {
				player.move(DIRECTION.EAST);
				
			}
			if(attack)
			{
				player.attack(player.getFacing());
			}
		}
	}
}
