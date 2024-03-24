package com.point.noe.bmo.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
public class Systeme {
	@Id
	private String Nom;
	
	@OneToMany(fetch=FetchType.LAZY)
	@Embedded
	private Collection<Evenement> evenements;
	
	public void AjouteTicket1Simple(String evenement, String pari, String pari1, Parieur parieur, int montant)
	{
		
	}
	public void AjouteTicket1Entier(String evenement, String pari, int pari1, Parieur parieur, int montant)
	{
		
	}
	public void AjouteTicket2Entier(String evenement, String pari, int pari1, int pari2, Parieur parieur, int montant)
	{
		
	}
	public void AjouteTicket1String(String evenement, String pari, String pari1, Parieur parieur, int montant)
	{
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(evenement))
			{
				if (e.PariSimple.Nom.equals(pari))
				{
					
				}
			}
		}
	}
	public void AjoutePari(String evenement, Integer reference1, int maxPari, int maxGain)
	{
		
	}
	public void OuvrirEvenement(USport sport, String nom)
	{
		
	}
	public void FermetureEvenement(String evenement)
	{
		
	}
	public void Debiter(Parieur parieur, ATicket ticket)
	{
		
	}
	public void Crediter(APari pari, ATicket ticket)
	{
		
	}
};
