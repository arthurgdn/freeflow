package gloo.flow.model;

public class Plateau {
	private int nbLignes = 5;
	private int nbColonnes = 5;
	private Case[][] cases;
	
	public Plateau() {
		// TODO Auto-generated constructor stub
		this.cases = new Case[5][5];
		for(int i = 0; i<5;i++) {
			
			for(int j = 0;j<5;j++) {
				cases[i][j] = new Case(i,j,this);
			}
		}
		
	}
	
	public Case[][] getCases(){
		return this.cases;
	}
	
	public Plot getPlot(int l, int c) {
		return cases[l][c].getPlot();
	}
	
	public Case getMaCaseVoisine(Case caseActive, Direction dir) {
		int l = caseActive.l;
		int c = caseActive.c;
		
		return switch (dir) {
        	case HAUT -> cases[l-1][c];
        	case BAS -> cases[l+1][c];
        	case DROITE -> cases[l][c+1];
        	case GAUCHE -> cases[l][c-1];
		};
	}
	
	public boolean plateauComplet() {
		boolean isComplet = true;
		for(int i = 0; i<5;i++) {
			
			for(int j = 0;j<5;j++) {
				if(!cases[i][j].valideFinJeu()) {
					isComplet = false;
				}
			}
		}
		return isComplet;
	} 

}
