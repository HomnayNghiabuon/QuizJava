import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tester {
    public static void main(String[] args) {
        int luachon,luachon2,luachon3;
        String id;
        QuanLyHocVien ql =new QuanLyHocVien();
        HocVienFactory hv=new HocVienFactory();

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
                                ql.xemDanhSachHocVien();
                                break;
                            case 2: //Tra cứu học viên theo họ tên, giới tính, ngày sinh, quê quán
                                break;
                            case 3: ql.themHocVien();
                                break;
                            case 4:
                                System.out.print("Nhập ID học viên cần sửa: ");
                                id=CauHinh.scanner.nextLine();
                                ql.capNhapHocVien(id);
                                break;
                            case 5:
                                System.out.print("Nhập ID học viên cần xóa: ");
                                id=CauHinh.scanner.nextLine();
                                ql.xoaHocVien(id);
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
                                            //xem danh sách câu hỏi multichoice
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
                                        case 1: //Tìm câu hỏi Multichoice
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
                                    System.out.println("==========LUYỆN TẬP==========");
                                    System.out.println("1. Tham gia làm bài trắc nghiệm");
                                    System.out.println("2. Thống kế kết quả học tập theo tháng");
                                    System.out.println("0. Trở lại");
                                    System.out.println("=============================");
                                    System.out.print("Vui lòng chọn: ");
                                    luachon3 = Integer.parseInt(CauHinh.scanner.nextLine());
                                    CauHinh.rangbuocNhap(luachon3,0,2);
                                    switch (luachon3) {
                                        case 0:
                                            break;
                                        case 1:

                                            break;
                                        case 2:
                                            //Thống kê
                                            break;
                                    }
                                }while(luachon3!=0);

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

