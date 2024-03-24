package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class ResultatFootball extends AResultat {

    public Integer ScoreMiTempsA1;
    public Integer ScoreMiTempsB1;
    public Integer ScoreMiTempsA2;
    public Integer ScoreMiTempsB2;
    
    @Action("DemandeCreationPari")
    @Override
    public APariAvance DemandeCreationPari(String InNomPari, int InPariMax, int InGainMax)
    {
    	switch(InNomPari)
    	{
    		case "Score MiTemps 1":
    			return new Pari2Entier(InNomPari, this.ScoreMiTempsA1, this.ScoreMiTempsB1, InPariMax, InGainMax);
    			
    		case "Score MiTemps 2":
    			return new Pari2Entier(InNomPari, this.ScoreMiTempsA2, this.ScoreMiTempsB2, InPariMax, InGainMax);
    			
    		default:
    			return null;
    	}
    }
};
