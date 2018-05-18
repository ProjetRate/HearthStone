package Joueur;

import carte.ICarte;

public interface IJoueur {
	static final int MAX_ENERGIE = 10;
	static final int TAILLE_DECK = 15;
	
	public abstract void finirTour();
	public abstract ICarte getCarteEnJeu(String nomCarte);
	public abstract ICarte 	getCarteEnMain(String nomCarteMain);
	public abstract jeu.Heros getHeros();
	public abstract java.util.ArrayList<ICarte> getJeu();
	public abstract java.util.ArrayList<ICarte> getMain();
	public abstract java.lang.String getPseudo();
	public abstract int getStockEnergie();
	public abstract void jouerCarte(ICarte carte);
	public abstract void jouerCarte(ICarte carte, java.lang.Object cible);
	public abstract void perdreCarte(ICarte carte);
	public abstract void piocher();
	public abstract void prendreTour();
	public abstract void utiliserCarte(ICarte carte, java.lang.Object cible);
	public abstract void utiliserPouvoir(java.lang.Object cible);
	public abstract int getEnergie();
}
