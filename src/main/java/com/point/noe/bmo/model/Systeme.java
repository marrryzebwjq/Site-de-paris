package com.point.noe.bmo.model;

import java.util.*;

import javax.persistence.*;

public class Systeme {
	@OneToMany
	private Collection<Evenement> evenements;
	
	public void AjouteTicket1Simple(String evenement, PariSimple pari, String pari1, Parieur parieur, int montant)
	{
		
	}
	public void AjouteTicket1Entier(String evenement, Pari1Entier pari, int pari1, Parieur parieur, int montant)
	{
		
	}
	public void AjouteTicket2Entier(String evenement, Pari2Entier pari, int pari1, int pari2, Parieur parieur, int montant)
	{
		
	}
	public void AjouteTicket1String(String evenement, Pari1String pari, String pari1, Parieur parieur, int montant)
	{
		
	}
	public void AjoutePari1Entier(String evenement, Integer reference1, int maxPari, int maxGain)
	{
		
	}
	public void AjoutePari2Entier(String evevenent, Integer reference1, Integer reference2, int maxPari, int maxGain)
	{
		
	}
	public void AjoutePari1String(String evenement, String reference, int maxPari, int maxGain)
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
