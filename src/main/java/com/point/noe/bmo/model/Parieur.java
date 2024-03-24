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
	public void DemandeTicketSimple(String evenement, String nomPari, String pari1, int montant)
	{
		Systeme.AjouteTicket1Simple(evenement, nomPari, pari1, this, montant);
	}
	@Action("DemandeTicket1Entier")
	public void DemandeTicket1Entier(String evenement, String nomPari, int pari1, int montant)
	{
		Systeme.AjouteTicket1Entier(evenement, nomPari, pari1, this, montant);
	}
	@Action("DemandeTicket2Entier")
	public void DemandeTicket2Entier(String evenement, String nomPari, int pari1, int pari2, int montant)
	{
		Systeme.AjouteTicket2Entier(evenement, nomPari, pari1, pari2, this, montant);
	}
	@Action("DemandeTicket1String")
	public void DemandeTicket1String(String evenement, String nomPari, String pari1, int montant)
	{
		Systeme.AjouteTicket1String(evenement, nomPari, pari1, this, montant);
	}
	// Permet d'émuler le fait de remplir le compte du parieur
	@Action("DemandeVersement")
	public void DemandeVersement(int montant)
	{
		this.getCompte().Montant += montant;
	}
};
