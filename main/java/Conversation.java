import java.util.List;

public class Conversation extends CauHoiDoanVan {
	public Conversation() {
	}

	public Conversation(String id, MucDo mucDo, DoanVan doanVan, List<CauHoi> danhSachCauHoi) {
		super(id, mucDo, doanVan, danhSachCauHoi);
	}

	public String toString() {
		return null;
	}

}
