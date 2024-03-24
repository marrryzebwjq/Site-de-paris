package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class ResultatBaseball extends AResultat {
    
    public Integer ScoreA;
    public Integer ScoreB;

    @Action("DemandeCreationPari")
    @Override
    public APariAvance DemandeCreationPari(String InNomPari, int InPariMax, int InGainMax)
    {
    	switch(InNomPari)
    	{
	    	case "Scores":
	    		return new Pari2Entier(InNomPari, this.ScoreA, this.ScoreB, InPariMax, InGainMax);
	    		
	    	default:
	    		return null;
    	}
    	
    }
};
