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
	
	public static void AjouteTicket1Simple(String InEvenement, String InPari, String InPari1, Parieur InParieur, int InMontant)
	{
		// Vérifie si le InParieur peut se faire débiter
		if (InParieur.getCompte().getMontant() < InMontant || InMontant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(InEvenement) && e.PariSimple.Nom.equals(InPari))
			{
				if(e.PariSimple.PariMax != -1 && InMontant > e.PariSimple.PariMax)
				{
					// Pas possible de créer le ticket, InMontant demandé plus grand que le InPari max
					return;
				}
				
				e.Tickets.add(new TicketSimple(InMontant, e.PariSimple, InParieur, InPari1));
				
				// Débite
				InParieur.getCompte().Montant -= InMontant;
				
				break;
			}
		}
	}
	public static void AjouteTicket1Entier(String InEvenement, String InPari, int InPari1, Parieur InParieur, int InMontant)
	{
		// Vérifie si le InParieur peut se faire débiter
		if (InParieur.getCompte().getMontant() < InMontant || InMontant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(InEvenement))
			{
				for (APariAvance p : e.PariAvances)
				{
					if (p instanceof Pari1String && p.Nom.equals(InPari))
					{
						if(p.PariMax != -1 && InMontant > p.PariMax)
						{
							// Pas possible de créer le ticket, InMontant demandé plus grand que le InPari max
							return;
						}
						
						e.Tickets.add(new Ticket1Entier(InMontant, p, InParieur, InPari1));
						
						// Débite
						InParieur.getCompte().Montant -= InMontant;

						break;
					}
				}
				break;
			}
		}
	}
	public static void AjouteTicket2Entier(String InEvenement, String InPari, int InPari1, int pari2, Parieur InParieur, int InMontant)
	{
		// Vérifie si le InParieur peut se faire débiter
		if (InParieur.getCompte().getMontant() < InMontant || InMontant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(InEvenement))
			{
				for (APariAvance p : e.PariAvances)
				{
					if (p instanceof Pari1String && p.Nom.equals(InPari))
					{
						if(p.PariMax != -1 && InMontant > p.PariMax)
						{
							// Pas possible de créer le ticket, InMontant demandé plus grand que le InPari max
							return;
						}
						
						e.Tickets.add(new Ticket2Entier(InMontant, p, InParieur, InPari1, pari2));
						
						// Débite
						InParieur.getCompte().Montant -= InMontant;

						break;
					}
				}
				break;
			}
		}
	}
	public static void AjouteTicket1String(String InEvenement, String InPari, String InPari1, Parieur InParieur, int InMontant)
	{
		// Vérifie si le InParieur peut se faire débiter
		if (InParieur.getCompte().getMontant() < InMontant || InMontant < 0)
		{
			// Pas possible de créer le ticket
			return;
		}
		
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(InEvenement))
			{
				for (APariAvance p : e.PariAvances)
				{
					if (p instanceof Pari1String && p.Nom.equals(InPari))
					{
						if(p.PariMax != -1 && InMontant > p.PariMax)
						{
							// Pas possible de créer le ticket, InMontant demandé plus grand que le InPari max
							return;
						}
						
						e.Tickets.add(new Ticket1String(InMontant, p, InParieur, InPari1));
						
						// Débite
						InParieur.getCompte().Montant -= InMontant;
						
						break;
					}
				}
				break;
			}
		}
	}
	public static void AjoutePari(String InEvenement, String InPari, int maxPari, int maxGain)
	{
		for (Evenement e : evenements)
		{
			if (e.Nom.equals(InEvenement))
			{
				// Vérifie si le InPari est déjà présent
				for (APariAvance p : e.PariAvances)
				{
					if (p.Nom.equals(InPari)) return;
				}
				
				// Ajout du InPari
				e.PariAvances.add(e.Resultat.DemandeCreationPari(InPari, maxPari, maxGain));
			
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
	public static void FermerEvenement(String InEvenement)
	{
		for (Evenement e : evenements)
		{
			// Recherche de l'évènement
			if (e.Nom.equals(InEvenement))
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
};
