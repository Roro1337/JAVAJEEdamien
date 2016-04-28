package dd.beans;

public class Develop {

	private String name;
	private int anneesExperience;

	public Develop(String nom, int anneesExperience) {
		this.name = nom;
		this.anneesExperience = anneesExperience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnneesExperience() {
		return anneesExperience;
	}

	public void setAnneesExperience(int anneesExperience) {
		this.anneesExperience = anneesExperience;
	}

}
