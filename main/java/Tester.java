import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tester {
    public static void main(String[] args) {
//        MultipleChoiseFactory multipleChoiseFactory = new MultipleChoiseFactory();
//        List<CauHoi> multipleChoices = multipleChoiseFactory.taoCacCauHoiTuFile("hv00001", 8);
//        for(CauHoi cauHoi: multipleChoices){
//            MultipleChoice multipleChoice = (MultipleChoice)cauHoi;
//            System.out.println(multipleChoice.getId());
//            System.out.println(multipleChoice.getMucDo());
//            System.out.println(multipleChoice.getDanhMuc());
//            System.out.println(multipleChoice.getNoiDungCauHoi());
//            multipleChoice.getCacPhuongAn().forEach(phuongAn -> System.out.println(phuongAn.getNoiDung()));
//
//        }
        IncompleFactory incompleFactory = new IncompleFactory();
        CauHoi cauHoi = incompleFactory.taoCauHoiTuFile(MucDo.DE);
        System.out.println(((Incomple)cauHoi).getDoanVan().getNoiDung());
        ((Incomple)cauHoi).getDanhSachCauHoi().forEach(cauHoiTracNghiem -> {
            System.out.println(cauHoiTracNghiem.getId());
            (((CauHoiTracNghiem)cauHoiTracNghiem).getCacPhuongAn()).forEach(p -> System.out.println(p.getNoiDung()));
        });
    }
}
