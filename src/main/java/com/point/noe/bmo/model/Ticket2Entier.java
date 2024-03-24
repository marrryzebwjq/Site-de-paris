package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Ticket2Entier extends ATicket {
    
	public Integer PariEntier1;
	public Integer PariEntier2;

	@Override
	public boolean EstGagnant()
	{
	    if (this.Pari instanceof Pari2Entier)
	    {
	    	Pari2Entier p = (Pari2Entier)Pari;
	    	if (this.PariEntier1.equals(p.Reference1) && this.PariEntier2.equals(p.Reference2)) return true;
	    }
		return true;
	}
};
