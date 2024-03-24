package com.point.noe.bmo.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@MappedSuperclass 
@Embeddable
public abstract class ATicket {
	@Getter
	@Required
    protected int Montant;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @Embedded
    @Required
    @Getter
    protected APari Pari;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @Embedded
    @Getter
    protected Parieur Parieur;

    abstract public boolean EstGagnant();

};
