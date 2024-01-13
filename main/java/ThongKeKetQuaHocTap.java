import kotlin.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ThongKeKetQuaHocTap {

	private HocVien hocVien;

	private List<Pair<Double, LocalDate>> thongTinNhungBaiKiemTra = new ArrayList<>();

	public ThongKeKetQuaHocTap() {
	}

	public ThongKeKetQuaHocTap(HocVien hocVien) {
		this.hocVien = hocVien;
	}


	public HocVien getHocVien() {
		return hocVien;
	}

	public void setHocVien(HocVien hocVien) {
		this.hocVien = hocVien;
	}

	public List<Pair<Double, LocalDate>> getThongTinNhungBaiKiemTra() {
		return thongTinNhungBaiKiemTra;
	}

	public void setThongTinNhungBaiKiemTra(List<Pair<Double, LocalDate>> thongTinNhungBaiKiemTra) {
		this.thongTinNhungBaiKiemTra = thongTinNhungBaiKiemTra;
	}

	public void thongKeDiem(String thangNam) {
		setThongTinNhungBaiKiemTra(new ArrayList<>());
		this.layThongTinHocTapCuaHocVienTuFile();
		if(this.thongTinNhungBaiKiemTra == null){
			System.out.println("Bạn chưa làm bài kiểm tra nào");
			return;
		}
		double tongDiem = 0, diemTrungBinh = 0;
		int soBai = 0;
		System.out.println("Thống kê:");
		for(Pair<Double, LocalDate> tt:thongTinNhungBaiKiemTra){
			if(tt.getSecond().format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)).substring(3).equals(thangNam)){
				System.out.printf("Lần kiểm tra %s bạn được: %.2f\n", soBai+1, tt.getFirst());
				tongDiem += tt.getFirst();
				soBai++;
			}
		}
		if(soBai > 0){
			diemTrungBinh = tongDiem / soBai;
			System.out.printf("Điểm trung bình của tháng này (%s) là: %.2f\n", thangNam, diemTrungBinh);
		}
		else System.out.println("Tháng này không có bài kiểm tra\n");
	}

	private void layThongTinHocTapCuaHocVienTuFile(){
		try {
			FileReader fileReader = new FileReader("src/main/resources/ThongTinHocVien/Diem.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int dem = 0;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.contains(this.hocVien.getId())) break;
			}
			String[] data = line.substring(8).split("#");
			for(int i = 0; i < data.length; i++){
				Double diem = Double.valueOf(data[i++]);
				LocalDate thoiDiemLamBai = LocalDate.parse(data[i], DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN));
				this.thongTinNhungBaiKiemTra.add(new Pair<>(diem, thoiDiemLamBai));
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}