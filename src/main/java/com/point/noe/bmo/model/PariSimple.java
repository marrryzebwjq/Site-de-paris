package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class PariSimple extends APari {
	private String Reference;
	
	public PariSimple(String InReference)
	{
		this.Reference = InReference;
	}
}
