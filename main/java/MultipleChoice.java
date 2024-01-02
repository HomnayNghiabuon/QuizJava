import java.util.List;

public class MultipleChoice extends CauHoiTracNghiem {

	private String noiDungCauHoi;

	private MultipleChoice next;

    public MultipleChoice() {
    }

    public MultipleChoice(String id, MucDo mucDo, DanhMuc danhMuc, List<PhuongAn> cacPhuongAn, String noiDungCauHoi) {
        super(id, mucDo, danhMuc, cacPhuongAn);
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public MultipleChoice(String id, MucDo mucDo, DanhMuc danhMuc, List<PhuongAn> cacPhuongAn, String noiDungCauHoi, MultipleChoice next) {
        super(id, mucDo, danhMuc, cacPhuongAn);
        this.noiDungCauHoi = noiDungCauHoi;
        this.next = next;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public MultipleChoice getNext() {
        return next;
    }

    public void setNext(MultipleChoice next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return null;
    }
}
