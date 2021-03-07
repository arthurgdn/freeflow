package gloo.flow.model;

public class Plot {
	public Couleur couleur;
	public Case parentCase;
	public boolean estPlotDepart;
	
	public Plot(Couleur couleur, Case parentCase, boolean estPlotDepart) {
		this.couleur = couleur;
		this.parentCase = parentCase;
		this.estPlotDepart = estPlotDepart;
	}
	public boolean accepteTuyau(Tuyau tuyau) {
		if(this.couleur.equals(tuyau.getCouleur())) {
			return !tuyau.estDansTuyau(parentCase);
		}else {
			return false;
		}
	}

}
