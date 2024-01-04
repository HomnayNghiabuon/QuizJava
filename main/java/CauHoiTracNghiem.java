import java.util.Arrays;
import java.util.List;

public class CauHoiTracNghiem extends CauHoi {
	protected DanhMuc danhMuc;
	protected List<PhuongAn> cacPhuongAn;


	public CauHoiTracNghiem() {
	}

public CauHoiTracNghiem(String id, MucDo mucDo, DanhMuc danhMuc, List<PhuongAn> cacPhuongAn) {
		super(id, mucDo);
		this.danhMuc = danhMuc;
		this.cacPhuongAn = cacPhuongAn;
	}

	public List<PhuongAn> getCacPhuongAn() {
		return cacPhuongAn;
	}
	public void setCacPhuongAn(List<PhuongAn> cacPhuongAn) {
		this.cacPhuongAn = cacPhuongAn;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public int chonDapAn(int index) {
		return 0;
	}

	@Override
	public String toString() {
		return null;
	}
}
