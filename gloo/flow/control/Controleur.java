package gloo.flow.control;

import gloo.flow.model.Case;
import gloo.flow.model.Couleur;
import gloo.flow.model.Direction;
import gloo.flow.model.Plateau;
import gloo.flow.model.Tuyau;

/**
 * Controleur bouchon pour tester l'IHM du jeu FlowFree 
 * 
 * @author Dominique Marcadet
 * @version 1.1
 *
 */
public class Controleur implements IControleur {
    private Tuyau t_rouge = new Tuyau(Couleur.ROUGE);
    private Tuyau t_orange = new Tuyau(Couleur.ORANGE);
    private Tuyau t_bleu = new Tuyau(Couleur.BLEU);
    private Tuyau t_vert = new Tuyau(Couleur.VERT);
    private Tuyau t_jaune = new Tuyau(Couleur.JAUNE);
    private Tuyau tuyauCourant;
    private Plateau plateau = new Plateau();
    
    public Controleur() {
    	
    	plateau.getCases()[0][0].setPlot(Couleur.ROUGE,true);
    	plateau.getCases()[1][4].setPlot(Couleur.ORANGE,true);
    	plateau.getCases()[1][2].setPlot(Couleur.BLEU,true);
    	plateau.getCases()[0][2].setPlot(Couleur.VERT,true);
    	plateau.getCases()[0][4].setPlot(Couleur.JAUNE,true);
    	
    	plateau.getCases()[4][1].setPlot(Couleur.ROUGE,false);
    	plateau.getCases()[4][3].setPlot(Couleur.ORANGE,false);
    	plateau.getCases()[4][2].setPlot(Couleur.BLEU,false);
    	plateau.getCases()[3][1].setPlot(Couleur.VERT,false);
    	plateau.getCases()[3][3].setPlot(Couleur.JAUNE,false);
    	
    }
    @Override
    public boolean selectionCase( int ligne, int colonne ) {
        Case caseSelectionnee = plateau.getCases()[ligne][colonne];
        if(caseSelectionnee.getPlot()!=null && caseSelectionnee.getPlot().estPlotDepart) {
        	Couleur couleurPlot = caseSelectionnee.getPlot().couleur;
        	switch (couleurPlot) {
            	case ROUGE -> {t_rouge.plotSelectionne(caseSelectionnee); tuyauCourant = t_rouge;}
            	case ORANGE -> {t_orange.plotSelectionne(caseSelectionnee); tuyauCourant=t_orange;}
            	case BLEU -> {t_bleu.plotSelectionne(caseSelectionnee); tuyauCourant=t_bleu;}
            	case VERT -> {t_vert.plotSelectionne(caseSelectionnee);tuyauCourant=t_vert;}
            	case JAUNE -> {t_jaune.plotSelectionne(caseSelectionnee);tuyauCourant=t_jaune;}
        	};
        	return true;
        }else {
        	return false;
        }
        
    }

    @Override
    public boolean action( Direction direction ) {
        if(tuyauCourant==null) {
        	return false;
        }else {
        	tuyauCourant.modifier(direction);
        	return plateau.plateauComplet();
        }
    }

    @Override
    public int getNbLignes() {
        return 5;
    }

    @Override
    public int getNbColonnes() {
        return 5;
    }

    @Override
    public int[] getPositionPlotDepartTuyau( Couleur couleur ) {
        return switch (couleur) {
            case ROUGE -> new int[] { 0, 0 };
            case ORANGE -> new int[] { 1, 4 };
            case BLEU -> new int[] { 1, 2 };
            case VERT -> new int[] { 0, 2 };
            case JAUNE -> new int[] { 0, 4 };
        };
    }

    @Override
    public int[] getPositionSecondPlot( Couleur couleur ) {
        return switch( couleur ) {
            case ROUGE  -> new int[] { 4, 1 };
            case ORANGE -> new int[] { 4, 3 };
            case BLEU   -> new int[] { 4, 2 };
            case VERT   -> new int[] { 3, 1 };
            case JAUNE  -> new int[] { 3, 3 };
        };
    }

    @Override
    public Direction[] getDirections(Couleur couleur) {
        return switch (couleur) {
            case ROUGE  -> t_rouge.getDirections();
            case ORANGE -> t_orange.getDirections();
            case BLEU   -> t_bleu.getDirections();
            case VERT   -> t_vert.getDirections();
            case JAUNE  -> t_jaune.getDirections();
        };
    }
}
