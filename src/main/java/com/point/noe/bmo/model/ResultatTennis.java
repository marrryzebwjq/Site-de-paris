package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class ResultatTennis extends AResultat {
    
    public scoreA1 : Integer; 
    public scoreB1 : Integer; 
    public scoreA2 : Integer;
    public scoreB2 : Integer; 
    public scoreA3 : Integer; 
    public scoreB3 : Integer; 
    public scoreA4 : Integer;
    public scoreB4 : Integer;
    public scoreA5 : Integer; 
    public scoreB5 : Integer;
    public joueurA : String;
    public joueurB : String;

}
