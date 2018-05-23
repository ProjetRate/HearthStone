package joueur;

import carte.ICarte;
import exception.HearthStoneException;
import heros.Heros;

import java.util.ArrayList;

public interface IJoueur {
	int MAX_MANA = 10;
	int TAILLE_DECK = 15;
	
	void finirTour();
	ICarte getCarteEnJeu(String nomCarte) throws HearthStoneException;
	ICarte 	getCarteEnMain(String nomCarteMain) throws HearthStoneException;
	Heros getHeros();
	ArrayList<ICarte> getJeu();
	ArrayList<ICarte> getMain();
	String getPseudo();
	int getStockEnergie();
	void jouerCarte(ICarte carte);
	void jouerCarte(ICarte carte, java.lang.Object cible);
	void perdreCarte(ICarte carte);
	void piocher();
	void prendreTour();
	void utiliserCarte(ICarte carte, java.lang.Object cible);
	void utiliserPouvoir(java.lang.Object cible);
	int getMana();
}
