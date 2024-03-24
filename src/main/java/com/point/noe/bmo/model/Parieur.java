package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter 
@Setter
public class Parieur {
	@Id
	@Column(length=32)
	@Required
	private String nom;
	
	@Embedded
	@NoFrame
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
};
