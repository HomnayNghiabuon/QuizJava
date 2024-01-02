

import java.time.LocalDate;

public class BaiKiemTra {

	private HocVien hocVien;

	private double diem;

	private LocalDate thoiDiemLamBai;

	private CauHoi cauHoi;

	public BaiKiemTra() {
	}

	public BaiKiemTra(HocVien hocVien, double diem, LocalDate thoiDiemLamBai, CauHoi cauHoi) {
		this.hocVien = hocVien;
		this.diem = diem;
		this.thoiDiemLamBai = thoiDiemLamBai;
		this.cauHoi = cauHoi;
	}

	public void napCauHoi() {

	}

}
