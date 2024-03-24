package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Pari1String extends APariAvance {

	public Pari1String(
			String InNom,
			String InReference1,
			int InPariMax,
			int InGainMax)
	{
		this.Nom		= InNom;
		this.Reference1 = InReference1;
		this.PariMax    = InPariMax;
		this.GainMax 	= InGainMax;
	}
	
	public String Reference1;

};
