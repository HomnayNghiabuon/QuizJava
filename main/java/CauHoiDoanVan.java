import java.util.ArrayList;
import java.util.List;

public abstract class CauHoiDoanVan extends CauHoi {

	protected DoanVan doanVan;

	protected List<CauHoi> danhSachCauHoi= new ArrayList<>();

	public CauHoiDoanVan() {
	}

	public CauHoiDoanVan(String id, MucDo mucDo, DoanVan doanVan, List<CauHoi> danhSachCauHoi) {
		super(id, mucDo);
		this.doanVan = doanVan;
		this.danhSachCauHoi = danhSachCauHoi;
	}

	public DoanVan getDoanVan() {
		return doanVan;
	}

	public void setDoanVan(DoanVan doanVan) {
		this.doanVan = doanVan;
	}

	public List<CauHoi> getDanhSachCauHoi() {
		return danhSachCauHoi;
	}

	public void setDanhSachCauHoi(List<CauHoi> danhSachCauHoi) {
		this.danhSachCauHoi = danhSachCauHoi;
	}

	public String toString(){
		return String.format("%s", this.doanVan.toString());
	};

}
