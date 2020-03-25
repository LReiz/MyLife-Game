package com.lking.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lking.main.Game;
import com.lking.world.Camera;
import com.lking.world.World;

public class Figurant extends Entity {

	private int framesMovingCounter, framesMovingTime;
	private int dir;
	private boolean waiting;
	
	private int framesCounter = 0;
	private int animationFramesSpeed = 6;
	private int curAnimation = 0;
	protected int maxAnimation = 3;
	
	protected BufferedImage defaultImage;
	protected BufferedImage rightFigurant[];
	protected BufferedImage leftFigurant[];
	
	public Figurant(double x, double y, int width, int height, BufferedImage sprite, int age) {		// age: 1 -- BABY, 2 -- KID, 3 - ADOLESCENT
		super(x, y, width, height, sprite);
		
		if(age == 1)
			speed = 0.5;
		else
			speed = 1;
		
		defaultImage = sprite;
	}

	public void tick() {
		randomMove();
		
		if(dir != 0) {
			framesCounter++;
			if(framesCounter == animationFramesSpeed) {
				curAnimation++;
				framesCounter = 0;
				if(curAnimation >= maxAnimation) {
					curAnimation = 0;
				}
			}
		}
	}

	public void render(Graphics g) {
		if(dir == 1) {
			g.drawImage(rightFigurant[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
			defaultImage = rightFigurant[0];
		} else if(dir == 2) {
			g.drawImage(leftFigurant[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
			defaultImage = leftFigurant[0];
		} else {
			g.drawImage(defaultImage, (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);				
		}
	}
	
	private void randomMove() {
		if(!waiting) {
			dir = Game.rand.nextInt(3);				// 0 - stand; 1 - right; 2 - left
			framesMovingTime = Game.rand.nextInt(2*60);	// time to maintain direction		
			waiting = true;
		} else if(waiting) {
			if(dir == 0) {
			} else if(dir == 1) {
				x += speed;
			} else if(dir == 2) {
				x -= speed;
			}
			framesMovingCounter++;
			if(framesMovingCounter == framesMovingTime) {
				framesMovingCounter = 0;
				waiting = false;
			}
		}
		
		
		
	}
}
