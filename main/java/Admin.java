public class Admin extends NguoiDung {

	private QuanLyHocVien quanLyNguoiHoc;

	private QuanLyCauHoi quanLyCauHoi;

	public Admin(QuanLyHocVien quanLyNguoiHoc, QuanLyCauHoi quanLyCauHoi) {
		super();
		this.quanLyNguoiHoc = quanLyNguoiHoc;
		this.quanLyCauHoi = quanLyCauHoi;
	}

	public QuanLyHocVien getQuanLyNguoiHoc() {
		return quanLyNguoiHoc;
	}

	public void setQuanLyNguoiHoc(QuanLyHocVien quanLyNguoiHoc) {
		this.quanLyNguoiHoc = quanLyNguoiHoc;
	}

	public QuanLyCauHoi getQuanLyCauHoi() {
		return quanLyCauHoi;
	}

	public void setQuanLyCauHoi(QuanLyCauHoi quanLyCauHoi) {
		this.quanLyCauHoi = quanLyCauHoi;
	}

	public String toString() {
		return null;
	}

}
