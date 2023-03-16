package tuan04_bai01;

import java.util.ArrayList;
import java.util.List;

public class ListSach {
	private List<Sach> ls;

	public ListSach() {
		ls = new ArrayList<Sach>();
	}

	public List<Sach> getLs() {
		return ls;
	}

	public void setLs(List<Sach> ls) {
		this.ls = ls;
	}

	public boolean themSach(Sach s) {
		try {
			if (!ls.contains(s)) {
				return ls.add(s);
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean xoaSach(Sach s) {
		try {
			if (ls.contains(s)) {
				return ls.remove(s);
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public Sach timSach(String maSach) {
		for (Sach sach : ls) {
			if (sach.getMaSach().equals(maSach)) {
				return sach;
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
