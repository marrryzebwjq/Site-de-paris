package com.point.noe.bmo.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Evenement {
	@Required
	@Column(length=16)
	private USport Sport;
	@Required
	@Column(length=8)
	private String Nom;
	@Required
	@Column(length=12)
	private int PariMax;
	@Required
	@Column(length=12)
	private int PariGainMax;
	
	private AResultat Resultat;
	
	@OneToMany
	private Collection<ATicket> Tickets;
	
	private PariSimple PariSimple;
	
	@OneToMany
	private Collection<APariAvance> PariAvances;
}
