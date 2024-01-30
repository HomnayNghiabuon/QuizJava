import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TraCuuHocVienTheoNgaySinh implements TraCuuHocVienStrategy{
    @Override
    public List<HocVien> traCuuHocVienTheoThongTin(List<HocVien> danhSachHocVien, Object thongTin) {
        if(thongTin.getClass() != String.class) return null;
        return danhSachHocVien.stream().filter(hocVien -> hocVien.getNgaySinh() == (LocalDate) thongTin).collect(Collectors.toList());
    }
}
