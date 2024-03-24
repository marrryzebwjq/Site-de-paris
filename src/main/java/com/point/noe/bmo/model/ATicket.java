package com.point.noe.bmo.model;

import javax.persistence.*;

@MappedSuperclass @Embeddable
public abstract class ATicket {
    private int Montant;

    public Boolean estGagnant()
    {

    } 

}
