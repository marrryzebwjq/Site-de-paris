package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Ticket1String extends ATicket {

	public String PariString;

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
