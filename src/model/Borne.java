package model;

import java.util.ArrayList;

public class Borne {
	
	private int id;
	private int nombreVelosMax;
	private int nombreVelosDispo;
	private ArrayList<Socle> listSocle;
	
	public Borne(int id, int nombreVelosMax, int nombreVelosDispo, ArrayList<Socle> listSocle)
	{
		this.id = id;
		this.nombreVelosMax = nombreVelosMax;
		this.nombreVelosDispo = nombreVelosDispo;
		this.listSocle = listSocle;
	}
	
	
	private Velo velo;
	public Velo VerifierVelo()
	{
		return velo;
	}
}
