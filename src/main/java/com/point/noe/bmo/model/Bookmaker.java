package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Bookmaker {
	@Id
	@Required
	@Column(length=32, unique=true)
	private String Nom;
	
	public static boolean DemandeOuvertureEvenement(String sport, String evenement, AResultat resultat)
	{
		
		return true;
	}
}
