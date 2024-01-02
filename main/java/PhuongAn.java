public class PhuongAn {

	private String noiDung;

	private boolean chinhXac;

	public PhuongAn() {
	}

	public PhuongAn(String noiDung, boolean chinhXac) {
		this.noiDung = noiDung;
		this.chinhXac = chinhXac;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public boolean isChinhXac() {
		return chinhXac;
	}

	public void setChinhXac(boolean chinhXac) {
		this.chinhXac = chinhXac;
	}
}
