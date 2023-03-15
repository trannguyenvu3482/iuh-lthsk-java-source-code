package tuan02_bai01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachNhanVien implements Serializable {
	List<NhanVien> ls;

	public DanhSachNhanVien() {
		ls = new ArrayList<NhanVien>();
	}

	public boolean themNhanVien(NhanVien nv) {
		if (!ls.contains(nv)) {
			return ls.add(nv);
		} else {
			return false;
		}
	}

	public boolean xoaNhanVien(int index) {
		return ls.remove(index) != null;
	}

	public int countNV() {
		return ls.size();
	}

	public int timNhanVien(String maNV) {
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getMaNV().equals(maNV)) {
				return i;
			}
		}

		return -1;
	}
}
