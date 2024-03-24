package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class TicketSimple extends ATicket {

	public String PariGagnant;

	public TicketSimple(
			int InMontant,
			APari InPari,
			Parieur InParieur,
			String InPariGagnant)
	{
		this.Montant 	 = InMontant;
		this.Pari    	 = InPari;
		this.Parieur 	 = InParieur;
		this.PariGagnant = InPariGagnant;
	}
	
	@Override
	public boolean EstGagnant()
	{
		if (this.Pari instanceof PariSimple)
	    {
			PariSimple p = (PariSimple)Pari;
	    	if (this.PariGagnant.equals(p.Reference)) return true;
	    }
		return true;
	}
};
