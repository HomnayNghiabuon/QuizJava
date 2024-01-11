import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class CauHinh {
    public static Scanner scanner = new Scanner(System.in);
    public static String TIME_PATTERN = "dd/MM/yyyy";
    public static int SO_CAU_HOI_MULTIPLE_CHOICE;
    public static Map<MucDo, Integer> SO_CAU_HOI_INCOMPLE_THEO_MUC_DO = new HashMap();
    public static Map<MucDo, Integer> SO_CAU_HOI_CONVERSATION_THEO_MUC_DO = new HashMap();
    public static int SO_HOC_VIEN;
    public static int ID_HOC_VIEN_CUOI;
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
    static {
        SO_HOC_VIEN = demDong("src/main/resources/ThongTinHocVien/ThongTinCaNhan.txt");
    }
    static {
        try {
            FileReader fileReader = new FileReader("src/main/resources/ThongTinHocVien/ThongTinCaNhan.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp = "";
            while ((line = bufferedReader.readLine()) != null) {
                if(line!=null) temp = line;
            }
            if(temp.length() >=7) ID_HOC_VIEN_CUOI = Integer.valueOf(temp.substring(2, 7));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public static void xoaMotDong(String path, String noiDung){
        try {
            File inputFile = new File(path);
            File tempFile = new File("tempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // Kiểm tra xem dòng hiện tại có phải là dòng cần xóa không
                if (currentLine.contains(noiDung)) {
                    continue; // Nếu là dòng cần xóa, bỏ qua và không ghi vào tệp tempFile
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            // Xóa tệp ban đầu
            if (!inputFile.delete()) {
                System.out.println("Không thể xóa tệp ban đầu.");
                return;
            }

            // Đổi tên tệp tạm thành tên của tệp ban đầu
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Không thể đổi tên tệp tạm.");
            }

            System.out.println("Đã xóa dòng từ tệp.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi xóa dòng từ tệp: " + e.getMessage());
        }

    }
    public static void suaMotDong(String path, String id, String noiDungMoi){
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.contains(id)) {
                    line = noiDungMoi;
                    content.append(line);
                }
                else content.append(line).append("\n");

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Ghi dữ liệu đã sửa vào cùng vị trí của file gốc
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(content.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void rangbuocNhap(int luaChon, int m,int n){
        if(luaChon<m||luaChon>n) {
            while (luaChon < m || luaChon > n) {
                System.out.println("Lựa chọn không tồn tại!Nhập lại!");
                luaChon = Integer.parseInt(CauHinh.scanner.nextLine());
            }
        }
    }
}
