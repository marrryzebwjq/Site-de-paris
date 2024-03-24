package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class ResultatTennis extends AResultat {
    
    public Integer scoreA1; 
    public Integer scoreB1; 
    public Integer scoreA2;
    public Integer scoreB2; 
    public Integer scoreA3; 
    public Integer scoreB3; 
    public Integer scoreA4;
    public Integer scoreB4;
    public Integer scoreA5; 
    public Integer scoreB5;
    public String joueurA;
    public String joueurB;

};
