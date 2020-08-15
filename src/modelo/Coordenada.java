package modelo;

public class Coordenada { 
	private int x; 
	private int y; 
	
	/**
	 * Constructor de coordenada
	 * @param y entero para la matriz en eje y
	 * @param x entero para la mattriz en eje x
	 */
	public Coordenada(int x,int y) { 
		this.setX(x); 
		this.setY(y); 
	} 
 
	public int getX() 
	{ 
		return this.x; 
	} 

	public void setX(int x) 
	{ 
		this.x = x; 
	} 

	public int getY() 
	{ 
		return this.y; 
	} 

	public void setY(int y) 
	{ 
		this.y = y; 
	} 
} 
