package model;

public class Socle {
	
	private int id; 
	private boolean utiliser;
	private boolean utilisable;
	private Velo velo;
	
	public Socle(int id, boolean utiliser, boolean utilisable, Velo velo)
	{
		this.id = id;
		this.utiliser = utiliser;
		this.utilisable = utilisable;
		this.velo = velo;
	}
	
	public Velo verifierV()
	{
		return velo;
	}
}
