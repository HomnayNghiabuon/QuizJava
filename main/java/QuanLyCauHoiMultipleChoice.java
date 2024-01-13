import java.util.ArrayList;
import java.util.List;

public class QuanLyCauHoiMultipleChoice extends QuanLyCauHoi{

    public QuanLyCauHoiMultipleChoice() {
        this.danhSachCauHoi = this.docTatCaCauHoiTuFile();
    }
    @Override
    public void xemDanhSachCauHoi() {
        CauHoiTracNghiem.setDem(1);
        this.danhSachCauHoi.stream().filter(multipleChoice -> multipleChoice instanceof MultipleChoice)
                .forEach(multipleChoice -> System.out.println(multipleChoice.toString()));
    }

    public void timCauHoi(String noiDung){
        CauHoiTracNghiem.setDem(1);
        this.danhSachCauHoi.stream().filter(multipleChoice -> multipleChoice instanceof MultipleChoice)
                .filter(multipleChoice -> ((MultipleChoice)multipleChoice).getNoiDungCauHoi()
                .contains(noiDung)).forEach(multipleChoice -> System.out.println(multipleChoice.toString()));
    }
    public void timCauHoi(DanhMuc danhMuc){
        CauHoiTracNghiem.setDem(1);
        this.danhSachCauHoi.stream().filter(multipleChoice -> multipleChoice instanceof MultipleChoice)
                .filter(multipleChoice -> ((MultipleChoice)multipleChoice).getDanhMuc() == danhMuc)
                .forEach(multipleChoice -> System.out.println(multipleChoice.toString()));
    }

    public void timCauHoi(MucDo mucDo){
        CauHoiTracNghiem.setDem(1);
        this.danhSachCauHoi.stream().filter(multipleChoice -> multipleChoice instanceof MultipleChoice)
                .filter(multipleChoice -> ((MultipleChoice)multipleChoice).getMucDo() == mucDo)
                .forEach(multipleChoice -> System.out.println(multipleChoice.toString()));
    }
    public List<CauHoi> docTatCaCauHoiTuFile(){
        CauHoiTracNghiem.setDem(1);
        List<CauHoi> danhSachCauHoi = new ArrayList<>();
        List<StringBuilder> stringBuilders = CauHinh.layDuLieuTuFile("src/main/resources/CauHoi/MultipleChoise/CauHoi.txt");
        for(int i = 0; i < stringBuilders.size(); i++){
            String[] data = stringBuilders.get(i).toString().split("#");
            int dem = 0;
            String id = data[dem++];
            MucDo mucDo = MucDo.valueOf(data[dem++]);
            DanhMuc danhMuc = DanhMuc.valueOf(data[dem++]);
            List<PhuongAn> cacPhuongAn = new ArrayList<>();
            String noiDungCauHoi = data[dem++];
            int viTriPhuongAnDungTrongData = data[data.length-1].charAt(0) - 65 + dem;
            while (dem<data.length-1){
                cacPhuongAn.add(new PhuongAn(data[dem], dem == viTriPhuongAnDungTrongData));
                dem++;
            }
            danhSachCauHoi.add(new MultipleChoice(id,mucDo,danhMuc,cacPhuongAn,noiDungCauHoi));
        }
        return danhSachCauHoi;
    }
}
