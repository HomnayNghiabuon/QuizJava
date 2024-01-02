import java.util.List;

public class Tester {
    public static void main(String[] args) {
        MultipleChoiseFactory multipleChoiseFactory = new MultipleChoiseFactory();
        List<CauHoi> cacCauGoi = multipleChoiseFactory.taoCacCauHoiTuFile("hv00001", 3);
        for (CauHoi cauHoi:cacCauGoi){
            System.out.println(cauHoi.getId());
            System.out.println(cauHoi.getMucDo());
            System.out.println(((MultipleChoice)cauHoi).getNoiDungCauHoi());
        }
    }
}
