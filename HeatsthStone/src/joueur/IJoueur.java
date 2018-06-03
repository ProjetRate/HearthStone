package joueur;

import carte.ICarte;
import exception.HearthStoneException;
import heros.Heros;

import java.util.ArrayList;

public interface IJoueur {
	int MAX_MANA = 10;
	int MAX_CARTES_MAIN = 10;
	int TAILLE_DECK = 15;

	
	void finirTour();
	ICarte getCarteEnJeu(String nomCarte) throws HearthStoneException;
	ICarte 	getCarteEnMain(String nomCarteMain) throws HearthStoneException;
	Heros getHeros();
	ArrayList<ICarte> getJeu();
	ArrayList<ICarte> getMain();
	String getNom();
	void jouerCarte(ICarte carte) throws HearthStoneException;
	void jouerCarte(ICarte carte, java.lang.Object cible);
	void perdreCarte(ICarte carte);
	void piocher() throws HearthStoneException;
	void prendreTour();
	void utiliserCarte(ICarte carte, java.lang.Object cible);
	void utiliserPouvoir(java.lang.Object cible);
	int getMana();
}
