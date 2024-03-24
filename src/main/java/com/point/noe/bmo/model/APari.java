package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@MappedSuperclass @Embeddable
public abstract class APari {
	// Nom du pari
	@Required
	@Column(length=32)
	private String Nom;
	
	// Gain Total
	private int GainTotal;
	
	// Pari max
	@Required
	@Column(length=12)
	private int PariMax;
	
	// Gain de pari max
	@Required
	@Column(length=12)
	private int PariGainMax;
}
