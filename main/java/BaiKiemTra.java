
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaiKiemTra {

	private HocVien hocVien;

	private double diem;

	private LocalDate thoiDiemLamBai;

	private List<CauHoi> danhSachCauHoi;

	public BaiKiemTra() {
	}

	public HocVien getHocVien() {
		return hocVien;
	}

	public void setHocVien(HocVien hocVien) {
		this.hocVien = hocVien;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public LocalDate getThoiDiemLamBai() {
		return thoiDiemLamBai;
	}

	public void setThoiDiemLamBai(LocalDate thoiDiemLamBai) {
		this.thoiDiemLamBai = thoiDiemLamBai;
	}

	public List<CauHoi> getDanhSachCauHoi() {
		return danhSachCauHoi;
	}

	public void setDanhSachCauHoi(List<CauHoi> cauHoi) {
		this.danhSachCauHoi = cauHoi;
	}

	public BaiKiemTra(HocVien hocVien, double diem, LocalDate thoiDiemLamBai, List<CauHoi> cauHoi) {
		this.hocVien = hocVien;
		this.diem = diem;
		this.thoiDiemLamBai = thoiDiemLamBai;
		this.danhSachCauHoi = cauHoi;
	}
	
	private List<StringBuilder> docThongTinTuFile(String path){
		List<StringBuilder> stringBuilders = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilders.add(new StringBuilder(line));
			}
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return stringBuilders;
	}
	public void ghiCacCauHoiDaLamVaoFile(List<CauHoi> cacCauHoi) {
		String path ="src/main/resources/CauHoiDaLam/CauHoiDaLam.txt";
        String data = "";
		List<StringBuilder> stringBuilders = docThongTinTuFile(path);
        for (StringBuilder stringBuilder: stringBuilders) {
            if (stringBuilder.toString().substring(0, 7).equals(this.hocVien.getId())) {
                for (CauHoi cauHoi: cacCauHoi){
					if(cauHoi instanceof MultipleChoice){
					 	stringBuilder.append("#").append(cauHoi.getId());
					}
				}
				break;
            }
        }
		CauHinh.ghiFile(path,stringBuilders);
    }
	private void ghiBaiDaLamVaoFile(){
		String path ="src/main/resources/CauHoiDaLam/CauHoiDaLam.txt";
		List<StringBuilder> stringBuilders = CauHinh.layDuLieuTuFile(path);
		for (StringBuilder stringBuilder: stringBuilders) {
			if (stringBuilder.toString().substring(0, 7).equals(this.hocVien.getId())) {
				stringBuilder.append("#").append(this.diem).append("#")
						.append(this.thoiDiemLamBai.format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
				break;
			}
		}
		CauHinh.ghiFile(path,stringBuilders);
	}
	private void napCauHoiMultipleChoice(int soCauHoi){
		CauHoiTracNghiem.setDem(1);
		TaoCauHoiMultipleChoice multipleChoiseFactory=new MultipleChoiseFactory();
		List<CauHoi> danhSachCauHoi = new ArrayList<>();
		danhSachCauHoi=multipleChoiseFactory.taoCacCauHoiTuFile(this.hocVien.getId(), soCauHoi);
        this.setDanhSachCauHoi(danhSachCauHoi);
		ghiCacCauHoiDaLamVaoFile(danhSachCauHoi);
	}
	private void napCauHoiConversation(MucDo mucDo){
		CauHoiTracNghiem.setDem(1);
		TaoCauHoiDoanVan conversationFactory = new ConversationFactory();
		CauHoi cauHoi = conversationFactory.taoCauHoiTuFile(mucDo);
		List<CauHoi> danhSachCauHoi=new ArrayList<>();
		danhSachCauHoi.add(cauHoi);
		setDanhSachCauHoi(danhSachCauHoi);
	}
	private void napCauHoiIncomple(MucDo mucDo){
		CauHoiTracNghiem.setDem(1);
		TaoCauHoiDoanVan incompleFactoryFactory = new IncompleFactory();
		CauHoi cauHoi = incompleFactoryFactory.taoCauHoiTuFile(mucDo);
		List<CauHoi> danhSachCauHoi=new ArrayList<>();
		danhSachCauHoi.add(cauHoi);
		setDanhSachCauHoi(danhSachCauHoi);
	}
	private void hienThiDapAnDung(boolean[] list){
		if(this.danhSachCauHoi.size() == 1){
			if(this.danhSachCauHoi.get(0) instanceof Incomple){
				CauHoiTracNghiem.setDem(1);
				for(int i = 0; i < ((Incomple) this.danhSachCauHoi.get(0)).getDanhSachCauHoi().size(); i++) {
					System.out.print(((CauHoiTracNghiem) ((Incomple) this.danhSachCauHoi.get(0)).getDanhSachCauHoi().get(i)).toString());
					System.out.println(list[i] == true ? "Đúng!" : "Sai!");
					((CauHoiTracNghiem) ((Incomple) this.danhSachCauHoi.get(0)).getDanhSachCauHoi().get(i)).hienThiDapAnDung();
				}

			}
			if(this.danhSachCauHoi.get(0) instanceof Conversation){
				MultipleChoice.setDem(1);
				for(int i = 0; i < ((Conversation) this.danhSachCauHoi.get(0)).getDanhSachCauHoi().size(); i++) {
					System.out.print(((MultipleChoice) ((Conversation) this.danhSachCauHoi.get(0)).getDanhSachCauHoi().get(i)).toString());
					System.out.println(list[i] == true ? "Đúng!" : "Sai!");
					((MultipleChoice) ((Conversation) this.danhSachCauHoi.get(0)).getDanhSachCauHoi().get(i)).hienThiDapAnDung();
				}
			}
		}
		else {
			MultipleChoice.setDem(1);
				for(int i = 0; i < this.danhSachCauHoi.size(); i++) {
					System.out.print(((MultipleChoice) this.danhSachCauHoi.get(i)).toString());
					System.out.println(list[i] == true ? "Đúng!" : "Sai!");
					((MultipleChoice) this.danhSachCauHoi.get(i)).hienThiDapAnDung();
				}
		}
	}
	private int chonDapAn(CauHoi cauHoi){
		char luaChon;
		while (true){
			String temp;
			System.out.print("Nhập câu trả lời: ");
			temp = CauHinh.scanner.nextLine();
			if(!(cauHoi instanceof CauHoiTracNghiem)) throw new IllegalArgumentException("Đối tượng cauHoi không phải là CauHoiTracNghiem");
			if(temp.length()>1 || !Character.isLetter(temp.charAt(0)) || (temp.toUpperCase().charAt(0)-65) >= ((CauHoiTracNghiem)cauHoi).cacPhuongAn.size()){
				System.out.println("Nhập sai, lại!");
				continue;
			}
			luaChon = temp.toUpperCase().charAt(0);
			break;
		}
		return luaChon - 65;
	}
	private boolean chamDiem(CauHoi cauHoi, int luaChon){
		int soCauHoi = 0;
		if(this.danhSachCauHoi.size() == 1){
			if(this.danhSachCauHoi.get(0) instanceof Conversation
					|| this.danhSachCauHoi.get(0) instanceof Incomple){
				soCauHoi = ((CauHoiDoanVan) this.danhSachCauHoi.get(0)).getDanhSachCauHoi().size();
			}
		}
		else{
			soCauHoi = this.danhSachCauHoi.size();
		}
		double diemCuaMotCauHoi = 0.0;
		if(soCauHoi != 0)  diemCuaMotCauHoi= 10.0 / soCauHoi;
		if(((CauHoiTracNghiem)cauHoi).getCacPhuongAn().get(luaChon).isChinhXac()) {
			this.diem += diemCuaMotCauHoi;
			return true;
		}
		return false;
	}
	private void lamBaiCauHoiTracNghiem(boolean[] list, int index, CauHoi cauHoiTracNghiem){
			System.out.println(cauHoiTracNghiem.toString());
			int luaChon = chonDapAn(cauHoiTracNghiem);
			if (chamDiem(cauHoiTracNghiem, luaChon) == true) list[index] = true;
			else list[index] = false;
	}

	private void lamBaiCauHoiDoanVan(boolean[] list, CauHoi cauHoiDoanVan){
		int i = 0, n = ((CauHoiDoanVan)cauHoiDoanVan).getDanhSachCauHoi().size();
		List<Integer> cacCauHoiDaLam = new ArrayList<>();
		String temp;
		int soThuTuCuaCau=1;
		while (i < n){
			System.out.print("Chọn câu để làm: ");
			temp = CauHinh.scanner.nextLine();
			try {
				soThuTuCuaCau = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				System.out.println("Lỗi chuyển đổi: Chuỗi không hợp lệ để chuyển đổi thành số.");
				continue;
			};
			if(soThuTuCuaCau > n || soThuTuCuaCau < 1){
				System.out.println("Nhập sai, nhập lại!");
				continue;
			}
			if (cacCauHoiDaLam.contains(soThuTuCuaCau)){
				System.out.println("Câu này đã làm rồi");
				continue;
			}
			CauHoi cauHoiTracNghiem = ((CauHoiDoanVan)cauHoiDoanVan).getDanhSachCauHoi().get(soThuTuCuaCau-1);
			((CauHoiTracNghiem)cauHoiTracNghiem).setDem(soThuTuCuaCau);
			lamBaiCauHoiTracNghiem(list, soThuTuCuaCau-1, cauHoiTracNghiem);
			cacCauHoiDaLam.add(soThuTuCuaCau);
			i++;
		}
	}
	private void luuKetQuaVaoFile(){
		String diem = Double.toString(this.diem);
		String ngayHienTai = LocalDate.now().format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN));
		String path = "src/main/resources/ThongTinHocVien/Diem.txt";
		List<StringBuilder> stringBuilders = CauHinh.layDuLieuTuFile(path);
		for (StringBuilder stringBuilder: stringBuilders) {
			if (stringBuilder.toString().substring(0, 7).equals(this.hocVien.getId())) {
				stringBuilder.append("#").append(this.diem).append("#")
						.append(this.thoiDiemLamBai.format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
				break;
			}
		}
		CauHinh.ghiFile(path, stringBuilders);
	}
	public void batDauLamBai(){
		System.out.println("=====CHỌN DẠNG CÂU HỎI=====");
		System.out.println("1.Multiple Choice");
		System.out.println("2.Incomple");
		System.out.println("3.Conversation");
		System.out.print("Nhập lựa chọn: ");
		int luachon,luachon2;
		boolean[] list = new boolean[1000];
		this.setDiem(0);
		do {
			luachon= Integer.parseInt(CauHinh.scanner.nextLine());
			switch (luachon) {
				case 1:
					System.out.print("Nhập số lượng câu hỏi: ");
					int soCauhoi = Integer.parseInt(CauHinh.scanner.nextLine());
					napCauHoiMultipleChoice(soCauhoi);
					this.thoiDiemLamBai = LocalDate.now();
					for(int i=0; i < this.danhSachCauHoi.size(); i++){
						lamBaiCauHoiTracNghiem(list, i, this.danhSachCauHoi.get(i));
					}
					break;
				case 2:
					System.out.println("Chọn mức độ: ");
					System.out.println("1.Dễ");
					System.out.println("2.Trung Bình");
					System.out.println("3.Khó");
					while(true){
						luachon2 = Integer.parseInt(CauHinh.scanner.nextLine());
						if(luachon2 < 1 || luachon2 > 3) {
							System.out.println("Lựa chọn không hợp lệ!!");
							continue;
						}
						napCauHoiIncomple(MucDo.values()[luachon2-1]);
						this.thoiDiemLamBai = LocalDate.now();
						break;
					}
					CauHoi incompe = this.danhSachCauHoi.get(0);
					System.out.println(incompe.toString());
					lamBaiCauHoiDoanVan(list, incompe);
					break;
				case 3:
					System.out.println("Chọn mức độ: ");
					System.out.println("1.Dễ");
					System.out.println("2.Trung Bình");
					System.out.println("3.Khó");
					while(true){
						luachon2 = Integer.parseInt(CauHinh.scanner.nextLine());
						if(luachon2 < 1 || luachon2 > 3) {
							System.out.println("Lựa chọn không hợp lệ!!");
							continue;
						}
						napCauHoiConversation(MucDo.values()[luachon2-1]);
						this.thoiDiemLamBai = LocalDate.now();
						break;
					}
					CauHoi conversation = this.danhSachCauHoi.get(0);
					System.out.println(conversation.toString());
					lamBaiCauHoiDoanVan(list, conversation);
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ");
					break;
			}
		}while (luachon < 1 || luachon > 3);
		System.out.println();
		hienThiDapAnDung(list);
		luuKetQuaVaoFile();
	}
}
