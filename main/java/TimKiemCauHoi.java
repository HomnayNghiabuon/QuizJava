import java.util.List;

public interface TimKiemCauHoi {

	public abstract List<CauHoi> timKiemCauHoi();

	public abstract List<CauHoi> timKiemCauHoi(DanhMuc danhMuc);

	public abstract List<CauHoi> timKiemCauHoi(MucDo mucDo);

}
