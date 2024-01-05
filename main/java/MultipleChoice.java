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
        String kq = "";
        for(PhuongAn p:this.cacPhuongAn){
            kq += p.toString();
            kq += "\n";
        }
        return String.format("Question %d. %s. \n%s", dem++, this.noiDungCauHoi, kq);
    }
}
