public class ThongTinDangNhapHocVien {

	private String tenDangNhap;

	private String matKhau;

	private TrangThaiDangNhap trangThaiDangNhap;

	public ThongTinDangNhapHocVien() {
	}

	public ThongTinDangNhapHocVien(String tenDangNhap, String matKhau, TrangThaiDangNhap trangThaiDangNhap) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThaiDangNhap = trangThaiDangNhap;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public TrangThaiDangNhap getTrangThaiDangNhap() {
		return trangThaiDangNhap;
	}

	public void setTrangThaiDangNhap(TrangThaiDangNhap trangThaiDangNhap) {
		this.trangThaiDangNhap = trangThaiDangNhap;
	}

	public boolean isValid(){
		return true;
	}

	public String idNguoiDung(){
		return "0";
	}

}
