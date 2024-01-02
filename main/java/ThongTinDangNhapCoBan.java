public abstract class ThongTinDangNhapCoBan implements ThongTinDangNhap {

	private String tenDangNhap;

	private String matKhau;

	private TrangThaiDangNhap trangThaiDangNhap;


	public abstract boolean isValid();

	public abstract String idNguoiDung();

}
