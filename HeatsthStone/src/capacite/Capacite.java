package capacite;

public class Capacite implements ICapacite{
	
	private String nom, description;

    public Capacite(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	@Override
    public void executerAction(Object cible) {
		if(cible == null)
			return; //throw
		if (getClass() != cible.getClass())
			return;//throw
    }

    @Override
    public void executerEffetDebutTour() {

    }

    @Override
    public void executerEffetDisparition(Object cible) {

    }

    @Override
    public void executerEffetFinTour() {

    }

    @Override
    public void executerEffetMiseEnJeu(Object cible) {

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
