package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class ResultatFootball extends AResultat {
    
    public ScoreMiTempsA1 : Integer;
    public ScoreMiTempsB1 : Integer;
    public ScoreMiTempsA2 : Integer;
    public ScoreMiTempsB2 : Integer;

}
