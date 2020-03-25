package com.lking.entities;

import java.awt.image.BufferedImage;

import com.lking.main.Game;
import com.lking.world.World;

public class WhiteGirl extends Figurant {

	public WhiteGirl(double x, double y, int width, int height, BufferedImage sprite, int age) {
		super(x, y, width, height, sprite, age);
		
		rightFigurant = new BufferedImage[maxAnimation];
		leftFigurant = new BufferedImage[maxAnimation];
		
		if(age == 1) {
			for(int i = 0; i < maxAnimation; i++) {
				rightFigurant[i] = Game.spritesheet.getSprite((i+3)*World.TS, 3*World.TS, World.TS, World.TS);
			}
			for(int i = 0; i < maxAnimation; i++) {
				leftFigurant[i] = Game.spritesheetinv.getSprite((i+3)*World.TS, 3*World.TS, World.TS, World.TS);
			}
		} else if(age == 2) {
			for(int i = 0; i < maxAnimation; i++) {
				rightFigurant[i] = Game.spritesheet.getSprite((i+3)*World.TS, 4*World.TS, World.TS, World.TS);
			}
			for(int i = 0; i < maxAnimation; i++) {
				leftFigurant[i] = Game.spritesheetinv.getSprite((i+3)*World.TS, 4*World.TS, World.TS, World.TS);
			}
		}else if(age == 3) {
			for(int i = 0; i < maxAnimation; i++) {
				rightFigurant[i] = Game.spritesheet.getSprite((i+3)*World.TS, 5*World.TS, World.TS, World.TS);
			}
			for(int i = 0; i < maxAnimation; i++) {
				leftFigurant[i] = Game.spritesheetinv.getSprite((i+3)*World.TS, 5*World.TS, World.TS, World.TS);
			}
		}
	}

}
