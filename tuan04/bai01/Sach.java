package tuan04_bai01;

import java.util.Objects;

public class Sach {
	private String maSach;
	private String tuaSach;
	private String tacGia;
	private int namXB;
	private String nhaXB;
	private int soTrang;
	private double donGia;
	private String ISBN;

	public Sach(String maSach, String tuaSach, String tacGia, int namXB, String nhaXB, int soTrang, double donGia,
			String iSBN) throws Exception {
		setMaSach(maSach);
		setTuaSach(tuaSach);

		setTacGia(tacGia);
		this.namXB = namXB;
		setNhaXB(nhaXB);
		this.soTrang = soTrang;
		this.donGia = donGia;
		setISBN(iSBN);
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	public String getMaSach() {
		return maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public int getNamXB() {
		return namXB;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public double getDonGia() {
		return donGia;
	}

	public String getISBN() {
		return ISBN;
	}

	public boolean containsNumberOrSymbol(String input) {
		for (char character : input.toCharArray()) {
			if (Character.isDigit(character) || (!Character.isLetterOrDigit(character) && character != '\'')) {
				return true;
			}
		}
		return false;
	}

	public void setMaSach(String maSach) throws Exception {
		if (maSach.equals(""))
			throw new Exception("Không được rỗng");

//		if (maSach.substring(0, 0).equals(tuaSach.substring(0, 0))) {
//			try {
//				Integer.parseInt(maSach.substring(1, 3));
//
//				this.maSach = maSach;
//			} catch (Exception e) {
//				throw new Exception("3 ký tự sau phải ở dạng ký số");
//			}
//		} else {
//			throw new Exception("Ký tự đầu tiên của mã sách phải là ký tự đầu của tựa sách");
//		}

		this.maSach = maSach;
	}

	public void setTuaSach(String tuaSach) throws Exception {
//		if (!tuaSach.equals("") && !containsNumberOrSymbol(tuaSach)) {
//			this.tuaSach = tuaSach;
//		} else
//			throw new Exception("Không được rỗng hoặc chứa ký tự đặc biệt (trừ ')");

		if (!tuaSach.equals("")) {
			this.tuaSach = tuaSach;
		} else
			throw new Exception("Không được rỗng hoặc chứa ký tự đặc biệt (trừ ')");
	}

	public void setTacGia(String tacGia) throws Exception {
//		if (!tuaSach.equals("") && !containsNumberOrSymbol(tuaSach)) {
//			this.tacGia = tacGia;
//		} else
//			throw new Exception("Không được rỗng hoặc chứa ký tự đặc biệt (trừ ')");

		if (!tuaSach.equals("")) {
			this.tacGia = tacGia;
		} else
			throw new Exception("Không được rỗng hoặc chứa ký tự đặc biệt (trừ ')");
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public void setISBN(String iSBN) throws Exception {
//		if (iSBN.matches("/^\\d+-\\d+-\\d+-\\d+$/") || iSBN.matches("/^\\d+-\\d+-\\d+-\\d+-\\d+$/")) {
//			this.ISBN = iSBN;
//		} else
//			throw new Exception("ISBN phải có dạng X-X-X-X hoặc X-X-X-X-X, với X là ký số");

		this.ISBN = iSBN;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
