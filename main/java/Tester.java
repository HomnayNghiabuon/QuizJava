import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tester {
    public static void main(String[] args) {

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
        ThongTinDangNhapHocVien tt1 = new ThongTinDangNhapHocVien();
        tt1.setTenDangNhap("hocvien2");
        tt1.setMatKhau("13443521");
        tt1.dangNhap();
        HocVienFactory hocVienFactory = new HocVienFactory();
        if (tt1.getTrangThaiDangNhap() == TrangThaiDangNhap.SUCCESS) {
            HocVien hv1 = hocVienFactory.taoHocVien(tt1.getIdHocVien());
            System.out.println(hv1.toString());
            BaiKiemTra baiKiemTra = new BaiKiemTra();
            baiKiemTra.setHocVien(hv1);
            baiKiemTra.napCauHoi();
        }
    }
}