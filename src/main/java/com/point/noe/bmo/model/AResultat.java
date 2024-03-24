package com.point.noe.bmo.model;

import javax.persistence.*;

@MappedSuperclass @Embeddable
public abstract class AResultat {
	public String Gagnant;
	
	public void DemandeAjoutPari1Entier(Integer Reference1)
	{
	
	}
	public void DemandeAjoutPari2Entier(Integer Reference1, Integer Reference2)
	{
		
	}
	public void DemandeAjoutPari1String(String Reference1)
	{
		
	}
};
