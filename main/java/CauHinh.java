import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class CauHinh {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String TIME_PATTERN = "dd/MM/yyyy";
    public static int SO_CAU_HOI_MULTIPLE_CHOICE;
    public static final Map<MucDo, Integer> SO_CAU_HOI_INCOMPLE_THEO_MUC_DO = new HashMap();
    public static final Map<MucDo, Integer> SO_CAU_HOI_CONVERSATION_THEO_MUC_DO = new HashMap();
    static {
        int kq =0;
        try {
            FileReader fileReader = new FileReader("src/main/resources/CauHoi/MultipleChoise/CauHoi.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.length() > 3){
                    String[] data = line.split("#");
                    if(data[0].equals(String.format("%04d", kq+1))) kq++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SO_CAU_HOI_MULTIPLE_CHOICE = kq;
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

    public static int random(int begin, int end) {
        return ThreadLocalRandom.current().nextInt(begin, end + 1);
    }

}
