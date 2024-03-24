package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class Ticket2Entier extends ATicket {
    
	public int PariEntier1;
	public int PariEntier2;

	public Ticket2Entier(
			int InMontant,
			APari InPari,
			Parieur InParieur,
			int InPariEntier1,
			int InPariEntier2)
	{
		this.Montant 	 = InMontant;
		this.Pari    	 = InPari;
		this.Parieur 	 = InParieur;
		this.PariEntier1 = InPariEntier1;
		this.PariEntier2 = InPariEntier2;
	}
	
	@Override
	public boolean EstGagnant()
	{
	    if (this.Pari instanceof Pari2Entier)
	    {
	    	Pari2Entier p = (Pari2Entier)Pari;
	    	if (p.Reference1.equals(PariEntier1) && p.Reference2.equals(PariEntier2)) return true;
	    }
		return true;
	}
};
