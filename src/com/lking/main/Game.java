package com.lking.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.lking.entities.Entity;
import com.lking.entities.MyNotebook;
import com.lking.entities.Player;
import com.lking.graficos.Spritesheet;
import com.lking.world.Camera;
import com.lking.world.World;


public class Game extends Canvas implements KeyListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8561159821221647102L;

	private Thread thread;
	
	private boolean isRunning = false;
	
	private BufferedImage mainImage;
	
	public static int WIDTH = World.TS*10;
	public static int HEIGHT = World.TS*6;
	private int SCALE = 4;
	
	private World world;
	public static Player player;
	
	public static List<Entity> entities;
	public static List<Entity> backgrounds;
	
	public static Spritesheet spritesheet;
	public static Spritesheet spritesheetinv;
	public static Spritesheet spritesheetbg;
	
	public static BufferedImage PhinneasEFerb;

	public static Random rand;
	
	public static String gameState = "GAME";
	
	public static int curCity = 2;
	public static int maxCity = 4;
	
	public static boolean cutScene1 = false;
	
	public InputStream stream_AA = ClassLoader.getSystemClassLoader().getResourceAsStream("ArcadeAlternate.ttf");
	public Font ArcadeAlternate;
	
	private Comparator<Entity> entitySorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity o1, Entity o2) {
			if(o1.depth < o2.depth)
				return 1;
			if(o1.depth > o2.depth)
				return -1;
			return 0;
		}
		
	};
	
	public Game() {
		mainImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();

		rand = new Random();
		spritesheet = new Spritesheet("/spritesheet.png");
		spritesheetinv = new Spritesheet("/spritesheetinv.png");
		spritesheetbg = new Spritesheet("/spritesheetbg.png");
		
		
		
		
		// phinneas e ferb
		try {
			PhinneasEFerb = ImageIO.read(getClass().getResource("/phineaseferb.jpeg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//
		
		
		
		entities = new ArrayList<Entity>();
		backgrounds = new ArrayList<Entity>();
		
		player = new Player(0, 0, World.TS, World.TS, Entity.PLAYER_BABY);
	
		world = new World("/map" + curCity + ".png", "/ent" + curCity +".png", "/bg" + curCity + ".png");
		try {
			ArcadeAlternate = Font.createFont(Font.TRUETYPE_FONT, stream_AA).deriveFont(18f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	private void restartGame(int mapNum) {
		entities.clear();
		backgrounds.clear();
		
		String map = "/map" + mapNum + ".png";
		String ent = "/ent" + mapNum + ".png";
		String bg = "/bg" + mapNum + ".png";
		world = new World(map, ent, bg);
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.start();
		game.stop();
	}
	
	private void tick() {
		if(gameState == "GAME") {			
			
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
		
		if(player.getX() > World.WIDTH*World.TS) {
			curCity++;
			if(curCity > maxCity)
				curCity = 1;
			player.setDefaultImage = true;
			
			restartGame(curCity);
		}
		
		Collections.sort(entities, entitySorter);
		
		} else if(gameState == "CUTSCENE1") {
			MyNotebook.NotebookCutScene();
		} else if (gameState == "GAMERESTART") {
			restartGame(1);
			gameState = "GAME";
		}
		
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(6);
			return;
		}
		
		Graphics g = mainImage.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		// render things
		world.render(g);

		for(int i = 0; i < backgrounds.size(); i++)
			backgrounds.get(i).render(g);
		
		
		

		
		
		
		for(int i = 0; i < entities.size(); i++)
			entities.get(i).render(g);

		//
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(mainImage, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		
		// render things after pixelization
		g.setFont(ArcadeAlternate);
		if(curCity == 1)
			g.drawString("BRASILIA", 20 - Camera.x, 40 - Camera.y);
		else if(curCity == 2)
			g.drawString("ARACAJU", 20 - Camera.x, 40 - Camera.y);
		else if(curCity == 3)
			g.drawString("SAO PAULO", 20 - Camera.x, 40 - Camera.y);
		else if(curCity == 4)
			g.drawString("CAMPINAS", 20 - Camera.x, 40 - Camera.y);
		
		if(curCity == 2)
			g.drawImage( PhinneasEFerb, 2149 - (Camera.x*SCALE), 228 - (Camera.y*SCALE), 54, 35, null);
		//
		
		
		bs.show();
	}
	
	private void initFrame() {
		JFrame frame = new JFrame("Pac-Man");
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	private synchronized void start() {
		if(isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!isRunning)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		requestFocus();
		// Game FPS control	
		int fps = 60;
		double ns = 1000000000/fps;
		double delta = 0;
		long pastNano = System.nanoTime();
		long currentNano;
		
		int numOfFrames = 0;
		long pastSec = System.currentTimeMillis();
		
		while(isRunning) {
			currentNano = System.nanoTime();
			delta += (currentNano - pastNano)/ns;
			pastNano = currentNano;
			if(delta >= 1) {
				tick();
				render();
				numOfFrames++;
				delta--;
			}
			if(System.currentTimeMillis() - pastSec >= 1000) {
				System.out.println("FPS: " + numOfFrames);
				numOfFrames = 0;
				pastSec += 1000;
			}
		}
		
		stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				player.left = true;
				player.moving = true;

				player.right = false;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				player.right = true;
				player.moving = true;
	
				player.left = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				player.left = false;
				player.moving = false;

		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				player.right = false;
				player.moving = false;
	
		}
	}
	
}
