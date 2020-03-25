package com.lking.entities;

import java.awt.image.BufferedImage;

import com.lking.main.Game;
import com.lking.world.World;

public class MyNotebook extends Entity {
	
	private static int cutScene1Frames = 0; 
	private static int cutScene1MaxFrames = 3*60; 
	
	public MyNotebook(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.y = (-2)*World.TS;
	}
	
	public static void NotebookCutScene() {
		Entity en = null;
		if(en == null)
			en = getNotebook();
		
		
		if(en.y >= 4*World.TS) {
			cutScene1Frames++;
			if(cutScene1Frames == cutScene1MaxFrames) {
				Game.gameState = "GAME";
				Game.backgrounds.remove(en);
			}
			
		} else {
			en.y += 0.5;
		}
			
	}
	
	public static Entity getNotebook() {
		for(int i = 0; i < Game.backgrounds.size(); i++) {
			if(Game.backgrounds.get(i) instanceof MyNotebook)
				return(Game.backgrounds.get(i));
			
		}
		return null;
	}

}
