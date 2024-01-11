import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConversationFactory implements TaoCauHoiDoanVan{

	public CauHoi taoCauHoiTuFile(MucDo mucDo) {
		String data = "";
		CauHoi conversation = new Conversation();
		try {
			FileReader fileReader = new FileReader("src/main/resources/CauHoi/Conversation/"+mucDo+"/CauHoi.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			String idCanDoc = String.format("%03d",CauHinh.random(1,CauHinh.SO_CAU_HOI_INCOMPLE_THEO_MUC_DO.get(mucDo)));
			boolean flag = false;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.equals("ThongTinDoanVan") && (line = bufferedReader.readLine()).contains(idCanDoc)){
					data += line;
					while((line = bufferedReader.readLine()) != null){
						if(line.equals("ThongTinDoanVan")) break;
						data+=line;
					}
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] mangData = data.strip().split("ThongTinCacCauHoi");
		String thongTinDoanVan = mangData[0];
		String thongTinCacCauHoi = mangData[1];
		String[] mangThongTinDoanVan = thongTinDoanVan.split("#");
		int i = 0;
		String idCauHoiDoanVan = mangThongTinDoanVan[i++];
		MucDo mucDoCauHoiDoanVan = MucDo.valueOf(mangThongTinDoanVan[i++]);
		DoanVan doanVan = new DoanVan(mangThongTinDoanVan[i++]);
		List<CauHoi> danhSachCauHoi = new ArrayList<>();
		String[] danhSachCacCauHoi = thongTinCacCauHoi.split("&");
		for(String cauHoi:danhSachCacCauHoi){
			String[] dataCauHoi = cauHoi.split("#");
			int j = 0;
			String idCauHoi = dataCauHoi[j++];
			MucDo mucDoCauHoi = MucDo.valueOf(dataCauHoi[j++]);
			DanhMuc danhMucCauHoi = DanhMuc.valueOf(dataCauHoi[j++]);
			String noiDungCauHoi = dataCauHoi[j++];
			List<PhuongAn> cacPhuongAn = new ArrayList<>();
			int viTriPhuongAnDungTrongData = dataCauHoi[dataCauHoi.length-1].charAt(0) - 65 + j;
			while (j<dataCauHoi.length-1){
				cacPhuongAn.add(new PhuongAn(dataCauHoi[j], j == viTriPhuongAnDungTrongData));
				j++;
			}
			danhSachCauHoi.add(new MultipleChoice(idCauHoi, mucDoCauHoi, danhMucCauHoi, cacPhuongAn, noiDungCauHoi));
		}
		conversation.setId(idCauHoiDoanVan);
		conversation.setMucDo(mucDoCauHoiDoanVan);
		((Conversation)conversation).setDoanVan(doanVan);
		((Conversation)conversation).setDanhSachCauHoi(danhSachCauHoi);
		return conversation;
	}

}
