package com.lking.world;

public class Camera {

	public static int x;
	public static int y;
	
	// M�todo para n�o mostrar pixels fora do mapa
	public static int clamp(int cordAtual, int cordMin, int cordMax) {
		if(cordAtual < cordMin) {
			cordAtual = cordMin;
		}
		
		if(cordAtual > cordMax) {
			cordAtual = cordMax;
		}
		
		return cordAtual;
	}
}
