package bai01;

import java.util.ArrayList;
import java.util.List;

public class PhongBan {
	private List<NhanVien> ls;

	private String maPhongBan;
	private String tenPhongBan;

	public PhongBan(String ma, String ten) {
		ls = new ArrayList<NhanVien>();
		this.maPhongBan = ma;
		this.tenPhongBan = ten;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public List<NhanVien> getLs() {
		return ls;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setLs(List<NhanVien> ls) {
		this.ls = ls;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
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
