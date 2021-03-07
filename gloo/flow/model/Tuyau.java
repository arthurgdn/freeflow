package gloo.flow.model;

import java.util.ArrayList;

public class Tuyau {
	private ArrayList<Case> casesDansTuyau;
	private ArrayList<Direction> directions = new ArrayList<Direction>();
	private Couleur couleur;
	public Tuyau(Couleur couleur) {
		this.casesDansTuyau = new ArrayList<Case>();
		setCouleur(couleur);
		
	}
	public Couleur getCouleur() {
		return couleur;
	}
	
	public Direction[] getDirections() {
		Direction[] directions = new Direction[this.directions.size()];
		return this.directions.toArray(directions);
	}
	
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public void modifier(Direction dir) {
		Case derniereCase = casesDansTuyau.get(casesDansTuyau.size()-1);
		Case caseVoisine = derniereCase.getCaseVoisine(dir);
		if(caseVoisine!=null) {
			caseVoisine.accepteTuyau(this);
		}
	}
	private Direction directionNouvelleCase(int l,int c) {
		
		int previous_l = casesDansTuyau.get(casesDansTuyau.size()-1).l;
		int previous_c = casesDansTuyau.get(casesDansTuyau.size()-1).c;
		int movementValue = l-previous_l + 2*(c-previous_c);
		return switch(movementValue) {
         case -1  -> Direction.HAUT;
         case 1 -> Direction.BAS;
         case -2   -> Direction.GAUCHE;
         case 2   -> Direction.DROITE;
         default -> throw new IllegalArgumentException("Unexpected value: " + movementValue);
     };
	}
	public void ajouteCase(Case nouvelleCase) {
		directions.add(directionNouvelleCase(nouvelleCase.l,nouvelleCase.c));
		casesDansTuyau.add(nouvelleCase);
		
	}
	public void plotSelectionne(Case caseSelectionnee) {
		if(casesDansTuyau.size()>0) {
			for(Case caseDansTuyau : casesDansTuyau) {
				caseDansTuyau.tuyau = null;
				
			}
			directions.clear();
			casesDansTuyau.clear();
			
		}
		casesDansTuyau.add(caseSelectionnee);
	}
	public boolean estDansTuyau(Case caseATrouver) {
		boolean estDansTuyau = false;
		for(Case caseDansTuyau : casesDansTuyau) {
			if(caseDansTuyau.equals(caseATrouver)) {
				estDansTuyau = true;
			}
		}
		return estDansTuyau;
	}

}
