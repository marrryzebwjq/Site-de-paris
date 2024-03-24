package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Ticket1String extends ATicket {
	public String PariString;

	public Ticket1String(
			int InMontant,
			APari InPari,
			Parieur InParieur,
			String InPariString)
	{
		this.Montant 	= InMontant;
		this.Pari    	= InPari;
		this.Parieur 	= InParieur;
		this.PariString = InPariString;
	}
	
	@Override
	public boolean EstGagnant()
    {
    	if (this.Pari instanceof Pari1String)
    	{
    		Pari1String p = (Pari1String)Pari;
    		if (this.PariString.equals(p.Reference1)) return true;
    	}
    	return true;
    }
};
