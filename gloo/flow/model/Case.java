package gloo.flow.model;

public class Case {
	public int l;
	public int c;
	private Plot plot;
	public Plateau plateau;
	public Tuyau tuyau;
	
	public Case(int l, int c,Plateau plateau) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.c = c;
		this.plateau = plateau;
		
	}
	public void setPlot(Couleur couleur, boolean estPlotDepart) {
		this.plot = new Plot(couleur,this,estPlotDepart);
	}
	public Plot getPlot() {
		return this.plot;
	}
	
	public Case getCaseVoisine(Direction  dir) {
		return plateau.getMaCaseVoisine(this,dir);
    
	}
	
	public void accepteTuyau(Tuyau tuyau){
		if(this.tuyau ==null && plot==null) {
			tuyau.ajouteCase(this);
			this.tuyau = tuyau;
		}else if(plot != null) {
			if(this.plot.accepteTuyau(tuyau)) {
				tuyau.ajouteCase(this);
				this.tuyau = tuyau;
			}
		}
		
	}
	
	public boolean valideFinJeu() {
		if(plot!=null && plot.estPlotDepart) {
			return true;
		}else {
			return this.tuyau!=null;
		}
	}
	

}
