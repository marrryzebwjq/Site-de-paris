package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@MappedSuperclass @Embeddable
public abstract class AResultat {
	public String Gagnant;
	
	@Action("DemandeCreationPari")
	abstract public APariAvance DemandeCreationPari(String NomPari, int PariMax, int GainMax);
};
