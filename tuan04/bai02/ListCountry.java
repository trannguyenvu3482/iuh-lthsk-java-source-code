package tuan04_bai02;

import java.util.ArrayList;
import java.util.List;

public class ListCountry {
	List<Country> ls;

	public ListCountry() {
		ls = new ArrayList<Country>();
	}

	public List<Country> getLs() {
		return ls;
	}

	public void setLs(List<Country> ls) {
		this.ls = ls;
	}

	public void themCountry(Country c) throws Exception {
		if (!ls.contains(c)) {
			ls.add(c);
		} else
			throw new Exception("Quốc gia đã tồn tại");
	}

	public void xoaCountry(Country c) throws Exception {
		if (!ls.remove(c)) {
			throw new Exception("Quốc gia không tồn tại");
		}
	}

	public Country findCountry(String name) {
		for (Country country : ls) {
			if (country.getName().equals(name)) {
				return country;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
