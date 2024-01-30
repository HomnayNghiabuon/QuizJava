import java.util.List;
import java.util.stream.Collectors;

public class TraCuuHocVienTheoQueQuan implements TraCuuHocVienStrategy {
    @Override
    public List<HocVien> traCuuHocVienTheoThongTin(List<HocVien> danhSachHocVien, Object thongTin) {
        if(thongTin.getClass() != String.class) return null;
        return danhSachHocVien.stream().filter(hocVien -> hocVien.getDiaChi().contains((String)thongTin)).collect(Collectors.toList());
    }
}
