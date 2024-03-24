package com.point.noe.bmo.model;

import javax.persistence.*;

@Entity
public class Parieur {
	@Id
	private String nom;
	
	@Embedded
	private Compte compte;
}
