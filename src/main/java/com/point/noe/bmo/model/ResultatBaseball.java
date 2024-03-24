package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class ResultatBaseball extends AResultat {
    
    public Integer ScoreA;
    public Integer ScoreB;

    @Action("DemandeCreationPari")
    @Override
    public APariAvance DemandeCreationPari(String InNomPari, int PariMax, int GainMax)
    {
    	switch(InNomPari)
    	{
	    	case "Scores":
	    		return new Pari2Entier(InNomPari, this.ScoreA, this.ScoreB, PariMax, GainMax);
	    		
	    	default:
	    		return null;
    	}
    	
    }
};
