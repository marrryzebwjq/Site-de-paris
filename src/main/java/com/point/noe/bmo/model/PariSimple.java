package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class PariSimple extends APari {
	public String Reference;
	
	public PariSimple(
			String InReference,
			int InPariMax,
			int InGainMax)
	{
		this.Nom	   = new String("Simple");
		this.Reference = InReference;
		this.PariMax   = InPariMax;
		this.GainMax   = InGainMax;
	}
};
