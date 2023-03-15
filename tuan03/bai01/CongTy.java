package bai01;

import java.util.ArrayList;
import java.util.List;

public class CongTy {
	private List<PhongBan> lsPhongBan;

	public List<PhongBan> getLsPhongBan() {
		return lsPhongBan;
	}

	public CongTy() {
		lsPhongBan = new ArrayList<PhongBan>();
	}

	public void themPhongBan(String ma, String ten) {
		lsPhongBan.add(new PhongBan(ma, ten));
	}

	public PhongBan findPhongBan(String ten) {
		for (PhongBan phongBan : lsPhongBan) {
			if (phongBan.getTenPhongBan().equalsIgnoreCase(ten)) {
				return phongBan;
			}
		}

		return null;
	}
}
