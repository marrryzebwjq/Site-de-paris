package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Getter 
@Setter
public class Parieur extends Identifiable {
	@Column(length=32, unique=true)
	@Required
	private String Nom;
	
	@Embedded
	@NoFrame
	private Compte Compte;
	
	@Action("DemandeTicketSimple")
	public void DemandeTicketSimple(String InEvenement, String InPari, String InPari1, int InMontant)
	{
		Systeme.AjouteTicket1Simple(InEvenement, InPari, InPari1, this, InMontant);
	}
	@Action("DemandeTicket1Entier")
	public void DemandeTicket1Entier(String InEvenement, String InPari, int InPari1, int InMontant)
	{
		Systeme.AjouteTicket1Entier(InEvenement, InPari, InPari1, this, InMontant);
	}
	@Action("DemandeTicket2Entier")
	public void DemandeTicket2Entier(String InEvenement, String InPari, int InPari1, int pari2, int InMontant)
	{
		Systeme.AjouteTicket2Entier(InEvenement, InPari, InPari1, pari2, this, InMontant);
	}
	@Action("DemandeTicket1String")
	public void DemandeTicket1String(String InEvenement, String InPari, String InPari1, int InMontant)
	{
		Systeme.AjouteTicket1String(InEvenement, InPari, InPari1, this, InMontant);
	}
	// Permet d'émuler le fait de remplir le compte du parieur
	@Action("DemandeVersement")
	public void DemandeVersement(int InMontant)
	{
		this.getCompte().Montant += InMontant;
	}
};
