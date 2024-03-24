package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Pari2Entier extends APariAvance {

	public Pari2Entier(
			String InNom,
			Integer InReference1,
			Integer InReference2,
			int InPariMax,
			int InGainMax)
	{
		this.Nom		= InNom;
		this.Reference1 = InReference1;
		this.Reference2 = InReference2;
		this.PariMax    = InPariMax;
		this.GainMax 	= InGainMax;
	}
	
	public Integer Reference1;
	public Integer Reference2;

};
