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
	
	@Action("AjoutePari")
	public void DemandeAjoutPari(String InEvenement, String InPari, int InMaxPari, int InMaxGain)
	{
		Systeme.AjoutePari(InEvenement, InPari, InMaxPari, InMaxGain);
	}
	@Action("DemandeOuvertureEvenement")
	public void DemandeOuvertureEvenement(USport InSport, String InEvenement, int InPariMaxSimple, int InPariGainMax)
	{
		Systeme.OuvrirEvenement(InSport, InEvenement, InPariMaxSimple, InPariGainMax);
	}
	@Action("DemandeResultats")
	public AResultat DemandeResultats(String InEvenement)
	{
		return Systeme.AccederResultats(InEvenement);
	}
	@Action("DemandeFermetureEvenement")
	public void DemandeFermetureEvenement(String InEvenement)
	{
		Systeme.FermerEvenement(InEvenement);
	}
};
