package modelo;

import modelo.fichas.Ficha;

public class Movimiento { 
	
	private Coordenada start; 
	private Coordenada end;
	private boolean isCapture = false;
	private boolean castlingMove = false; 
	
	
	/**
	 * Constructor de movimiento 
	 * @param start coordenada inicial
	 * @param end coordenada fianl
	 */
	public Movimiento(Coordenada start, Coordenada end, boolean capture) { 
		this.start = start; 
		this.end = end;
		isCapture = capture;
	} 
	
	
	
	public Coordenada getStart() {
		return start;
	}

	public void setStart(Coordenada start) {
		this.start = start;
	}

	public Coordenada getEnd() {
		return end;
	}

	public void setEnd(Coordenada end) {
		this.end = end;
	}

	public boolean isCapture() {
		return isCapture;
	}

	public void setCapture(boolean isCapture) {
		this.isCapture = isCapture;
	}

	

	public boolean isCastlingMove() 
	{ 
		return this.castlingMove == true; 
	} 

	public void setCastlingMove(boolean castlingMove) 
	{ 
		this.castlingMove = castlingMove; 
	} 
} 
