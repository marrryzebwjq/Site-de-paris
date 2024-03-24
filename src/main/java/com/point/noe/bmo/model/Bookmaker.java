package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Getter 
@Setter
public class Bookmaker extends Identifiable {
	@Column(length=32, unique=true)
	@Required
	private String nom;
	
	@Action("DemandeOuvertureEvenement")
	public void DemandeOuvertureEvenement(String sport, String evenement, AResultat resultat)
	{
		
	}
	@Action("DemandeResultat")
	public void DemandeResultat(String evenement)
	{
		
	}
	@Action("DemandeFermetureEvenement")
	public void DemandeFermetureEvenement(String evenement)
	{
		
	}
};
