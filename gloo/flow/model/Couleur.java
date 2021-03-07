package gloo.flow.model;

/**
 * Énumérations des couleurs pour le jeu FlowFree
 * 
 * @author Dominique Marcadet
 * @version 1.1
 *
 */
public enum Couleur {
	ROUGE,
	ORANGE,
	BLEU,
	VERT,
	JAUNE;
	
	/*
	 * Il est IMPORTANT de noter qu'une énumération en Java est 
	 * aussi une classe, et peut donc avoir aussi des attributs, 
	 * des méthodes... Il est donc possible de respecter le
	 * modèle métier du jeu avec cette énumération.
	 * La seule contrainte est qu'il n'est pas possible de créer
	 * d'autres instances que celles nommées ci-dessus, ce qui
	 * implique en particulier qu'un éventuel constructeur doit
	 * être privé.
	 */
	
}
