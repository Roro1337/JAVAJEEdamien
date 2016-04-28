package dd.main;

import java.util.logging.Logger;

import dd.beans.Deve;
import dd.beans.Develop;
import dd.beans.SocieteDev;
import dd.metier.Developpeur;
import dd.metier.SocieteDevLogiciel;

public class MainSpring {

	public static void main(String[] args) {
		MainSpring m = new MainSpring();
		// m.init();
		m.initSans();

	}

	public void init() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		SocieteDevLogiciel societe = new SocieteDevLogiciel();
		Developpeur olivier = new Developpeur();
		olivier.setNom("Olivier");
		olivier.setAnneesExperience(7);
		Developpeur marc = new Developpeur();
		marc.setNom("Marc");
		marc.setAnneesExperience(10);
		societe.setChefDeveloppeur(marc);
		societe.setDeveloppeur(olivier);

		// récupération d'un bean
		// utilisation du bean avec injection du dépendance
		logger.info("Chef develloppeur: " + societe.getChefDeveloppeur().getNom());
		logger.info("develloppeur: " + societe.getDeveloppeur().getNom());
	}

	public void initSans() {
		Logger logger = Logger.getLogger(this.getClass().getName());
		Deve societe = new SocieteDev();
		Develop olivier = new Develop("Olivier", 7);
		Develop marc = new Develop("Marc", 10);
		societe.chefDevelop("Marc", 10);
		societe.develop("Olivier", 7);
	}

}
