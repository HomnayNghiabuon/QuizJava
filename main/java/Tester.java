
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tester {
    public static void main(String[] args) {
        int luachon,luachon2,luachon3;
        String id,username,password;
        QuanLyHocVien quanLyHocVien =new QuanLyHocVien();
        QuanLyCauHoi quanLyCauHoiMultipleChoice=new QuanLyCauHoiMultipleChoice() ;
        HocVienFactory hocVienFactory=new HocVienFactory();
        ThongTinDangNhapHocVien thongTinDangNhapHocVien=new ThongTinDangNhapHocVien();
        BaiKiemTra baiKiemTra = new BaiKiemTra();
        do {
            System.out.println("=================CHƯƠNG TRÌNH TRẮC NGHIỆM TIẾNG ANH================");
            System.out.println("===============================MENU================================");
            System.out.println("1 .Quản lý người học");
            System.out.println("2. Quản lý câu hỏi");
            System.out.println("3. Luyện tập");
            System.out.println("0. Thoát chương trình");
            System.out.println("===================================================================");
            System.out.println("Vui lòng chọn: ");
            luachon=Integer.parseInt(CauHinh.scanner.nextLine());
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
                        luachon2=Integer.parseInt(CauHinh.scanner.nextLine());
                        CauHinh.rangbuocNhap(luachon2,0,5);
                        switch (luachon2){
                            case 1:
                                quanLyHocVien.xemDanhSachHocVien();
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
                                luachon3=Integer.parseInt(CauHinh.scanner.nextLine());
                                CauHinh.rangbuocNhap(luachon3,0,4);
                                switch(luachon3){
                                    case 0: break;
                                    case 1:
                                        String hoTen;
                                        System.out.print("Nhập họ tên: ");
                                        hoTen=CauHinh.scanner.nextLine();
                                        quanLyHocVien.traCuuTheoHoTen(hoTen);
                                        break;
                                    case 2:
                                        String gioiTinh;
                                        System.out.print("Nhập giới tính: ");
                                        gioiTinh=CauHinh.scanner.nextLine();
                                        System.out.printf("Danh sách học viên có giới tính %s\n",gioiTinh);
                                        quanLyHocVien.traCuuTheoGioiTinh(gioiTinh);
                                        break;
                                    case 3:
                                        String queQuan;
                                        System.out.print("Nhập quê quán: ");
                                        queQuan=CauHinh.scanner.nextLine();
                                        System.out.printf("Danh sách học viên có quê quán %s\n",queQuan);
                                        quanLyHocVien.traCuuTheoQueQuan(queQuan);
                                        break;
                                    case 4:
                                        String ngaySinh;
                                        System.out.print("Nhập ngày sinh(dd/mm/yyyy): ");
                                        ngaySinh=CauHinh.scanner.nextLine();
                                        System.out.printf("Danh sách học viên có ngày sinh %s\n",ngaySinh);
                                        quanLyHocVien.traCuuTheoNgaySinh(ngaySinh);
                                        break;


                                }
                                }while (luachon3!=0);
                                break;
                            case 3: quanLyHocVien.themHocVien();
                                break;
                            case 4:
                                System.out.print("Nhập ID học viên cần sửa: ");
                                id=CauHinh.scanner.nextLine();
                                quanLyHocVien.capNhapHocVien(id);
                                break;
                            case 5:
                                System.out.print("Nhập ID học viên cần xóa: ");
                                id=CauHinh.scanner.nextLine();
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
                        luachon2 = Integer.parseInt(CauHinh.scanner.nextLine());
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
                                    luachon3 = Integer.parseInt(CauHinh.scanner.nextLine());
                                    CauHinh.rangbuocNhap(luachon3, 0, 3);
                                    switch (luachon3) {
                                        case 0:
                                            break;
                                        case 1:
                                            System.out.println("=========Danh sách câu hỏi MultiChoice==========");
                                            quanLyCauHoiMultipleChoice.xemDanhSachCauHoi();
                                            break;
                                        case 2:
                                            //xem danh sách câu hỏi incomple
                                            break;
                                        case 3:
                                            //xem danh sách câu hỏi conversation
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
                                    luachon3 = Integer.parseInt(CauHinh.scanner.nextLine());
                                    CauHinh.rangbuocNhap(luachon3, 0, 3);
                                    switch (luachon3) {
                                        case 0:
                                            break;
                                        case 1:
                                            String noiDung;
                                            System.out.println("Nhập nội dung cần tìm: ");
                                            noiDung=CauHinh.scanner.nextLine();
                                            //((QuanLyCauHoiMultipleChoice)quanLyCauHoiMultipleChoice).timCauHoi(noiDung);
                                            break;
                                        case 2://tìm câu hỏi imcomple
                                            break;
                                        case 3: //tìm câu hỏi conversation
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
                        luachon2 = Integer.parseInt(CauHinh.scanner.nextLine());
                        CauHinh.rangbuocNhap(luachon2,0,2);

                        switch (luachon2) {
                            case 0:
                                break;
                            case 1:
                                do {

                                System.out.println("==========ĐĂNG NHẬP==========");
                                System.out.print("Nhập username: ");
                                username=CauHinh.scanner.nextLine();
                                System.out.print("Nhập password: ");
                                password=CauHinh.scanner.nextLine();
                                thongTinDangNhapHocVien.setTenDangNhap(username);
                                thongTinDangNhapHocVien.setMatKhau(password);
                                thongTinDangNhapHocVien.dangNhap();


                                if(thongTinDangNhapHocVien.getTrangThaiDangNhap()==TrangThaiDangNhap.SUCCESS) {
                                    HocVien hocVien = hocVienFactory.taoHocVien(thongTinDangNhapHocVien.getIdHocVien());
                                    do {
                                        System.out.println("==========LUYỆN TẬP==========");
                                        System.out.println("1. Tham gia làm bài trắc nghiệm");
                                        System.out.println("2. Thống kế kết quả học tập theo tháng");
                                        System.out.println("0. Trở lại");
                                        System.out.println("=============================");
                                        System.out.print("Vui lòng chọn: ");
                                        luachon3 = Integer.parseInt(CauHinh.scanner.nextLine());
                                        CauHinh.rangbuocNhap(luachon3, 0, 2);
                                        switch (luachon3) {
                                            case 0:
                                                break;
                                            case 1:
                                                baiKiemTra.setHocVien(hocVien);
                                                baiKiemTra.batDauLamBai();
                                                System.out.printf("Số điểm bạn đạt được: %.2f \n",baiKiemTra.getDiem());
                                                break;
                                            case 2:
                                                //Thống kê
                                                break;
                                        }
                                    } while (luachon3 != 0);
                                }
                                else System.out.println("Đăng nhập không thành công!");
                                }while (thongTinDangNhapHocVien.getTrangThaiDangNhap()!=TrangThaiDangNhap.SUCCESS);

                                break;

                            case 2:
                                HocVienFactory newHv = new HocVienFactory();
                                break;
                        }
                        break;
                    }while(luachon2!=0);
            }

        }while (luachon!=0);

    }
}

