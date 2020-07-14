package modelo;

public abstract class Jugador { 
	public boolean whiteSide; 
	public boolean humanPlayer; 

	public boolean isWhiteSide() 
	{ 
		return this.whiteSide == true; 
	} 
	public boolean isHumanPlayer() 
	{ 
		return this.humanPlayer == true; 
	} 
} 

public class HumanPlayer extends Jugador { 

	public HumanPlayer(boolean whiteSide) 
	{ 
		this.whiteSide = whiteSide; 
		this.humanPlayer = true; 
	} 
} 

public class ComputerPlayer extends Jugador { 

	public ComputerPlayer(boolean whiteSide) 
	{ 
		this.whiteSide = whiteSide; 
		this.humanPlayer = false; 
	} 
} 

