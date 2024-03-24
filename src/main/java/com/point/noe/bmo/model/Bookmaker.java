package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter 
@Setter
public class Bookmaker {
	@Id
	@Column(length=32)
	@Required
	private String nom;
	
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
};
