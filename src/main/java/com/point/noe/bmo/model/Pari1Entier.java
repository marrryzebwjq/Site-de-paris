package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Pari1Entier extends APariAvance {

	public Pari1Entier(
			String InNom,
			Integer InReference1,
			int InPariMax,
			int InGainMax)
	{
		this.Nom		= InNom;
		this.Reference1 = InReference1;
		this.PariMax    = InPariMax;
		this.GainMax 	= InGainMax;
	}
	
	public Integer Reference1;

};
