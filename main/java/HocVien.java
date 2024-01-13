import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HocVien {

	private String id;

	private String hoTen;

	private String diaChi;

	private LocalDate ngaySinh;

	private String gioiTinh;
	private LocalDate ngayGiaNhap;

	public HocVien() {
	}

	public HocVien(String id, String hoTen, String diaChi, LocalDate ngaySinh, String gioiTinh) {
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}

	public HocVien(String id, String hoTen, String diaChi, LocalDate ngaySinh, String gioiTinh, LocalDate ngayGiaNhap) {
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.ngayGiaNhap = ngayGiaNhap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgayGiaNhap() {
		return ngayGiaNhap;
	}

	public void setNgayGiaNhap(LocalDate ngayGiaNhap) {
		this.ngayGiaNhap = ngayGiaNhap;
	}

	@Override
	public String toString() {
		return String.format("Id: %s\nHọ tên: %s\n" +
						"Địa chỉ: %s\nNgày sinh: %s\nGiới tính: %s\nNgày gia nhập: %s",
				this.id, this.hoTen, this.diaChi, this.ngaySinh.format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)),
				this.gioiTinh, this.ngayGiaNhap.format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
	}
}
