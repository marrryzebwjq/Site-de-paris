package com.point.noe.bmo.model;

import javax.persistence.*;

@Entity
public class Parieur {
	@Id
	private String nom;
	
	@Embedded
	private Compte compte;
	
	public boolean DemandeTicketSimple(String evenement, String nomPari, String pari1, int montant)
	{
		
		return true;
	}
	public boolean DemandeTicket1Entier(String evenement, String nomPari, int pari1, int montant)
	{
		
		return true;
	}
	public boolean DemandeTicket2Entier(String evenement, String nomPari, int pari1, int pari2, int montant)
	{
		
		return true;
	}
	public boolean DemandeTicket1String(String evenement, String nomPari, String pari1)
	{
		
		return true;
	}
	public boolean DemandeVersement(int montant)
	{
		
		return true;
	}
}
