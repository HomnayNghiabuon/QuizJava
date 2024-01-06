

import com.github.weisj.jsvg.S;
import org.apache.logging.log4j.util.StringBuilders;

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

	private void ghiFile(String path, List<StringBuilder> stringBuilders) {
		try {
			FileWriter fileWriter = new FileWriter(path);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			StringBuilder noiDungMoi = new StringBuilder();
			for (StringBuilder stringBuilder: stringBuilders){
				noiDungMoi.append(stringBuilder.toString()).append("\n");
			}
			bufferedWriter.write(noiDungMoi.toString());
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
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
		ghiFile(path,stringBuilders);
    }
	private void ghiBaiLamVaoFile(){
		String path ="src/main/resources/CauHoiDaLam/CauHoiDaLam.txt";
		String data = "";
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
		for (StringBuilder stringBuilder: stringBuilders) {
			if (stringBuilder.toString().substring(0, 7).equals(this.hocVien.getId())) {
				stringBuilder.append("#").append(this.diem).append("#")
						.append(this.thoiDiemLamBai.format(DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN)));
				break;
			}
		}
		ghiFile(path,stringBuilders);
	}
	private void napCauHoiConversation(MucDo mucDo){
		ConversationFactory conversationFactory = new ConversationFactory();
		CauHoi cauHoi = conversationFactory.taoCauHoiTuFile(mucDo);
		List<CauHoi> danhSachCauHoi=new ArrayList<>();
		if(cauHoi instanceof Conversation) danhSachCauHoi.add(cauHoi);
		setDanhSachCauHoi(danhSachCauHoi);
		System.out.println(((Conversation)cauHoi).toString());
	}
	private void napCauHoiIncomple(MucDo mucDo){
		IncompleFactory incompleFactoryFactory = new IncompleFactory();
		CauHoi cauHoi = incompleFactoryFactory.taoCauHoiTuFile(mucDo);
		List<CauHoi> danhSachCauHoi=new ArrayList<>();
		if(cauHoi instanceof Incomple) danhSachCauHoi.add(cauHoi);
		setDanhSachCauHoi(danhSachCauHoi);

		System.out.println(((Incomple)cauHoi).getDoanVan().getNoiDung());
		((Incomple)cauHoi).getDanhSachCauHoi().forEach(cauHoiTracNghiem -> {
			System.out.println(cauHoiTracNghiem.getId());
			(((CauHoiTracNghiem)cauHoiTracNghiem).getCacPhuongAn()).forEach(p -> System.out.println(p.getNoiDung()));
		});
	}
	public void napCauHoi(){
		System.out.println("=====CHỌN DẠNG CÂU HỎI=====");
		System.out.println("1.Multiple Choice");
		System.out.println("2.Incomple");
		System.out.println("3.Conversation");
		System.out.print("Nhập lựa chọn: ");
		int luachon,luachon2;
		luachon=CauHinh.scanner.nextInt();
		switch (luachon){
			case 1:
				System.out.println("Nhập số lượng câu hỏi ");
				int soCauhoi=CauHinh.scanner.nextInt();
				MultipleChoiseFactory multipleChoiseFactory=new MultipleChoiseFactory();
				List<CauHoi> danhSachCauHoi = new ArrayList<>();
				danhSachCauHoi=multipleChoiseFactory.taoCacCauHoiTuFile(this.hocVien.getId(),soCauhoi);
				this.setDanhSachCauHoi(danhSachCauHoi);
				ghiCacCauHoiDaLamVaoFile(danhSachCauHoi);
				break;
			case 2:
				System.out.println("Chọn mức độ: ");
				System.out.println("1.Dễ");
				System.out.println("2.Trung Bình");
				System.out.println("3.Khó");
				luachon2=CauHinh.scanner.nextInt();
				switch (luachon2){
					case 1:
						napCauHoiIncomple(MucDo.DE);
						break;
					case 2:
						napCauHoiIncomple(MucDo.TRUNG_BINH);
						break;
					case 3:
						napCauHoiIncomple(MucDo.KHO);
						break;
					default:
						System.out.println("Lựa chọn không hợp lệ!");
				}
				break;
			case 3:
				System.out.println("Chọn mức độ: ");
				System.out.println("1.Dễ");
				System.out.println("2.Trung Bình");
				System.out.println("3.Khó");
				luachon2=CauHinh.scanner.nextInt();
				switch (luachon2){
					case 1:
						napCauHoiConversation(MucDo.DE);
						break;
					case 2:
						napCauHoiConversation(MucDo.TRUNG_BINH);
						break;
					case 3:
						napCauHoiConversation(MucDo.KHO);
						break;
					default:System.out.println("Lựa chọn không hợp lệ!");

				}

		}
	}


}
