import kotlin.Pair;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyHocVien implements DangKyHocVien {
	private List<Pair<ThongTinDangNhapHocVien, HocVien>> danhSachThongTinHocVien = new ArrayList<>();

	private TraCuHocVienStrategy traCuuNguoiHocStragety;

	{
		this.docTatCaThongTinHocVienTuFile();
	}
	public QuanLyHocVien() {

	}

	public QuanLyHocVien(TraCuHocVienStrategy traCuuNguoiHocStragety) {
		this.traCuuNguoiHocStragety = traCuuNguoiHocStragety;
	}

	public List<Pair<ThongTinDangNhapHocVien, HocVien>> getDanhSachThongTinHocVien() {
		return danhSachThongTinHocVien;
	}

	public void setDanhSachThongTinHocVien(List<Pair<ThongTinDangNhapHocVien, HocVien>> danhSachThongTinHocVien) {
		this.danhSachThongTinHocVien = danhSachThongTinHocVien;
	}

	public TraCuHocVienStrategy getTraCuuNguoiHocStragety() {
		return traCuuNguoiHocStragety;
	}

	public void setTraCuuNguoiHocStragety(TraCuHocVienStrategy traCuuNguoiHocStragety) {
		this.traCuuNguoiHocStragety = traCuuNguoiHocStragety;
	}

	public List<HocVien> traCuuHocVien(Object thongTin) {
		return null;
	}

	public void xemDanhSachHocVien() {
		//this.docTatCaThongTinHocVienTuFile();
		this.danhSachThongTinHocVien.forEach(tt -> {
			System.out.println("=========================");
			System.out.println(tt.getSecond().toString());
			System.out.println("=========================");
		});
	}

	public void themHocVien() {
		Pair<StringBuilder, StringBuilder> stringBuilderPair = thongTinCuaDangKyHocVienMoi(null);
		String[] temp1 = stringBuilderPair.getFirst().toString().split("#");
		String[] temp2 = stringBuilderPair.getSecond().toString().split("#");
		int dem1 = 0, dem2 =0;
		ThongTinDangNhapHocVien thongTinDangNhapHocVien =
				new ThongTinDangNhapHocVien(temp1[dem1++], temp1[dem1++], temp1[dem1]);
		HocVien hocVien = new HocVien(temp2[dem2++], temp2[dem2++], temp2[dem2++],
				LocalDate.parse(temp2[dem2++], DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)),
				temp2[dem2++], LocalDate.parse(temp2[dem2++], DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
		this.danhSachThongTinHocVien.add(new Pair<>(thongTinDangNhapHocVien, hocVien));
		luuThongTinVaoFile();
		CauHinh.themDongMoiVaoFile("src/main/resources/ThongTinHocVien/Diem.txt", temp2[0]);
		CauHinh.themDongMoiVaoFile("src/main/resources/CauHoiDaLam/CauHoiDaLam.txt", temp2[0]);
	}

	public void capNhapHocVien(String id)  {
		Pair<StringBuilder, StringBuilder> stringBuilderPair = thongTinCuaDangKyHocVienMoi(id);
		String[] temp1 = stringBuilderPair.getFirst().toString().split("#");
		String[] temp2 = stringBuilderPair.getSecond().toString().split("#");
		int dem1 = 0, dem2 =0;
		ThongTinDangNhapHocVien thongTinDangNhapHocVien =
				new ThongTinDangNhapHocVien(temp1[dem1++], temp1[dem1++], temp1[dem1]);
		HocVien hocVien = new HocVien(temp2[dem2++], temp2[dem2++], temp2[dem2++],
				LocalDate.parse(temp2[dem2++], DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)),
				temp2[dem2++], LocalDate.parse(temp2[dem2++], DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
		int index = 0;
		for(int i = 0; i < this.danhSachThongTinHocVien.size(); i++){
			if(this.danhSachThongTinHocVien.get(i).getSecond().getId().contains(id)) index = i;
		}
		this.danhSachThongTinHocVien.set(index,new Pair<>(thongTinDangNhapHocVien, hocVien));
		luuThongTinVaoFile();
	}

	public void xoaHocVien(String id) {
		this.danhSachThongTinHocVien.removeIf(tt -> tt.getSecond().getId().equals(id));
		luuThongTinVaoFile();
	}

	public HocVien traCuuHocVienTheoId(String id) {
		return this.danhSachThongTinHocVien.stream().filter(tt -> tt.getSecond().equals(id)).findFirst().get().getSecond();
	}
	public void docTatCaThongTinHocVienTuFile() {
		String path1 = "src/main/resources/TaiKhoan/ThongTinTaiKhoan.txt",
				path2 = "src/main/resources/ThongTinHocVien/ThongTinCaNhan.txt";
		List<String> data1 = new ArrayList<>(),
				data2 = new ArrayList<>();
		try {
			data1 = Files.readAllLines(Paths.get(path1));
			data2 = Files.readAllLines(Paths.get(path2));
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
		int n = Math.min(data1.size(), data2.size());
		for(int i = 0; i < n; i++){
			int dem1 = 0, dem2 = 0;
			if(data1.get(i).strip().isEmpty() || data2.get(i).strip().isEmpty()) continue;
			String[] temp1 =  data1.get(i).split("#");
			String[] temp2 =  data2.get(i).split("#");
			ThongTinDangNhapHocVien thongTinDangNhapHocVien =
					new ThongTinDangNhapHocVien(temp1[dem1++], temp1[dem1++], temp1[dem1++], TrangThaiDangNhap.SUCCESS);;
			HocVien hocVien =
					new HocVien(temp2[dem2++], temp2[dem2++], temp2[dem2++],
							LocalDate.parse(temp2[dem2++], DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)),
							temp2[dem2++], LocalDate.parse(temp2[dem2++], DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
			this.danhSachThongTinHocVien.add(new Pair<>(thongTinDangNhapHocVien, hocVien));
		}
	}



	public Pair<StringBuilder, StringBuilder> thongTinCuaDangKyHocVienMoi(String id){
		StringBuilder stringBuilder1 = new StringBuilder(),
				stringBuilder2 = new StringBuilder();
		if(id == null) id = String.valueOf(String.format("hv%05d", CauHinh.ID_HOC_VIEN_CUOI + 1));
		int index = Integer.valueOf(id.substring(2)) - 1;
		String name;
		String queQuan;
		String gioiTinh;
		String ngaySinh;
		String ngayGianhap;
		if(index < this.danhSachThongTinHocVien.size()) ngayGianhap= this.danhSachThongTinHocVien.get(index).getSecond()
				.getNgayGiaNhap().format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN));
		else ngayGianhap = LocalDate.now().format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN));
		System.out.print("Nhập họ và tên: ");
		name = CauHinh.scanner.nextLine();
		System.out.print("Nhập quê quán: ");
		queQuan = CauHinh.scanner.nextLine();
		System.out.print("Nhập giới tính:");
		gioiTinh = CauHinh.scanner.nextLine();
		System.out.print("Nhập ngày sinh(dd/mm/yyyy): ");
		ngaySinh = CauHinh.scanner.nextLine();
		// Ghi thông tin vào file
		stringBuilder1 = new StringBuilder(id + "#" + name + "#" + queQuan + "#" +
				ngaySinh + "#" + gioiTinh + "#" + ngayGianhap );
		String username;
		String matKhau;
		System.out.print("Tạo username: ");
		username = CauHinh.scanner.nextLine();
		System.out.print("Tạo mật khẩu: ");
		matKhau = CauHinh.scanner.nextLine();
		stringBuilder2 = new StringBuilder(id+"#"+username+"#"+matKhau);
		return new Pair<StringBuilder, StringBuilder>(stringBuilder2, stringBuilder1);
	}
	private void luuThongTinVaoFile(){
		String path1 = "src/main/resources/TaiKhoan/ThongTinTaiKhoan.txt";
		String path2 = "src/main/resources/ThongTinHocVien/ThongTinCaNhan.txt";
		List<StringBuilder> stringBuilders1 = new ArrayList<>(),
				stringBuilders2 = new ArrayList<>();
		for(int i = 0; i < this.danhSachThongTinHocVien.size(); i++){
			ThongTinDangNhapHocVien thongTinDangNhapHocVien = this.danhSachThongTinHocVien.get(i).getFirst();
			HocVien hocVien = this.danhSachThongTinHocVien.get(i).getSecond();
			StringBuilder stringBuilder1 = new StringBuilder(),
					stringBuilder2 = new StringBuilder();
			stringBuilder1.append(thongTinDangNhapHocVien.getIdHocVien()).append("#")
					.append(thongTinDangNhapHocVien.getTenDangNhap()).append("#")
					.append(thongTinDangNhapHocVien.getMatKhau());
			stringBuilder2.append(hocVien.getId()).append("#")
					.append(hocVien.getHoTen()).append("#")
					.append(hocVien.getDiaChi()).append("#")
					.append(hocVien.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)))
					.append("#")
					.append(hocVien.getGioiTinh()).append("#")
					.append(hocVien.getNgayGiaNhap().format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
			stringBuilders1.add(stringBuilder1);
			stringBuilders2.add(stringBuilder2);
		}
		CauHinh.ghiFile(path1, stringBuilders1);
		CauHinh.ghiFile(path2, stringBuilders2);
	}
}
