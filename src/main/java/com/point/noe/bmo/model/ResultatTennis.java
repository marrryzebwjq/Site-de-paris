package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class ResultatTennis extends AResultat {
    
    public Integer ScoreA1; 
    public Integer ScoreB1; 
    public Integer ScoreA2;
    public Integer ScoreB2; 
    public Integer ScoreA3; 
    public Integer ScoreB3; 
    public Integer ScoreA4;
    public Integer ScoreB4;
    public Integer ScoreA5; 
    public Integer ScoreB5;
    
    @Action("DemandeCreationPari")
    @Override
    public APariAvance DemandeCreationPari(String InNomPari, int InPariMax, int InGainMax)
    {
    	switch(InNomPari)
    	{
	    	case "Score 1er Set":
	    		return new Pari2Entier(InNomPari, this.ScoreA1, this.ScoreB1, InPariMax, InGainMax);
	    		
	    	case "Score 2eme Set":
	    		return new Pari2Entier(InNomPari, this.ScoreA2, this.ScoreB2, InPariMax, InGainMax);
	    	
	    	case "Score 3eme Set":
	    		return new Pari2Entier(InNomPari, this.ScoreA3, this.ScoreB3, InPariMax, InGainMax);
	    	
	    	case "Score 4eme Set":
	    		return new Pari2Entier(InNomPari, this.ScoreA4, this.ScoreB4, InPariMax, InGainMax);
	    	
	    	case "Score 5eme Set":
	    		return new Pari2Entier(InNomPari, this.ScoreA5, this.ScoreB5, InPariMax, InGainMax);
	    		
	    	default:
	    		return null;
    	}
    }
};
