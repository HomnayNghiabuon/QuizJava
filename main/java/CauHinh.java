import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class CauHinh {
    public static final int SO_CAU_HOI_MULTIPLE_CHOICE = 30;
    public static final Map<MucDo, Integer> SO_CAU_HOI_INCOMPLE_THEO_MUC_DO = new HashMap();
    static {
        SO_CAU_HOI_INCOMPLE_THEO_MUC_DO.put(MucDo.DE, 2);
        SO_CAU_HOI_INCOMPLE_THEO_MUC_DO.put(MucDo.TRUNG_BINH, 1);
        SO_CAU_HOI_INCOMPLE_THEO_MUC_DO.put(MucDo.KHO, 1);
    }

    public static int random(int begin, int end) {
        return ThreadLocalRandom.current().nextInt(begin, end + 1);
    }

}
