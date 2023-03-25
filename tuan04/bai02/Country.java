package tuan04_bai02;

import java.util.Objects;

public class Country {
	private String name;
	private String capital;
	private int population;
	private boolean democracy;

	public Country(String name, String capital, int population, boolean democracy) throws Exception {
		setName(name);
		setCapital(capital);
		setPopulation(population);
		setDemocracy(democracy);
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

	private boolean hasNumberOrSymbols(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isWhitespace(s.charAt(i)))
				continue;

			if (!Character.isLetter(s.charAt(i))) {
				return true;
			}
		}

		return false;
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

	public void setName(String name) throws Exception {
		if (name.equalsIgnoreCase("")) {
			throw new Exception("Tên quốc gia không được phép rỗng");
		} else if (hasNumberOrSymbols(name)) {
			throw new Exception("Tên quốc gia không được chứa ký số hoặc ký tự đặc biệt");
		} else {
			this.name = name;
		}
	}

	public void setCapital(String capital) throws Exception {
		if (capital.equalsIgnoreCase("")) {
			throw new Exception("Tên thủ đô không được phép rỗng");
		} else if (hasNumberOrSymbols(capital)) {
			throw new Exception("Tên thủ đô không được chứa ký số hoặc ký tự đặc biệt");
		} else {
			this.capital = capital;
		}
	}

	public void setPopulation(int population) throws Exception {
		if (population > 0) {
			this.population = population;
		} else
			throw new Exception("Số dân phải lớn hơn 0");
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
