import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tester {
    public static void main(String[] args) {
//        MultipleChoiseFactory multipleChoiseFactory = new MultipleChoiseFactory();
//        List<CauHoi> multipleChoices = multipleChoiseFactory.taoCacCauHoiTuFile("hv00003", 10);
//        multipleChoices.forEach(a -> System.out.println(((MultipleChoice)a).toString()));
//        ConversationFactory conversationFactory = new ConversationFactory();
//        CauHoi cauHoi = conversationFactory.taoCauHoiTuFile(MucDo.KHO);
//        System.out.println(((Conversation)cauHoi).getDoanVan().getNoiDung());
//        ((Conversation)cauHoi).getDanhSachCauHoi().forEach(cauHoiTracNghiem -> {
//            System.out.println(cauHoiTracNghiem.getId());
//            (((CauHoiTracNghiem)cauHoiTracNghiem).getCacPhuongAn()).forEach(p -> System.out.println(p.getNoiDung()));
//        });
//        System.out.println(((Conversation)cauHoi).toString());
//        System.out.println(CauHinh.SO_CAU_HOI_MULTIPLE_CHOICE);
//        System.out.println(CauHinh.SO_CAU_HOI_CONVERSATION_THEO_MUC_DO.get(MucDo.DE));
        HocVienFactory hocVienFactory = new HocVienFactory();
        HocVien hv1 = hocVienFactory.taoHocVien("hv00002");
        System.out.println(hv1.toString());
    }
}
