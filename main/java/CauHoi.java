public abstract class CauHoi {

	protected String id;
	MucDo mucDo;
	public CauHoi() {
	}

	public CauHoi(String id, MucDo mucDo) {
		this.id = id;
		this.mucDo = mucDo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MucDo getMucDo() {
		return mucDo;
	}

	public void setMucDo(MucDo mucDo) {
		this.mucDo = mucDo;
	}

	@Override

	public String toString(){
		return String.format("Question %s.", this.id);
	}
}
