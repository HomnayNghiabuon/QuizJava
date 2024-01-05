import com.intellij.debugger.impl.descriptors.data.LocalData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HocVienFactory {

	public HocVien taoHocVien(String id) {
		try {
			FileReader fileReader = new FileReader("src/main/resources/ThongTinHocVien/ThongTinCaNhan.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.substring(0,7).equals(id)){
					String[] data = line.split("#");
					int i = 1;
					String hoTen = data[i++];
					String diaChi = data[i++];
					LocalDate ngaySinh = LocalDate.parse(data[i++],DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN));
					String gioiTinh = data[i++];
					return new HocVien(id,hoTen,diaChi,ngaySinh,gioiTinh);
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}


}
