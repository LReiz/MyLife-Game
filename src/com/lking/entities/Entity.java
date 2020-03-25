package com.lking.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lking.main.Game;
import com.lking.world.Camera;
import com.lking.world.World;

public class Entity {

	public int depth;
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected BufferedImage sprite;
	
	protected double speed;
	
	public boolean left, right;
	
	// Backgrounds
	public static BufferedImage CN0 = Game.spritesheetbg.getSprite(0, 0, World.TS, World.TS);
	
	// Characters
	public static BufferedImage PLAYER_BABY = Game.spritesheet.getSprite(0, 0, World.TS, World.TS);
	public static BufferedImage PLAYER_KID = Game.spritesheet.getSprite(0, 1*World.TS, World.TS, World.TS);
	public static BufferedImage PLAYER_ADOLESCENT = Game.spritesheet.getSprite(0, 2*World.TS, World.TS, World.TS);
	
	public static BufferedImage BLONDGUY_BABY = Game.spritesheet.getSprite(3*World.TS, 0, World.TS, World.TS);
	public static BufferedImage BLONDGUY_KID = Game.spritesheet.getSprite(3*World.TS, 1*World.TS, World.TS, World.TS);
	public static BufferedImage BLONDGUY_ADOLESCENT = Game.spritesheet.getSprite(3*World.TS, 2*World.TS, World.TS, World.TS);

	public static BufferedImage WHITEGUY_BABY = Game.spritesheet.getSprite(3*World.TS, 3*World.TS, World.TS, World.TS);
	public static BufferedImage WHITEGUY_KID = Game.spritesheet.getSprite(3*World.TS, 4*World.TS, World.TS, World.TS);
	public static BufferedImage WHITEGUY_ADOLESCENT = Game.spritesheet.getSprite(3*World.TS, 5*World.TS, World.TS, World.TS);
	
	public static BufferedImage BLACKGIRL_BABY = Game.spritesheet.getSprite(6*World.TS, 0, World.TS, World.TS);
	public static BufferedImage BLACKGIRL_KID = Game.spritesheet.getSprite(6*World.TS, 1*World.TS, World.TS, World.TS);
	public static BufferedImage BLACKGIRL_ADOLESCENT = Game.spritesheet.getSprite(6*World.TS, 2*World.TS, World.TS, World.TS);

	public static BufferedImage WHITEGIRL_BABY = Game.spritesheet.getSprite(6*World.TS, 3*World.TS, World.TS, World.TS);
	public static BufferedImage WHITEGIRL_KID = Game.spritesheet.getSprite(6*World.TS, 4*World.TS, World.TS, World.TS);
	public static BufferedImage WHITEGIRL_ADOLESCENT = Game.spritesheet.getSprite(6*World.TS, 5*World.TS, World.TS, World.TS);
	
	public Entity(double x, double y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, (int) x - Camera.x, (int) y - Camera.y, World.TS, World.TS, null);
	}
	
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
