import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyCauHoiIncomple extends QuanLyCauHoi{
    public QuanLyCauHoiIncomple() {
        this.danhSachCauHoi = this.docTatCaCauHoi();
    }

    @Override
    public void xemDanhSachCauHoi() {
        CauHoiTracNghiem.setDem(1);
        this.danhSachCauHoi.stream().filter(incomple -> incomple instanceof Incomple)
                .forEach(incomple-> System.out.println(incomple.toString()));
    }

    public void timCauHoi(String noiDungDoanVan){
        this.danhSachCauHoi.stream().filter(incomple -> incomple instanceof Incomple)
                .filter(incomple -> ((Incomple)incomple).getDoanVan().getNoiDung().contains(noiDungDoanVan))
                .forEach(incomple -> System.out.println(incomple.toString()));
    }

    public void timCauHoi(MucDo mucDo){
        this.danhSachCauHoi.stream().filter(incomple -> incomple instanceof Incomple)
                .filter(incomple -> incomple.getMucDo() == mucDo)
                .forEach(incomple -> System.out.println(incomple .toString()));
    }
    public List<CauHoi> docTatCaCauHoi(){
        List<CauHoi> danhSachCauHoi = new ArrayList<>();
        for(MucDo mucDo:MucDo.values()){
            String path = "src/main/resources/CauHoi/Incomple/"+mucDo+"/CauHoi.txt";
            String str = CauHinh.layStringTuFile(path);
            String[] mangThongTinCacCauHoi = str.substring(15).split("ThongTinDoanVan");
            for(String thongTinMotCauHoi:mangThongTinCacCauHoi){
                String[] mangData = thongTinMotCauHoi.strip().split("ThongTinCacCauHoi");
                String thongTinDoanVan = mangData[0];
                String thongTinCacCauHoi = mangData[1];
                String[] mangThongTinDoanVan = thongTinDoanVan.split("#");
                int i = 0;
                String idCauHoiDoanVan = mangThongTinDoanVan[i++];
                MucDo mucDoCauHoiDoanVan = MucDo.valueOf(mangThongTinDoanVan[i++]);
                DoanVan doanVan = new DoanVan(mangThongTinDoanVan[i++]);
                List<CauHoi> danhSachCauHoiTracNghiem = new ArrayList<>();
                for(String thongtin:thongTinCacCauHoi.split("&")){
                    String[] mangThongTin = thongtin.split("#");
                    int j = 0;
                    String idCauHoi = mangThongTin[j++];
                    MucDo mucDoCauHoi = MucDo.valueOf(mangThongTin[j++]);
                    DanhMuc danhMucCauHoi = DanhMuc.valueOf(mangThongTin[j++]);
                    List<PhuongAn> cacPhuongAn = new ArrayList<>();
                    int viTriPhuongAnDungTrongData = mangThongTin[mangThongTin.length-1].charAt(0) - 65 + j;
                    while (j<mangThongTin.length-1){
                        cacPhuongAn.add(new PhuongAn(mangThongTin[j], j == viTriPhuongAnDungTrongData));
                        j++;
                    }
                    danhSachCauHoiTracNghiem.add(new CauHoiTracNghiem(idCauHoi, mucDoCauHoi, danhMucCauHoi, cacPhuongAn));
                }
                danhSachCauHoi.add(new Incomple(idCauHoiDoanVan, mucDo, doanVan, danhSachCauHoiTracNghiem));
            }
        }
        return danhSachCauHoi;
    }
}
