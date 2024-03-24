package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Ticket1Entier extends ATicket {

    public Integer PariEntier1;

    @Override
    public boolean EstGagnant()
    {
    	if (this.Pari instanceof Pari1Entier)
    	{
    		Pari1Entier p = (Pari1Entier)Pari;
    		if (this.PariEntier1.equals(p.Reference1)) return true;
    	}
    	return false;
    }
};
