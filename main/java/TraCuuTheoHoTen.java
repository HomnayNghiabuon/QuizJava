
import kotlin.Pair;

import java.util.ArrayList;
import java.util.List;

public class TraCuuTheoHoTen implements TraCuHocVienStrategy {

	public List<HocVien> traCuuHocVien(Object thongTin) {
		if(!(thongTin instanceof String)) return null;
		List<HocVien> danhSachHocVien = new ArrayList<>();
		return danhSachHocVien;
	}

}
