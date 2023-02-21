package bai01;

import java.util.ArrayList;
import java.util.List;

public class DanhSachNhanVien {
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
}
