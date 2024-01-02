import java.util.List;

public class HocVien extends NguoiDung {

	private List<BaiKiemTra> danhSachBaiKiemTra;

	public HocVien() {
	}

	public HocVien(List<BaiKiemTra> danhSachBaiKiemTra) {
		this.danhSachBaiKiemTra = danhSachBaiKiemTra;
	}

	public List<BaiKiemTra> getDanhSachBaiKiemTra() {
		return danhSachBaiKiemTra;
	}

	public void setDanhSachBaiKiemTra(List<BaiKiemTra> danhSachBaiKiemTra) {
		this.danhSachBaiKiemTra = danhSachBaiKiemTra;
	}
}
