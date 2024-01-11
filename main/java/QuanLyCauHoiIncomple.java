import java.util.stream.Collectors;

public class QuanLyCauHoiIncomple extends QuanLyCauHoi{
    public QuanLyCauHoiIncomple() {
    }

    @Override
    public void xemDanhSachCauHoi() {
        this.danhSachCauHoi.stream().filter(incomple -> incomple instanceof Incomple)
                .forEach(incomple-> System.out.println(incomple.toString()));
    }

    public void timCauHoi(String noiDungDoanVan){
        this.danhSachCauHoi.stream().filter(incomple -> incomple instanceof Incomple)
                .filter(incomple -> ((Incomple)incomple).getDoanVan().getNoiDung()
                        .contains(noiDungDoanVan)).forEach(incomple -> System.out.println(incomple.toString()));
    }

    public void timCauHoi(MucDo mucDo){
        this.danhSachCauHoi.stream().filter(incomple -> incomple instanceof Incomple)
                .filter(incomple -> incomple.getMucDo() == mucDo)
                .forEach(incomple -> System.out.println(incomple .toString()));
    }

}
