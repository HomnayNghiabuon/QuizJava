import java.util.List;

public class QuanLyHocVien implements CapNhapTaiKhoan, XemDanhSachNguoiHoc, ThemTaiKhoan, XoaTaiKhoan {

	private TraCuNguoiDungStrategy traCuuNguoiHocStragety;

	private static QuanLyHocVien instance;

	public QuanLyHocVien() {

	}

	public List<NguoiDung> traCuuNguoiDung(Object thongTin) {
		return null;
	}

	public void xemDanhSachTaiKhoan() {

	}

	public void themNguoiDung(NguoiDung... a) {

	}

	public void capNhapNguoiDung(NguoiDung... nguoiDung) {

	}

	public void xoaNguoiDung(NguoiDung... a) {

	}

	public NguoiDung traCuuNguoiDungTheoId() {
		return null;
	}

	public NguoiDung docNguoiDungTuFile(String id) {
		return null;
	}

	public List<NguoiDung> docNguoiDungTuFile(String... id) {
		return null;
	}

	public List<NguoiDung> docTatCaNguoiDungTuFile() {
		return null;
	}

	public QuanLyHocVien getInstance() {
		return null;
	}


	/**
	 * @see XemDanhSachNguoiHoc#xemDanhSachNguoiHoc()
	 */
	public void xemDanhSachNguoiHoc() {

	}


	/**
	 * @see XoaTaiKhoan#xoaTaiKhoan(NguoiDung...)
	 */
	public void xoaTaiKhoan(NguoiDung... a) {

	}

}
