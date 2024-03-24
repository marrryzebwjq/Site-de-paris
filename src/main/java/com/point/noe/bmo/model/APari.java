package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@MappedSuperclass 
@Embeddable
public abstract class APari {
	// Nom du pari
	@Column(length=32)
	@Required
	public String Nom;
	
	// Pari max
	@Column(length=12)
	@Required
	public int PariMax;
	
	// Gain de pari max
	@Column(length=12)
	@Required
	public int GainMax;
};
