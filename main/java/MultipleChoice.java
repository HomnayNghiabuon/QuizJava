import java.util.List;

public class MultipleChoice extends CauHoiTracNghiem {

	protected String noiDungCauHoi;


    public MultipleChoice() {
    }

    public MultipleChoice(String id, MucDo mucDo, DanhMuc danhMuc, List<PhuongAn> cacPhuongAn, String noiDungCauHoi) {
        super(id, mucDo, danhMuc, cacPhuongAn);
        this.noiDungCauHoi = noiDungCauHoi;
    }



    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }


    @Override
    public String toString() {
        return null;
    }
}
