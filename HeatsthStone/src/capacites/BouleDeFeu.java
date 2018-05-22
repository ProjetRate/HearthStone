package capacites;

import capacite.Capacite;

public class BouleDeFeu extends Capacite {

	public BouleDeFeu() {
		super("Boule de feu", "Pouvoir h�roique: inflige 1 point de d�g�t au personnage cibl� (le	h�ros adverse ou l'un de ses serviteurs)");
	}

	@Override
	public void executerAction(Object cible) {		
		super.executerAction(cible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		// TODO Auto-generated method stub
		Capacite other = (Capacite)obj;
		return super.getDescription() == other.getDescription();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
