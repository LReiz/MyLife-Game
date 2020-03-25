package com.lking.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lking.main.Game;


public class Tile {

	
	protected int x;
	protected int y;
	protected BufferedImage sprite;
	public boolean collision;
	
	// Backgrounds
	public static BufferedImage SKY0_TILE = Game.spritesheet.getSprite(0, 6*World.TS, World.TS, World.TS);
	public static BufferedImage SKY1_TILE = Game.spritesheet.getSprite(1*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage SKY2_TILE = Game.spritesheet.getSprite(2*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage SKY3_TILE = Game.spritesheet.getSprite(3*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage SKY4_TILE = Game.spritesheet.getSprite(4*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage KINDERGARTENBG_TILE = Game.spritesheet.getSprite(5*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage AIRPORTBG_TILE = Game.spritesheet.getSprite(6*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage SKY4NOCEANWATERBG_TILE = Game.spritesheet.getSprite(7*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage SCHOOLBG_TILE = Game.spritesheet.getSprite(8*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage BEDROOMBG_TILE = Game.spritesheet.getSprite(9*World.TS, 6*World.TS, World.TS, World.TS);
	public static BufferedImage POLUTIONSKY0_TILE = Game.spritesheet.getSprite(0, 8*World.TS, World.TS, World.TS);
	public static BufferedImage POLUTIONSKY1_TILE = Game.spritesheet.getSprite(1*World.TS, 8*World.TS, World.TS, World.TS);
	public static BufferedImage POLUTIONSKY2_TILE = Game.spritesheet.getSprite(2*World.TS, 8*World.TS, World.TS, World.TS);
	public static BufferedImage POLUTIONSKY3_TILE = Game.spritesheet.getSprite(3*World.TS, 8*World.TS, World.TS, World.TS);
	public static BufferedImage POLUTIONSKY4_TILE = Game.spritesheet.getSprite(4*World.TS, 8*World.TS, World.TS, World.TS);
	public static BufferedImage WALL_TILE = Game.spritesheet.getSprite(5*World.TS, 8*World.TS, World.TS, World.TS);
	
	// Floors
	public static BufferedImage GRASS_TILE = Game.spritesheet.getSprite(0, 7*World.TS, World.TS, World.TS);
	public static BufferedImage GRASSNFLOOR_TILE = Game.spritesheet.getSprite(1*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage KINDERGARTENFLOOR_TILE = Game.spritesheet.getSprite(2*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage AIRPORTFLOOR_TILE = Game.spritesheet.getSprite(3*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage SAND_TILE = Game.spritesheet.getSprite(4*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage SCHOOLFLOOR_TILE = Game.spritesheet.getSprite(5*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage BEDROOMFLOOR_TILE = Game.spritesheet.getSprite(6*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage OCEANWATER_TILE = Game.spritesheet.getSprite(7*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage CEMENT_TILE = Game.spritesheet.getSprite(8*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage DIRTNGRASS_TILE = Game.spritesheet.getSprite(9*World.TS, 7*World.TS, World.TS, World.TS);
	public static BufferedImage DIRT_TILE = Game.spritesheet.getSprite(0, 9*World.TS, World.TS, World.TS);
	
	protected Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x - Camera.x, y - Camera.y, World.TS, World.TS, null);
	}
}
