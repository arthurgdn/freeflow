package gloo.flow;

import javax.swing.SwingUtilities;

import gloo.flow.control.Controleur;
import gloo.flow.hmi.Fenetre;

/**
 * Programme de test du controleur bouchon du jeu FlowFree
 * 
 * @author Dominique Marcadet
 * @version 1.1
 *
 */
public class TestAvecControleur implements Runnable {

	public static void main( String[] args ) {
        SwingUtilities.invokeLater( new TestAvecControleur() );
	}

    @Override
    public void run() {
        new Fenetre( new Controleur() );
    }
}
