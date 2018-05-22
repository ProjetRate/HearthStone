package capacite;

public interface ICapacite {
	void executerAction(Object cible);
	void executerEffetDebutTour();
	void executerEffetDisparition(Object cible);
	void executerEffetFinTour();
	void executerEffetMiseEnJeu(Object cible);
	String getDescription();
	String getNom();
	
}
