import java.util.List;

public class Conversation extends CauHoiDoanVan {
	public Conversation() {
	}

	public Conversation(String id, MucDo mucDo, DoanVan doanVan, List<CauHoi> danhSachCauHoi) {
		super(id, mucDo, doanVan, danhSachCauHoi);
	}

	public String toString() {
		String temp = "";
		for(CauHoi cauHoi:this.danhSachCauHoi){
			temp += cauHoi.toString();
		}
		return String.format("%s\n%s", this.getDoanVan().toString(), temp);
	}

}
