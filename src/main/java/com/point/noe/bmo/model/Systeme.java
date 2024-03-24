package com.point.noe.bmo.model;

import java.util.*;

import javax.persistence.*;

public class Systeme {
	@OneToMany
	private Collection<Evenement> evenements;
}
