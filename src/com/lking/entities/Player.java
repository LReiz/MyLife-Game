package com.lking.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lking.main.Game;
import com.lking.world.Camera;
import com.lking.world.World;

public class Player extends Entity {
	
	private int framesCounter = 0;
	private int animationFramesSpeed = 6;
	private int curAnimation = 0;
	private int maxAnimation = 3;
	
	public boolean moving;
	
	private BufferedImage[] rightBaby;
	private BufferedImage[] leftBaby;
	
	private BufferedImage[] rightKid;
	private BufferedImage[] leftKid;
	
	private BufferedImage[] rightAdolescent;
	private BufferedImage[] leftAdolescent;
	
	private BufferedImage defaultImage;
	public boolean setDefaultImage = true;
	
	private static String playerState = "BABY";
	
	public Player(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		defaultImage = sprite;
		speed = 0.5;

		rightBaby = new BufferedImage[maxAnimation];
		leftBaby = new BufferedImage[maxAnimation];
		
		rightKid = new BufferedImage[maxAnimation];
		leftKid = new BufferedImage[maxAnimation];
		
		rightAdolescent = new BufferedImage[maxAnimation];
		leftAdolescent = new BufferedImage[maxAnimation];
		
		for(int i = 0; i < maxAnimation; i++) {
			rightBaby[i] = Game.spritesheet.getSprite(i*World.TS, 0*World.TS, World.TS, World.TS);
		}
		for(int i = 0; i < maxAnimation; i++) {
			leftBaby[i] = Game.spritesheetinv.getSprite(i*World.TS, 0*World.TS, World.TS, World.TS);
		}
		
		for(int i = 0; i < maxAnimation; i++) {
			rightKid[i] = Game.spritesheet.getSprite(i*World.TS, 1*World.TS, World.TS, World.TS);
		}
		for(int i = 0; i < maxAnimation; i++) {
			leftKid[i] = Game.spritesheetinv.getSprite(i*World.TS, 1*World.TS, World.TS, World.TS);
		}
		
		for(int i = 0; i < maxAnimation; i++) {
			rightAdolescent[i] = Game.spritesheet.getSprite(i*World.TS, 2*World.TS, World.TS, World.TS);
		}
		for(int i = 0; i < maxAnimation; i++) {
			leftAdolescent[i] = Game.spritesheetinv.getSprite(i*World.TS, 2*World.TS, World.TS, World.TS);
		}
	
		depth = -1;
	}
	
	public void tick() {
		
		if(Game.curCity == 1) {
			playerState = "BABY";
			if(setDefaultImage) {
				defaultImage = Entity.PLAYER_BABY;
				setDefaultImage = false;
			}
			speed = 0.5;
		} else if(Game.curCity == 2) {
			playerState = "KID";	
			if(setDefaultImage) {
				defaultImage = Entity.PLAYER_KID;
				setDefaultImage = false;
			}
			speed = 1;
		}else if(Game.curCity == 3 || Game.curCity == 4) {
			playerState = "ADOLESCENT";	
			if(setDefaultImage) {
				defaultImage = Entity.PLAYER_ADOLESCENT;
				setDefaultImage = false;
			}
			speed = 1;
		}
		
		if(right) {
			x += speed;
		}
		if(left) {
			x -= speed;
		}
		
		if(moving) {
			framesCounter++;
			if(framesCounter == animationFramesSpeed) {
				curAnimation++;
				framesCounter = 0;
				if(curAnimation >= maxAnimation) {
					curAnimation = 0;
				}
			}
		}
		
		// Cutscene 1
		if(Game.curCity == 4 && x >= 9*World.TS && !Game.cutScene1) {
			Game.gameState = "CUTSCENE1";
			Game.cutScene1 = true;
		}
		
		Camera.x = Camera.clamp((int) this.getX() - (Game.WIDTH/2), 0, (World.WIDTH*16) - Game.WIDTH);			
		Camera.y = Camera.clamp((int) this.getY() - (Game.HEIGHT/2), 0, (World.HEIGHT*16) - Game.HEIGHT);	
	}

	public void render(Graphics g) {
		if(playerState == "BABY") {
			if(right) {
				g.drawImage(rightBaby[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
				defaultImage = rightBaby[0];
			} else if(left) {
				g.drawImage(leftBaby[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
				defaultImage = leftBaby[0];
			} else {
				g.drawImage(defaultImage, (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);				
			}
		} else if(playerState == "KID") {
			if(right) {
				g.drawImage(rightKid[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
				defaultImage = rightKid[0];
			} else if(left) {
				g.drawImage(leftKid[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
				defaultImage = leftKid[0];
			} else {
				g.drawImage(defaultImage, (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);								
			}
		} else if(playerState == "ADOLESCENT") {
			if(right) {
				g.drawImage(rightAdolescent[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
				defaultImage = rightAdolescent[0];
			} else if(left) {
				g.drawImage(leftAdolescent[curAnimation], (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);
				defaultImage = leftAdolescent[0];
			} else {
				g.drawImage(defaultImage, (int) this.getX() - Camera.x, (int) this.getY() - Camera.y, World.TS, World.TS, null);								
			}
		}
	}
}
