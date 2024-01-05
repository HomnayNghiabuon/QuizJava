import java.util.List;

public class Incomple extends CauHoiDoanVan {
	public Incomple() {
	}

	public Incomple(String id, MucDo mucDo, DoanVan doanVan, List<CauHoi> danhSachCauHoi) {
		super(id, mucDo, doanVan, danhSachCauHoi);
	}

	public String toString() {
		String temp = "";
		for(CauHoi cauHoi:this.danhSachCauHoi){
			temp += ((CauHoiTracNghiem)cauHoi).toString();
		}
		return String.format("%s\n%s", this.getDoanVan().toString(), temp);
	}

}
