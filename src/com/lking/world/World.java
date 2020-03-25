package com.lking.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lking.entities.BlackGirl;
import com.lking.entities.BlondGuy;
import com.lking.entities.Entity;
import com.lking.entities.MyNotebook;
import com.lking.entities.WhiteGirl;
import com.lking.entities.WhiteGuy;
import com.lking.main.Game;


public class World {

	public static int TS = 16;		// tile size
	public static int HEIGHT, WIDTH;
	
	public static Tile[] tiles;
	
	public World(String path, String pathentities, String pathbg) {
		BufferedImage pixelMap = null;
		try {
			pixelMap = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WIDTH = pixelMap.getWidth();
		HEIGHT = pixelMap.getHeight();
		
		int[] pixels = new int[WIDTH*HEIGHT];
		pixelMap.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
		
		tiles = new Tile[HEIGHT*WIDTH];
		
		int pixelAtual;
		
		// Tiles
		
		for(int yy = 0; yy < HEIGHT; yy++) {
			for(int xx = 0; xx < WIDTH; xx++) {
				pixelAtual = xx + (yy * WIDTH);
				
				if(pixels[pixelAtual] == 0xFF29AC00) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.GRASS_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF8FAA86) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.GRASSNFLOOR_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFFFAC54) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.KINDERGARTENFLOOR_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFEAEAEA) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.AIRPORTFLOOR_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFF9E3E6) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.SCHOOLFLOOR_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFFFD67F) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.SAND_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF135CAF) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.OCEANWATER_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFA342FF) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.BEDROOMFLOOR_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF60605D) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.CEMENT_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF1D7500) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.DIRTNGRASS_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF8C611C) {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.DIRT_TILE);
					continue;
				}
				
				else if(pixels[pixelAtual] == 0xFF0083ED) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.SKY0_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF26A7FB) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.SKY1_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF45C3FD) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.SKY2_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF75D9FD) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.SKY3_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF88DFFC) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.SKY4_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFFFED93) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.KINDERGARTENBG_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF156FAF) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.AIRPORTBG_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFD7F7D9) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.SCHOOLBG_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFFBCE1FC) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.SKY4NOCEANWATERBG_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF5753D6) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.BEDROOMBG_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF4386BA) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.POLUTIONSKY0_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF588EB7) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.POLUTIONSKY1_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF6393B7) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.POLUTIONSKY2_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF7399B5) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.POLUTIONSKY3_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF839DAF) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.POLUTIONSKY4_TILE);
					continue;
				} else if(pixels[pixelAtual] == 0xFF5E6B5E) {
					tiles[pixelAtual] = new TileBackground(xx*16, yy*16, Tile.WALL_TILE);
					continue;
				}
				else {
					tiles[pixelAtual] = new TileFloor(xx*16, yy*16, Tile.GRASSNFLOOR_TILE);
				}

				
			}
		}
			
		
		// Entities
		BufferedImage pixelEntities = null;
		try {
			pixelEntities = ImageIO.read(getClass().getResource(pathentities));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pixelEntities.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
		
		for(int yy = 0; yy < HEIGHT; yy++) {
			for(int xx = 0; xx < WIDTH; xx++) {
				pixelAtual = xx + (yy * WIDTH);
				
				if(pixels[pixelAtual] == 0xFF00FF00) {			// Player
					Game.entities.add(Game.player);		
					Game.player.setX(xx*World.TS);
					Game.player.setY(yy*World.TS);
					continue;
				} else if(pixels[pixelAtual] == 0xFFFFFF5E) {			// BlondGuy
					Entity blondguy = new BlondGuy(xx*16, yy*16, World.TS, World.TS, Entity.BLONDGUY_BABY, 1);
					Game.entities.add(blondguy);		
					continue;
				} else if(pixels[pixelAtual] == 0xFFF1009F) {			// BlackGirl
					Game.entities.add(new BlackGirl(xx*16, yy*16, World.TS, World.TS, Entity.BLACKGIRL_BABY, 1));		
					continue;
				} else if(pixels[pixelAtual] == 0xFFFE8E00) {			// WhiteGuy
					Game.entities.add(new WhiteGuy(xx*16, yy*16, World.TS, World.TS, Entity.WHITEGUY_BABY, 1));	
					continue;
				} else if(pixels[pixelAtual] == 0xFF03EF12) {			// WhiteGirl
					Game.entities.add(new WhiteGirl(xx*16, yy*16, World.TS, World.TS, Entity.WHITEGIRL_BABY, 1));		
					continue;
				} else if(pixels[pixelAtual] == 0xFFE5E554) {			// BlondGuy
					Entity blondguy = new BlondGuy(xx*16, yy*16, World.TS, World.TS, Entity.BLONDGUY_KID, 2);
					Game.entities.add(blondguy);		
					continue;
				} else if(pixels[pixelAtual] == 0xFFD6008E) {			// BlackGirl
					Game.entities.add(new BlackGirl(xx*16, yy*16, World.TS, World.TS, Entity.BLACKGIRL_KID, 2));		
					continue;
				} else if(pixels[pixelAtual] == 0xFF04D30E) {			// WhiteGuy
					Game.entities.add(new WhiteGuy(xx*16, yy*16, World.TS, World.TS, Entity.WHITEGUY_KID, 2));	
					continue;
				} else if(pixels[pixelAtual] == 0xFFE27C00) {			// WhiteGirl
					Game.entities.add(new WhiteGirl(xx*16, yy*16, World.TS, World.TS, Entity.WHITEGIRL_KID, 2));		
					continue;
				} else if(pixels[pixelAtual] == 0xFFC9C94A) {			// BlondGuy
					Entity blondguy = new BlondGuy(xx*16, yy*16, World.TS, World.TS, Entity.BLONDGUY_ADOLESCENT, 3);
					Game.entities.add(blondguy);		
					continue;
				} else if(pixels[pixelAtual] == 0xFFBA007C) {			// BlackGirl
					Game.entities.add(new BlackGirl(xx*16, yy*16, World.TS, World.TS, Entity.BLACKGIRL_ADOLESCENT, 3));		
					continue;
				} else if(pixels[pixelAtual] == 0xFF03B709) {			// WhiteGuy
					Game.entities.add(new WhiteGuy(xx*16, yy*16, World.TS, World.TS, Entity.WHITEGUY_ADOLESCENT, 3));	
					continue;
				} else if(pixels[pixelAtual] == 0xFFC66A00) {			// WhiteGirl
					Game.entities.add(new WhiteGirl(xx*16, yy*16, World.TS, World.TS, Entity.WHITEGIRL_ADOLESCENT, 3));		
					continue;
				}
			}
		}
		
		
		// Backgrounds
		BufferedImage pixelBackgrounds = null;
		try {
			pixelBackgrounds = ImageIO.read(getClass().getResource(pathbg));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pixelBackgrounds.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
		
		for(int yy = 0; yy < HEIGHT; yy++) {
			for(int xx = 0; xx < WIDTH; xx++) {
				pixelAtual = xx + (yy * WIDTH);
				
				if(pixels[pixelAtual] == 0xFF808080) {		// Congresso Nacional
					for(int yl = 0; yl <= 3; yl++) {
						for(int xl = 0; xl <= 3; xl++) {
							BufferedImage sprite = Game.spritesheetbg.getSprite(xl*World.TS, yl*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
				} else if(pixels[pixelAtual] == 0xFFAA6817) {	// KinderGarten Bookshelf
					for(int yl = 0; yl <= 2; yl++) {
						for(int xl = 0; xl <= 2; xl++) {
							int xoff = 4;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, yl*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
				} else if(pixels[pixelAtual] == 0xFF0A00A5) {	// Strip
					BufferedImage sprite = Game.spritesheetbg.getSprite(0*World.TS, 9*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				} else if(pixels[pixelAtual] == 0xFFCA4C26) {	// Balcony
					BufferedImage sprite = Game.spritesheetbg.getSprite(1*World.TS, 9*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				} else if(pixels[pixelAtual] == 0xFF877CFF) {	// Bagage
					BufferedImage sprite = Game.spritesheetbg.getSprite(2*World.TS, 9*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				} else if(pixels[pixelAtual] == 0xFFFF0000) {	// Painting
					BufferedImage sprite = Game.spritesheetbg.getSprite(3*World.TS, 9*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
				
				} else if(pixels[pixelAtual] == 0xFFF9FF00) {	// Eletric Fence
					BufferedImage sprite = Game.spritesheetbg.getSprite(4*World.TS, 9*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				} else if(pixels[pixelAtual] == 0xFF427053) {	// BlackBoard
					for(int yl = 0; yl <= 1; yl++) {
						for(int xl = 0; xl <= 2; xl++) {
							int xoff = 1;
							int yoff = 4;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
				} else if(pixels[pixelAtual] == 0xFFFCFF54) {
					for(int yl = 0; yl <= 1; yl++) {
						for(int xl = 0; xl <= 0; xl++) {
							int yoff = 4;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
				} else if(pixels[pixelAtual] == 0xFF78BA80) {	// School Desk
					BufferedImage sprite = Game.spritesheetbg.getSprite(2*World.TS, 8*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				} else if(pixels[pixelAtual] == 0xFF95C99B) {	// School Chair
					BufferedImage sprite = Game.spritesheetbg.getSprite(3*World.TS, 8*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				} else if(pixels[pixelAtual] == 0xFFBF000F) {	// Eletric Guitar
					for(int yl = 0; yl <= 0; yl++) {
						for(int xl = 0; xl <= 1; xl++) {
							int yoff = 8;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
				} else if(pixels[pixelAtual] == 0xFF684219) {
					for(int yl = 0; yl <= 2; yl++) {
						for(int xl = 0; xl <= 1; xl++) {
							int xoff = 7;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, (yl)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
				} else if(pixels[pixelAtual] == 0xFFFF931C) {	// Naruto Painting
					BufferedImage sprite = Game.spritesheetbg.getSprite(2*World.TS, 6*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new Entity((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				} else if(pixels[pixelAtual] == 0xFF404040) {	// Television
					for(int yl = 0; yl <= 1; yl++) {
						for(int xl = 0; xl <= 1; xl++) {
							int yoff = 6;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
				continue;
				
				} else if(pixels[pixelAtual] == 0xFFD40000) {	// XBox
					for(int yl = 0; yl <= 0; yl++) {
						for(int xl = 0; xl <= 1; xl++) {
							int xoff = 2;
							int yoff = 7;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
				continue;
				
				} else if(pixels[pixelAtual] == 0xFF44E500) {	// Coconut Palm
				for(int yl = 0; yl <= 2; yl++) {
					for(int xl = 0; xl <= 2; xl++) {
						int xoff = 4;
						int yoff = 3;
						BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
						Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
					}
				}
				continue;
				
				} else if(pixels[pixelAtual] == 0xFF565656) {	// Boom box
					for(int yl = 0; yl <= 1; yl++) {
						for(int xl = 0; xl <= 2; xl++) {
							int xoff = 6;
							int yoff = 8;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
					
				} else if(pixels[pixelAtual] == 0xFF3F3F3F) {	// Big City BackGround
					for(int yl = 0; yl <= 2; yl++) {
						for(int xl = 0; xl <= 2; xl++) {
							int xoff = 7;
							int yoff = 3;
							BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
							Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
						}
					}
					continue;
					
				} else if(pixels[pixelAtual] == 0xFFDBFF4C) {	// Corote Table
						for(int yl = 0; yl <= 0; yl++) {
							for(int xl = 0; xl <= 1; xl++) {
								int xoff = 4;
								int yoff = 8;
								BufferedImage sprite = Game.spritesheetbg.getSprite((xl+xoff)*World.TS, (yl+yoff)*World.TS, World.TS, World.TS);
								Game.backgrounds.add(new Entity((xx+xl)*World.TS, (yy+yl)*World.TS, World.TS, World.TS, sprite));
							}
						}
						continue;
						
				} else if(pixels[pixelAtual] == 0xFF21007F) {	// My Notebook
					BufferedImage sprite = Game.spritesheetbg.getSprite(5*World.TS, 9*World.TS, World.TS, World.TS);
					Game.backgrounds.add(new MyNotebook((xx)*World.TS, (yy)*World.TS, World.TS, World.TS, sprite));
					continue;
		
				}
				
			}
		}
	}
	
//	public void render(Graphics g) {
//		for(int yy = 0; yy < HEIGHT; yy++) {
//			for(int xx = 0; xx < WIDTH; xx++) {
//				Tile tile = tiles[xx + (yy*WIDTH)];
//				tile.render(g);
//			}
//		}
//	}
	
	public void render(Graphics g) {
		/** Renderizar apenas o que está sendo mostrado na tela **/
		int xstart = Camera.x >> 4;		// ">> 4" divide por 16 mais rapidamente
		int ystart = Camera.y >> 4;
		
		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
		/****                                                 ****/
	}
}
