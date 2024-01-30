import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tester {
    public static void main(String[] args) {
        int luachon,luachon2,luachon3,luachon4,luachon5;
        String id,username,password,noidung;
        QuanLyHocVien quanLyHocVien =new QuanLyHocVien();
        QuanLyCauHoi quanLyCauHoiMultipleChoice=new QuanLyCauHoiMultipleChoice() ;
        QuanLyCauHoi quanLyCauHoiIncomple = new QuanLyCauHoiIncomple();
        QuanLyCauHoi quanLyCauHoiConversation = new QuanLyCauHoiConversation();
        HocVienFactory hocVienFactory=new HocVienFactory();
        ThongTinDangNhapHocVien thongTinDangNhapHocVien=new ThongTinDangNhapHocVien();
        BaiKiemTra baiKiemTra = new BaiKiemTra();
        ThongKeKetQuaHocTap thongKeKetQuaHocTap = new ThongKeKetQuaHocTap();
        do {
            System.out.println("=================CHƯƠNG TRÌNH TRẮC NGHIỆM TIẾNG ANH================");
            System.out.println("===============================MENU================================");
            System.out.println("1 .Quản lý người học");
            System.out.println("2. Quản lý câu hỏi");
            System.out.println("3. Luyện tập");
            System.out.println("0. Thoát chương trình");
            System.out.println("===================================================================");
            System.out.println("Vui lòng chọn: ");
            luachon=Integer.parseInt(CauHinh.nhapDuLieuSo());
            CauHinh.rangbuocNhap(luachon,0,3);

            switch (luachon){
                case 0:
                    break;
                case 1:
                    do {
                        System.out.println("==========QUẢN LÝ NGƯỜI HỌC==========");
                        System.out.println("1. Xem danh sách học viên");
                        System.out.println("2. Tra cứu học viên");
                        System.out.println("3. Thêm học viên");
                        System.out.println("4. Cập nhật học viên");
                        System.out.println("5. Xóa học viên ");
                        System.out.println("0. Quay lại");
                        System.out.println("======================================");
                        System.out.print("Vui lòng chọn: ");
                        luachon2=Integer.parseInt(CauHinh.nhapDuLieuSo());
                        CauHinh.rangbuocNhap(luachon2,0,5);
                        switch (luachon2){
                            case 1:
                                quanLyHocVien.xemDanhSachHocVien();
                                System.out.print("Nhấp enter để tiếp tục...");
                                CauHinh.scanner.nextLine();
                                break;
                            case 2:
                                do {
                                    System.out.println("=========TRA CỨU HỌC VIÊN==========");
                                    System.out.println("1. Tra cứu theo họ tên");
                                    System.out.println("2. Tra cứu theo giới tính");
                                    System.out.println("3. Tra cứu theo quê quán");
                                    System.out.println("4. Tra cứu theo ngày sinh");
                                    System.out.println("0. Quay lại");
                                    System.out.println("====================================");
                                    System.out.print("Vui lòng chọn: ");
                                    luachon3=Integer.parseInt(CauHinh.nhapDuLieuSo());
                                    CauHinh.rangbuocNhap(luachon3,0,4);
                                    switch(luachon3){
                                        case 0: break;
                                        case 1:
                                            String hoTen;
                                            System.out.print("Nhập họ tên: ");
                                            hoTen=CauHinh.nhapDuLieu();
                                            System.out.println(quanLyHocVien.traCuuTheoThongTin("HoTen", hoTen));
                                            break;
                                        case 2:
                                            String gioiTinh;
                                            System.out.print("Nhập giới tính: ");
                                            gioiTinh=CauHinh.nhapDuLieu();
                                            System.out.printf("Danh sách học viên có giới tính %s\n",gioiTinh);
                                            System.out.println(quanLyHocVien.traCuuTheoThongTin("GioiTinh", gioiTinh));
                                            break;
                                        case 3:
                                            String queQuan;
                                            System.out.print("Nhập quê quán: ");
                                            queQuan=CauHinh.nhapDuLieu();
                                            System.out.printf("Danh sách học viên có quê quán %s\n",queQuan);
                                        System.out.println(quanLyHocVien.traCuuTheoThongTin("QueQuan", queQuan));
                                            break;
                                        case 4:
                                            String ngaySinh;
                                            System.out.print("Nhập ngày sinh(dd/mm/yyyy): ");
                                            ngaySinh=CauHinh.nhapDuLieu();
                                            ngaySinh=CauHinh.rangBuocNgayThang(ngaySinh);
                                            System.out.printf("Danh sách học viên có ngày sinh %s\n",ngaySinh);
                                            LocalDate ns = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.TIME_PATTERN));
                                            System.out.println(quanLyHocVien.traCuuTheoThongTin("NgaySinh", ns));
                                            break;


                                    }
                                }while (luachon3!=0);
                                break;
                            case 3: quanLyHocVien.themHocVien();
                                break;
                            case 4:
                                System.out.print("Nhập ID học viên cần sửa: ");
                                id=CauHinh.nhapDuLieu();
                                quanLyHocVien.capNhapHocVien(id);
                                break;
                            case 5:
                                System.out.print("Nhập ID học viên cần xóa: ");
                                id=CauHinh.nhapDuLieu();
                                quanLyHocVien.xoaHocVien(id);
                                break;
                        }

                    }while (luachon2!=0);

                    break;
                case 2:
                    do {
                        System.out.println("==========QUẢN LÝ CÂU HỎI==========");
                        System.out.println("1. Xem danh sách câu hỏi");
                        System.out.println("2. Tìm câu hỏi");
                        System.out.println("0. Quay lại");
                        System.out.println("===================================");
                        System.out.print("Vui lòng chọn: ");
                        luachon2 = Integer.parseInt(CauHinh.nhapDuLieuSo());
                        CauHinh.rangbuocNhap(luachon2, 0, 2);
                        switch (luachon2) {
                            case 0:
                                break;
                            case 1:
                                do {
                                    System.out.println("==========XEM DANH SÁCH CÂU HỎI==========");
                                    System.out.println("===Chọn loại câu hỏi cần xem danh sách=== ");
                                    System.out.println("1. Câu hỏi MutilChoice");
                                    System.out.println("2. Câu hỏi Incomple");
                                    System.out.println("3. Câu hỏi Conversation");
                                    System.out.println("0. Quay lại");
                                    System.out.println("=========================================");
                                    System.out.print("Vui lòng chọn: ");
                                    luachon3 = Integer.parseInt(CauHinh.nhapDuLieuSo());
                                    CauHinh.rangbuocNhap(luachon3, 0, 3);
                                    switch (luachon3) {
                                        case 0:
                                            break;
                                        case 1:
                                            System.out.println("=========Danh sách câu hỏi MultiChoice==========");
                                            quanLyCauHoiMultipleChoice.xemDanhSachCauHoi();
                                            System.out.println("Nhấn enter để tiếp tục...");
                                            CauHinh.scanner.nextLine();
                                            break;
                                        case 2:
                                            System.out.println("=========Danh sách câu hỏi Incomplete==========");
                                            quanLyCauHoiIncomple.xemDanhSachCauHoi();
                                            System.out.println("Nhấn enter để tiếp tục...");
                                            CauHinh.scanner.nextLine();
                                            break;
                                        case 3:
                                            System.out.println("=========Danh sách câu hỏi Conversation==========");
                                            quanLyCauHoiConversation.xemDanhSachCauHoi();
                                            System.out.println("Nhấn enter để tiếp tục...");
                                            CauHinh.scanner.nextLine();
                                            break;

                                    }
                                } while (luachon3 != 0);
                                break;
                            case 2:
                                do {

                                    System.out.println("===============TÌM CÂU HỎI===============");
                                    System.out.println("1. Tìm câu hỏi MutilChoice");
                                    System.out.println("2. Tìm câu hỏi Incomple");
                                    System.out.println("3. Tìm câu hỏi Conversation");
                                    System.out.println("0. Quay lại");
                                    System.out.println("=========================================");
                                    System.out.print("Vui lòng chọn: ");
                                    luachon3 = Integer.parseInt(CauHinh.nhapDuLieuSo());
                                    CauHinh.rangbuocNhap(luachon3, 0, 3);
                                    switch (luachon3) {
                                        case 0:
                                            break;
                                        case 1:
                                            do {
                                                System.out.println("===============TÌM CÂU HỎI MULTICHOCE===============");
                                                System.out.println("1. Tìm theo nội dung");
                                                System.out.println("2. Tìm theo mức độ");
                                                System.out.println("3. Tìm theo mức danh mục");
                                                System.out.println("0. Quay lại");
                                                System.out.println("====================================================");
                                                System.out.print("Vui lòng chọn: ");
                                                luachon4 = Integer.parseInt(CauHinh.nhapDuLieuSo());
                                                CauHinh.rangbuocNhap(luachon3, 0, 3);
                                                switch (luachon4){
                                                    case 0: break;
                                                    case 1:
                                                        System.out.println("===============TÌM CÂU HỎI THEO NỘI DUNG===============");

                                                        System.out.print("Nhập nội dung: ");
                                                        noidung=CauHinh.nhapDuLieu();
                                                        if(quanLyCauHoiMultipleChoice instanceof QuanLyCauHoiMultipleChoice) {
                                                            ((QuanLyCauHoiMultipleChoice) quanLyCauHoiMultipleChoice).timCauHoi(noidung);
                                                        }

                                                        break;
                                                    case 2:
                                                     do {
                                                         System.out.println("===============TÌM CÂU HỎI THEO MỨC ĐỘ===============");
                                                         System.out.println("1. Dễ");
                                                         System.out.println("2. Trung Bình");
                                                         System.out.println("3. Khó");
                                                         System.out.println("0. Quay lại");
                                                         System.out.println("====================================================");
                                                         System.out.print("Vui lòng chọn: ");
                                                         luachon5=Integer.parseInt(CauHinh.nhapDuLieuSo());
                                                         CauHinh.rangbuocNhap(luachon5,0,MucDo.values().length);
                                                         if(luachon5==1){
                                                             System.out.println("DANH SÁCH CÂU HỎI MULTICHOICE MỨC ĐỘ DỄ");
                                                             if(quanLyCauHoiMultipleChoice instanceof QuanLyCauHoiMultipleChoice) {
                                                                 ((QuanLyCauHoiMultipleChoice) quanLyCauHoiMultipleChoice).timCauHoi(MucDo.values()[luachon5-1]);
                                                             }
                                                         }
                                                         else if(luachon5==2){
                                                             System.out.println("DANH SÁCH CÂU HỎI MULTICHOICE MỨC ĐỘ TRUNG BÌNH");
                                                             if(quanLyCauHoiMultipleChoice instanceof QuanLyCauHoiMultipleChoice) {
                                                                 ((QuanLyCauHoiMultipleChoice) quanLyCauHoiMultipleChoice).timCauHoi(MucDo.values()[luachon5-1]);
                                                             }
                                                         }
                                                         else if(luachon5==3){
                                                             System.out.println("DANH SÁCH CÂU HỎI MULTICHOICE MỨC ĐỘ KHÓ");
                                                             if(quanLyCauHoiMultipleChoice instanceof QuanLyCauHoiMultipleChoice) {
                                                                 ((QuanLyCauHoiMultipleChoice) quanLyCauHoiMultipleChoice).timCauHoi(MucDo.values()[luachon5-1]);
                                                             }
                                                         }
                                                         else break;
                                                     }while (luachon5!=0);

                                                        break;
                                                    case 3:
                                                            String noiDungDanhMuc;
                                                            System.out.println("===============TÌM CÂU HỎI THEO DANH MỤC===============");
                                                            System.out.println("Nhập danh mục: ");
                                                            noiDungDanhMuc=CauHinh.nhapDuLieu();
                                                            noiDungDanhMuc=noiDungDanhMuc.replaceAll("\\s+", "_").toUpperCase();
                                                            if(quanLyCauHoiMultipleChoice instanceof QuanLyCauHoiMultipleChoice) {
                                                                ((QuanLyCauHoiMultipleChoice) quanLyCauHoiMultipleChoice).timCauHoi(DanhMuc.valueOf(noiDungDanhMuc));

                                                        break;
                                                }
                                            }
                                            }while (luachon4!=0);
                                            break;
                                        case 2:
                                            do {
                                                System.out.println("===============TÌM CÂU HỎI INCOMPLETE===============");
                                                System.out.println("1. Dễ");
                                                System.out.println("2. Trung Bình");
                                                System.out.println("3. Khó");
                                                System.out.println("0. Quay lại");
                                                System.out.println("====================================================");
                                                System.out.print("Vui lòng chọn: ");
                                                luachon5=Integer.parseInt(CauHinh.nhapDuLieuSo());
                                                CauHinh.rangbuocNhap(luachon5,0,MucDo.values().length);
                                                if(luachon5==1){
                                                    System.out.println("DANH SÁCH CÂU HỎI INCOMPLETE MỨC ĐỘ DỄ");
                                                    if(quanLyCauHoiIncomple instanceof QuanLyCauHoiIncomple) {
                                                        ((QuanLyCauHoiIncomple) quanLyCauHoiIncomple).timCauHoi(MucDo.values()[luachon5-1]);
                                                    }
                                                }
                                                else if(luachon5==2){
                                                    System.out.println("DANH SÁCH CÂU HỎI INCOMPLETE MỨC ĐỘ TRUNG BÌNH");
                                                    if(quanLyCauHoiIncomple instanceof QuanLyCauHoiIncomple) {
                                                        ((QuanLyCauHoiIncomple) quanLyCauHoiIncomple).timCauHoi(MucDo.values()[luachon5-1]);
                                                    }
                                                }
                                                else if(luachon5==3){
                                                    System.out.println("DANH SÁCH CÂU HỎI INCOMPLETE MỨC ĐỘ KHÓ");
                                                    if(quanLyCauHoiIncomple instanceof QuanLyCauHoiIncomple) {
                                                        ((QuanLyCauHoiIncomple) quanLyCauHoiIncomple).timCauHoi(MucDo.values()[luachon5-1]);
                                                    }
                                                }
                                                else break;
                                            }while (luachon5!=0);
                                            break;
                                        case 3:
                                            do {
                                                System.out.println("===============TÌM CÂU HỎI CONVERSATION===============");
                                                System.out.println("1. Dễ");
                                                System.out.println("2. Trung Bình");
                                                System.out.println("3. Khó");
                                                System.out.println("0. Quay lại");
                                                System.out.println("====================================================");
                                                System.out.print("Vui lòng chọn: ");
                                                luachon5=Integer.parseInt(CauHinh.nhapDuLieuSo());
                                                CauHinh.rangbuocNhap(luachon5,0,MucDo.values().length);
                                                if(luachon5==1){
                                                    System.out.println("DANH SÁCH CÂU HỎI CONVERSATION MỨC ĐỘ DỄ");
                                                    if(quanLyCauHoiConversation instanceof QuanLyCauHoiConversation) {
                                                        ((QuanLyCauHoiConversation) quanLyCauHoiConversation).timCauHoi(MucDo.values()[luachon5-1]);
                                                    }
                                                }
                                                else if(luachon5==2){
                                                    System.out.println("DANH SÁCH CÂU HỎI CONVERSATION MỨC ĐỘ TRUNG BÌNH");
                                                    if(quanLyCauHoiConversation instanceof QuanLyCauHoiConversation) {
                                                        ((QuanLyCauHoiConversation) quanLyCauHoiConversation).timCauHoi(MucDo.values()[luachon5-1]);
                                                    }
                                                }
                                                else if(luachon5==3){
                                                    System.out.println("DANH SÁCH CÂU HỎI CONVERSATION MỨC ĐỘ KHÓ");
                                                    if(quanLyCauHoiConversation instanceof QuanLyCauHoiConversation) {
                                                        ((QuanLyCauHoiConversation) quanLyCauHoiConversation).timCauHoi(MucDo.values()[luachon5-1]);
                                                    }
                                                }
                                                else break;
                                            }while (luachon5!=0);
                                            break;

                                    }
                                }
                                while (luachon3 != 0);
                                break;
                        }

                    }while (luachon2!=0);
                    break;
                case 3:
                    do {
                        System.out.println("==========LUYỆN TẬP==========");
                        System.out.println("1. Đăng nhập");
                        System.out.println("2. Bạn chưa có tài khoản? Đăng kí!");
                        System.out.println("0. Trở lại");
                        System.out.println("=============================");
                        System.out.print("Vui lòng chọn: ");
                        luachon2 = Integer.parseInt(CauHinh.nhapDuLieuSo());
                        CauHinh.rangbuocNhap(luachon2,0,2);

                        switch (luachon2) {
                            case 0:
                                break;
                            case 1:
                                do {

                                    System.out.println("==========ĐĂNG NHẬP==========");
                                    System.out.print("Nhập username: ");
                                    username=CauHinh.nhapDuLieu();
                                    System.out.print("Nhập password: ");
                                    password=CauHinh.nhapDuLieu();
                                    thongTinDangNhapHocVien.setTenDangNhap(username);
                                    thongTinDangNhapHocVien.setMatKhau(password);
                                    thongTinDangNhapHocVien.dangNhap();


                                    if(thongTinDangNhapHocVien.getTrangThaiDangNhap()==TrangThaiDangNhap.SUCCESS) {
                                        HocVien hocVien = hocVienFactory.taoHocVien(thongTinDangNhapHocVien.getIdHocVien());
                                        thongKeKetQuaHocTap.setHocVien(hocVien);
                                        do {
                                            System.out.println("==========LUYỆN TẬP==========");
                                            System.out.println("1. Tham gia làm bài trắc nghiệm");
                                            System.out.println("2. Thống kế kết quả học tập theo tháng");
                                            System.out.println("0. Trở lại");
                                            System.out.println("=============================");
                                            System.out.print("Vui lòng chọn: ");
                                            luachon3 = Integer.parseInt(CauHinh.nhapDuLieuSo());
                                            CauHinh.rangbuocNhap(luachon3, 0, 2);
                                            switch (luachon3) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    baiKiemTra.setHocVien(hocVien);
                                                    baiKiemTra.batDauLamBai();
                                                    System.out.printf("Số điểm bạn đạt được: %.2f \n",baiKiemTra.getDiem());
                                                    System.out.println("Nhấn enter để tiếp tục...");
                                                    CauHinh.scanner.nextLine();
                                                    break;
                                                case 2:
                                                    System.out.println("Nhập tháng năm (MM/yyyy)");
                                                    String thangNam = CauHinh.nhapDuLieu();
                                                    thangNam=CauHinh.rangBuocThangNam(thangNam);
                                                    thongKeKetQuaHocTap.thongKeDiem(thangNam);
                                                    break;
                                            }
                                        } while (luachon3 != 0);
                                    }
                                    else System.out.println("Đăng nhập không thành công!");
                                }while (thongTinDangNhapHocVien.getTrangThaiDangNhap()!=TrangThaiDangNhap.SUCCESS);

                                break;

                            case 2:
                                System.out.println("==========ĐĂNG KÝ HỌC VIÊN==========");
                                quanLyHocVien.themHocVien();
                                System.out.println("Đăng kí thành công!Nhấn enter để tiếp tục...");
                                CauHinh.scanner.nextLine();
                                break;
                        }

                    }while(luachon2!=0);
                    break;
            }

        }while (luachon!=0);

    }
}

