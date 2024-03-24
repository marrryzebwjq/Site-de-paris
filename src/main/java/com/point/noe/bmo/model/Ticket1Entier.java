package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Ticket1Entier extends ATicket {

    public int PariEntier1;
    
    public Ticket1Entier(
			int InMontant,
			APari InPari,
			Parieur InParieur,
			int InPariEntier)
	{
		this.Montant 	 = InMontant;
		this.Pari    	 = InPari;
		this.Parieur 	 = InParieur;
		this.PariEntier1 = InPariEntier;
	}

    @Override
    public boolean EstGagnant()
    {
    	if (this.Pari instanceof Pari1Entier)
    	{
    		Pari1Entier p = (Pari1Entier)Pari;
    		if (p.Reference1.equals(PariEntier1)) return true;
    	}
    	return false;
    }
};
