package com.point.noe.bmo.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
public class Systeme {
	@OneToMany(fetch=FetchType.LAZY)
	@Embedded
	private static Collection<Evenement> evenements;
	
	public static void AjouteTicket1Simple(String evenement, String pari, String pari1, Parieur parieur, int montant)
	{
		// Vérifie si le parieur peut se faire débiter
		if (parieur.getCompte().getMontant() < montant || montant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(evenement) && e.PariSimple.Nom.equals(pari))
			{
				if(e.PariSimple.PariMax != -1 && montant > e.PariSimple.PariMax)
				{
					// Pas possible de créer le ticket, montant demandé plus grand que le pari max
					return;
				}
				
				e.Tickets.add(new TicketSimple(montant, e.PariSimple, parieur, pari1));
				
				// Débite
				parieur.getCompte().Montant -= montant;
				
				break;
			}
		}
	}
	public static void AjouteTicket1Entier(String evenement, String pari, int pari1, Parieur parieur, int montant)
	{
		// Vérifie si le parieur peut se faire débiter
		if (parieur.getCompte().getMontant() < montant || montant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(evenement))
			{
				for (APariAvance p : e.PariAvances)
				{
					if (p instanceof Pari1String && p.Nom.equals(pari))
					{
						if(p.PariMax != -1 && montant > p.PariMax)
						{
							// Pas possible de créer le ticket, montant demandé plus grand que le pari max
							return;
						}
						
						e.Tickets.add(new Ticket1Entier(montant, p, parieur, pari1));
						
						// Débite
						parieur.getCompte().Montant -= montant;

						break;
					}
				}
				break;
			}
		}
	}
	public static void AjouteTicket2Entier(String evenement, String pari, int pari1, int pari2, Parieur parieur, int montant)
	{
		// Vérifie si le parieur peut se faire débiter
		if (parieur.getCompte().getMontant() < montant || montant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(evenement))
			{
				for (APariAvance p : e.PariAvances)
				{
					if (p instanceof Pari1String && p.Nom.equals(pari))
					{
						if(p.PariMax != -1 && montant > p.PariMax)
						{
							// Pas possible de créer le ticket, montant demandé plus grand que le pari max
							return;
						}
						
						e.Tickets.add(new Ticket2Entier(montant, p, parieur, pari1, pari2));
						
						// Débite
						parieur.getCompte().Montant -= montant;

						break;
					}
				}
				break;
			}
		}
	}
	public static void AjouteTicket1String(String evenement, String pari, String pari1, Parieur parieur, int montant)
	{
		// Vérifie si le parieur peut se faire débiter
		if (parieur.getCompte().getMontant() < montant || montant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(evenement))
			{
				for (APariAvance p : e.PariAvances)
				{
					if (p instanceof Pari1String && p.Nom.equals(pari))
					{
						if(p.PariMax != -1 && montant > p.PariMax)
						{
							// Pas possible de créer le ticket, montant demandé plus grand que le pari max
							return;
						}
						
						e.Tickets.add(new Ticket1String(montant, p, parieur, pari1));
						
						// Débite
						parieur.getCompte().Montant -= montant;
						
						break;
					}
				}
				break;
			}
		}
	}
	public static void AjoutePari(String evenement, String pari, int maxPari, int maxGain)
	{
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(evenement))
			{
				// Vérifie si le pari est déjà présent
				for (APariAvance p : e.PariAvances)
				{
					if (p.Nom.equals(pari)) return;
				}
				
				// Ajout du pari
				e.PariAvances.add(e.Resultat.DemandeCreationPari(pari, maxPari, maxGain));
			
				// Fin
				break;
			}
		}
	}
	public static AResultat AccederResultats(String InEvenement)
	{
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(InEvenement))
			{
				return e.Resultat;
			}
		}
		
		return null;
	}
	public static void OuvrirEvenement(USport InSport, String InNom, int InPariMaxSimple, int InGainMaxSimple)
	{
		for (Evenement e : evenements)
		{
			// Element déjà présent
			if (e.Nom.equals(InNom)) return;
			
			// Ouverture de l'évènement
			evenements.add(new Evenement(InSport, InNom, InPariMaxSimple, InGainMaxSimple));
		}
	}
	public static void FermerEvenement(String evenement)
	{
		for (Evenement e : evenements)
		{
			// Recherche de l'évènement
			if (e.Nom.equals(evenement))
			{
				// Crédite les parieurs gagnant
				int nGagnants 	  = 0;				
				for (ATicket t : e.Tickets)
				{
					if (t.EstGagnant()) nGagnants++;
				}
				
				int nRatio = e.Tickets.size() / nGagnants;
				
				for (ATicket t : e.Tickets)
				{
					if (t.EstGagnant())
					{
						int ACrediter = t.Montant * nRatio;
						if (ACrediter > t.Pari.GainMax)
						{
							ACrediter = t.Pari.GainMax;
						}
						
						// Crédite
						t.Parieur.getCompte().Montant += ACrediter;
					}
				}
				
				evenements.remove(e);
				break;
			}
		}
	}
	public static void Versement(Parieur InParieur, int InMontant)
	{
		InParieur.getCompte().Montant += InMontant;
	}
};
