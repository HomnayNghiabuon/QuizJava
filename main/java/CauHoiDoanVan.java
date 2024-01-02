public abstract class CauHoiDoanVan extends CauHoi {

	private DoanVan doanVan;

	private CauHoi cauHoiHead;

	public CauHoiDoanVan() {
	}

	public CauHoiDoanVan(String id, MucDo mucDo, DoanVan doanVan, CauHoi cauHoiHead) {
		super(id, mucDo);
		this.doanVan = doanVan;
		this.cauHoiHead = cauHoiHead;
	}

	public DoanVan getDoanVan() {
		return doanVan;
	}

	public void setDoanVan(DoanVan doanVan) {
		this.doanVan = doanVan;
	}

	public CauHoi getCauHoiHead() {
		return cauHoiHead;
	}

	public void setCauHoiHead(CauHoi cauHoiHead) {
		this.cauHoiHead = cauHoiHead;
	}

	public abstract String toString();

}
