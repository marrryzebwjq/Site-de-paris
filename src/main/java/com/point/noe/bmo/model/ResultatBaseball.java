package com.point.noe.bmo.model;

import javax.persistence.*;

@Embeddable
public class ResultatBaseball extends AResultat {
    
    public Integer scoreA;
    public Integer scoreB;

};
