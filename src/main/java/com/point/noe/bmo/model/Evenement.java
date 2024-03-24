package com.point.noe.bmo.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Evenement {
	// Constructeur
	public Evenement(USport InSport, String InNom)
	{
		this.Sport 		 = InSport;
		this.Nom   	  	 = InNom;
		
		// Resultat
		switch(this.Sport)
		{
			case TENNIS:
				this.Resultat = new ResultatTennis();
				break;
				
			case BASEBALL:
				this.Resultat = new ResultatBaseball();
				break;
				
			case FOOTBALL:
				this.Resultat = new ResultatFootball();
				break;
				
			default:
				System.err.println("Le type de sport n'est pas reconnu!");
		}
		
		// Tickets
		this.Tickets = new ArrayList<ATicket>();
		
		// Pari simple
		this.PariSimple = new PariSimple(Resultat.Gagnant);
		
		// Pari Avancés
		this.PariAvances = new ArrayList<APariAvance>();
		
	}
	
	// Sport
	@Required
	@Column(length=16)
	@Enumerated(EnumType.ORDINAL)
	private USport Sport;
	
	// Nom
	@Required
	@Column(length=8)
	private String Nom;
	
	
	// Resultat
	private AResultat Resultat;
	
	// Tickets
	@OneToMany
	private Collection<ATicket> Tickets;
	
	// Pari Simple
	private PariSimple PariSimple;
	
	// Pari Avances
	@OneToMany
	private Collection<APariAvance> PariAvances;
};
