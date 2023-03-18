package tuan04.bai02;

import java.util.Objects;

public class Country {
	private String name;
	private String capital;
	private int population;
	private boolean democracy;

	public Country(String name, String capital, int population, boolean democracy) {
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.democracy = democracy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public String getCapital() {
		return capital;
	}

	public int getPopulation() {
		return population;
	}

	public boolean isDemocracy() {
		return democracy;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setDemocracy(boolean democracy) {
		this.democracy = democracy;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
