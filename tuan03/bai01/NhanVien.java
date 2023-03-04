package bai01;

public class NhanVien {
	private String maNV;
	private String hoNV;
	private String tenSV;
	private String phai;
	private int tuoi;
	private int tienLuong;
	
	public NhanVien(String maNV, String hoNV, String tenSV, String phai, int tuoi, int tienLuong) {
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenSV = tenSV;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}



	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public int getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(int tienLuong) {
		this.tienLuong = tienLuong;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
