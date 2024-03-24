package com.point.noe.bmo.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Evenement {
	// Constructeur
	public Evenement(USport InSport, String InNom, int InPariMax, int InGainMax)
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
		this.Tickets 	 = new ArrayList<ATicket>();
		
		// Pari simple
		this.PariSimple  = new PariSimple(Resultat.Gagnant, InPariMax, InGainMax);
		
		// Pari Avancés
		this.PariAvances = new ArrayList<APariAvance>();
		
	}
	
	// Sport
	@Required
	@Column(length=16)
	@Enumerated(EnumType.ORDINAL)
	public USport Sport;
	
	// Nom
	@Required
	@Column(length=8)
	public String Nom;
	
	
	// Resultat
	@Embedded
	public AResultat Resultat;
	
	// Tickets
	@OneToMany(
			fetch=FetchType.LAZY)
	public Collection<ATicket> Tickets;
	
	// Pari Simple
	@Embedded
	public PariSimple PariSimple;
	
	// Pari Avances
	@OneToMany(
			fetch=FetchType.LAZY)
	public Collection<APariAvance> PariAvances;
};
