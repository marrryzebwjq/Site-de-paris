package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Bookmaker {
	@Id
	@Required
	@Column(length=32, unique=true)
	private String Nom;
	
	public boolean DemandeOuvertureEvenement(String sport, String evenement, AResultat resultat)
	{
		
		return true;
	}
	public boolean DemandeResultat(String evenement)
	{
		
		return true;
	}
	public boolean DemandeFermetureEvenement(String evenement)
	{
		
		return true;
	}
}
