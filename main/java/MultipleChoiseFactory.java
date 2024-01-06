import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class MultipleChoiseFactory  {

	private String[] cacCauHoiDaLam(String idHocVien){
		try {
			FileReader fileReader = new FileReader("src/main/resources/CauHoiDaLam/CauHoiDaLam.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String id = line.substring(0,7);
				if(idHocVien.equals(id)) {
					String[] data = line.substring(8).split("#"); // Tách dữ liệu theo dấu #
					return data;
				}
			}

			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}
	private Set<Integer> randomSetWithoutArrayElements(int n, String[] a) {
		if ((n + a.length) > CauHinh.SO_CAU_HOI_MULTIPLE_CHOICE) {
			throw new IllegalArgumentException("Ngân hàng câu hỏi không đủ dữ liệu!");
		}
		Set<Integer> resultSet = new TreeSet<>();
		while (resultSet.size() < n) {
			int randomNumber = CauHinh.random(1,CauHinh.SO_CAU_HOI_MULTIPLE_CHOICE); // Sinh số ngẫu nhiên

			// Kiểm tra xem số ngẫu nhiên đã sinh có trong mảng a[] không
			boolean containsInArray = false;
			for (String s : a) {
				int num = Integer.parseInt(s);
				if (num == randomNumber) {
					containsInArray = true;
					break;
				}
			}

			// Nếu số ngẫu nhiên không có trong mảng a[], thêm vào set
			if (!containsInArray) {
				resultSet.add(randomNumber);
			}
		}
		return resultSet;
	}
	public List<CauHoi> taoCacCauHoiTuFile(String idHocVien, int soCauHoi){
		if(soCauHoi<1) return null;
		List<CauHoi> cacCauHoi = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader("src/main/resources/CauHoi/MultipleChoise/CauHoi.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String[] cacCauHoiDaLam = cacCauHoiDaLam(idHocVien);
			Set<Integer> idCacCauHoiCanDoc = randomSetWithoutArrayElements(soCauHoi, cacCauHoiDaLam);
			String line;
			int dem = 0;
			while ((line = bufferedReader.readLine()) != null) {
				String idCauHoi = line.substring(0,4);
				if(idCacCauHoiCanDoc.stream().anyMatch(s -> s.equals(Integer.parseInt(idCauHoi)))){
					dem++;
					String[] data = line.substring(5).split("#");
					int i = 0;
					String id = idCauHoi;
					MucDo mucDo = MucDo.valueOf(data[i++]);
					DanhMuc danhMuc = DanhMuc.valueOf(data[i++]);
					List<PhuongAn> cacPhuongAn = new ArrayList<>();
					String noiDungCauHoi = data[i++];
					int viTriPhuongAnDungTrongData = data[data.length-1].charAt(0) - 65 + i;
					while (i<data.length-1){
						cacPhuongAn.add(new PhuongAn(data[i], i == viTriPhuongAnDungTrongData));
						i++;
					}
					CauHoi multipleChoice = new MultipleChoice(id, mucDo, danhMuc, cacPhuongAn, noiDungCauHoi);
					cacCauHoi.add(multipleChoice);
				}
				if(dem == idCacCauHoiCanDoc.size() ) break;
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cacCauHoi;
	}


}
