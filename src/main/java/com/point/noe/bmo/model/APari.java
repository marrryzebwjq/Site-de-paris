package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@MappedSuperclass @Embeddable
public abstract class APari {
	
	// Gain de pari total
	//public GainTotal : int;

	// Pari max
	@Required
	@Column(length=12)
	private int PariMax;
	
	// Gain de pari max
	@Required
	@Column(length=12)
	private int PariGainMax;
}
