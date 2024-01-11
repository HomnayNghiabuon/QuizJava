import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThongTinDangNhapHocVien {
	private String idHocVien;

	private String tenDangNhap;

	private String matKhau;

	private TrangThaiDangNhap trangThaiDangNhap;
	{
		this.trangThaiDangNhap = TrangThaiDangNhap.INVALID;
	}
	 public ThongTinDangNhapHocVien(){

	 }
	public ThongTinDangNhapHocVien(String idHocVien, String tenDangNhap, String matKhau) {
		this.idHocVien = idHocVien;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public ThongTinDangNhapHocVien(String idHocVien, String tenDangNhap, String matKhau, TrangThaiDangNhap trangThaiDangNhap) {
		this.idHocVien = idHocVien;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.trangThaiDangNhap = TrangThaiDangNhap.INVALID;
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

	private void setTrangThaiDangNhap(TrangThaiDangNhap trangThaiDangNhap) {
		this.trangThaiDangNhap = trangThaiDangNhap;
	}

	public String getIdHocVien() {
		return this.idHocVien;
	}

	private void setIdHocVien(String idHocVien) {
		this.idHocVien = idHocVien;
	}

	public void dangNhap(){
		try {
			FileReader fileReader = new FileReader("src/main/resources/TaiKhoan/ThongTinTaiKhoan.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String data[] = line.split("#");
				if(this.tenDangNhap.equals(data[1])&&this.matKhau.equals(data[2])) {
					setTrangThaiDangNhap(TrangThaiDangNhap.SUCCESS);
					setIdHocVien(data[0]);
					System.out.println("Đăng nhập thành công!");
					return;
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Không hợp lệ!");
	}

}
