package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class TicketSimple extends ATicket {

	public String PariGagnant;

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
