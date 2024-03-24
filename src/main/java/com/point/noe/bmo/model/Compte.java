package com.point.noe.bmo.model;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter @Setter
public class Compte {	
	@Column(length = 12)
	public int Montant = 1000;
};
