import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class CauHinh {
    public static Scanner scanner = new Scanner(System.in);
    public static String TIME_PATTERN = "dd/MM/yyyy";
    public static int SO_CAU_HOI_MULTIPLE_CHOICE;
    public static Map<MucDo, Integer> SO_CAU_HOI_INCOMPLE_THEO_MUC_DO = new HashMap();
    public static Map<MucDo, Integer> SO_CAU_HOI_CONVERSATION_THEO_MUC_DO = new HashMap();

    static {
        SO_CAU_HOI_MULTIPLE_CHOICE = demDong("src/main/resources/CauHoi/MultipleChoise/CauHoi.txt");
    }
    static {
        for(MucDo mucDo:MucDo.values()){
            int kq =0;
            try {
                FileReader fileReader = new FileReader("src/main/resources/CauHoi/Incomple/"+mucDo+"/CauHoi.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if(line.equals("ThongTinDoanVan")){
                        kq++;
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            SO_CAU_HOI_INCOMPLE_THEO_MUC_DO.put(mucDo, kq);
        }
    }
    static {
        for(MucDo mucDo:MucDo.values()){
            int kq =0;
            try {
                FileReader fileReader = new FileReader("src/main/resources/CauHoi/Conversation/"+mucDo+"/CauHoi.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if(line.equals("ThongTinDoanVan")){
                        kq++;
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            SO_CAU_HOI_CONVERSATION_THEO_MUC_DO.put(mucDo, kq);
        }
    }
    public int getSoHocVien(){
        return demDong("src/main/resources/ThongTinHocVien/ThongTinCaNhan.txt");
    }
    public static String getIdHocVienCuoi() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/ThongTinHocVien/ThongTinCaNhan.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp = "";
            while ((line = bufferedReader.readLine()) != null) {
                if(line!=null) temp = line;
            }
            if(temp.length() >=7) return  temp.substring(2, 7);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static int random(int begin, int end) {
        return ThreadLocalRandom.current().nextInt(begin, end + 1);
    }
    public static void ghiFile(String path, List<StringBuilder> stringBuilders) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder noiDungMoi = new StringBuilder();
            for (StringBuilder stringBuilder: stringBuilders){
                noiDungMoi.append(stringBuilder.toString()).append("\n");
            }
            bufferedWriter.write(noiDungMoi.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int demDong(String path){
        int kq =0;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                kq++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return kq;
    }
    public static List<StringBuilder> layDuLieuTuFile(String path){
        List<StringBuilder> stringBuilders = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilders.add(new StringBuilder(line));
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilders;
    }
    public static void themDongMoiVaoFile(String path, String line){

        try {
            // Mở tệp để ghi dữ liệu vào cuối tệp
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

            // Dòng mới cần được thêm vào tệp

            // Ghi dòng mới vào tệp và thêm ký tự xuống dòng
            writer.write(line);
            writer.newLine();

            // Đóng tệp sau khi hoàn thành
            writer.close();

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi thêm dòng mới vào tệp: " + e.getMessage());
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String nhapDuLieu(){
        String inputData = CauHinh.scanner.nextLine();
        while (inputData.trim().isEmpty()) {
            // Kiểm tra xem dữ liệu có trống hay không
            if (inputData.trim().isEmpty()) {
                System.out.println("Dữ liệu không được trống và phải là số nguyên. Vui lòng nhập lại: ");
                inputData=CauHinh.scanner.nextLine();
            }
        }
        return inputData;
    }
    public static String nhapDuLieuSo(){
        String inputData = CauHinh.scanner.nextLine();
        while (inputData.trim().isEmpty()||isInteger(inputData)==false) {
            // Kiểm tra xem dữ liệu có trống và có phải số hay không
            if (inputData.trim().isEmpty()||isInteger(inputData)==false) {
                System.out.println("Dữ liệu không được trống và phải là số nguyên. Vui lòng nhập lại: ");
                inputData=CauHinh.scanner.nextLine();
            }
        }
        return inputData;
    }
    public static void rangbuocNhap(int luaChon, int m,int n){
        if(luaChon<m||luaChon>n) {
            while (luaChon < m || luaChon > n) {
                System.out.println("Lựa chọn không tồn tại!Nhập lại!");
                luaChon = Integer.parseInt(CauHinh.nhapDuLieu());
            }
        }

    }
    public static String rangBuocNgayThang(String ngayThang){
        SimpleDateFormat dateFormat= new SimpleDateFormat(CauHinh.TIME_PATTERN);
        dateFormat.setLenient(false);

        boolean isValid = false;
        Date date = null;

        while (!isValid) {
            try {
                // Parse ngày tháng từ chuỗi nhập vào
                date = dateFormat.parse(ngayThang);
                isValid = true; // Nếu không có ngoại lệ ParseException, ngày tháng là hợp lệ
            } catch (ParseException e) {
                System.out.println("Định dạng ngày tháng không đúng. Vui lòng nhập lại.");
                ngayThang=CauHinh.scanner.nextLine();
            }
        }
        return ngayThang;
    }
    public static String rangBuocThangNam(String ngayThang){
        SimpleDateFormat dateFormat= new SimpleDateFormat("MM/yyyy");
        dateFormat.setLenient(false);

        boolean isValid = false;
        Date date = null;

        while (!isValid) {
            try {
                // Parse ngày tháng từ chuỗi nhập vào
                date = dateFormat.parse(ngayThang);
                isValid = true; // Nếu không có ngoại lệ ParseException, ngày tháng là hợp lệ
            } catch (ParseException e) {
                System.out.println("Định dạng ngày tháng không đúng. Vui lòng nhập lại.");
                ngayThang=CauHinh.scanner.nextLine();
            }
        }
        return ngayThang;
    }
    public static String layStringTuFile(String path){
        String str;
       try{
           Path fileName = Path.of(path);
           str = Files.readString(fileName);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return str;
    }
    public static void xoaDongTheoIdHocVien(String path, String idHocVien){
        String duongDanFile = path;
        String dongCanXoa = idHocVien;

        try {
            File file = new File(duongDanFile);

            // Đọc dữ liệu từ file và lưu vào một danh sách
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                // Kiểm tra xem dòng có phải là dòng cần xóa không
                if (!line.contains(idHocVien)) {
                    lines.add(line);
                }
            }
            reader.close();

            // Ghi lại dữ liệu đã chỉnh sửa vào file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            System.err.println("Không thể xóa dòng. Lỗi: " + e.getMessage());
        }
    }
}
