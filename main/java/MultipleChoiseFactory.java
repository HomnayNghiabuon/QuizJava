import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MultipleChoiseFactory  {

	public String[] cacCauHoiDaLam(String idHocVien){
		try {
			FileReader fileReader = new FileReader("E:\\JavaCode\\BTLon\\src\\main\\resources\\CauHoiDaLam\\CauHoiDaLam.txt");
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
	public List<CauHoi> taoCacCauHoiTuFile(String idHocVien, int soCauHoi){
		List<CauHoi> cacCauHoi = new ArrayList<>();
		String[] cacCauHoiDaLam = cacCauHoiDaLam(idHocVien);
		try {
			FileReader fileReader = new FileReader("E:\\JavaCode\\BTLon\\src\\main\\resources\\CauHoi\\MultipleChoise\\CauHoi.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null && soCauHoi > 0) {
				String idCauHoi = line.substring(0,4);
				boolean tonTai = Arrays.stream(cacCauHoiDaLam).anyMatch(s -> s.equals(idCauHoi));
				if(!tonTai){
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
					soCauHoi--;
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(soCauHoi>0) System.out.printf("Chỉ còn %d câu hỏi chưa làm", cacCauHoi.size());
		return cacCauHoi;
	}

}
