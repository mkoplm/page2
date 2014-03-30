package model.domain;

public class MediaDTO {
	
	private int mcode;
	private String mname;
	private String msinger;
	private int mdownload;
	private int mprice;
	private int limitage;
	
	public MediaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MediaDTO(int mcode, String mname, String msinger, int mdownload,
			int mprice, int limitage) {
		super();
		this.mcode = mcode;
		this.mname = mname;
		this.msinger = msinger;
		this.mdownload = mdownload;
		this.mprice = mprice;
		this.limitage = limitage;
	}

	public int getMcode() {
		return mcode;
	}

	public void setMcode(int mcode) {
		this.mcode = mcode;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMsinger() {
		return msinger;
	}

	public void setMsinger(String msinger) {
		this.msinger = msinger;
	}

	public int getMdownload() {
		return mdownload;
	}

	public void setMdownload(int mdownload) {
		this.mdownload = mdownload;
	}

	public int getMprice() {
		return mprice;
	}

	public void setMprice(int mprice) {
		this.mprice = mprice;
	}

	public int getLimitage() {
		return limitage;
	}

	public void setLimitage(int limitage) {
		this.limitage = limitage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(mcode);
		builder.append("\t| ");
		builder.append(mname);
		builder.append("\t| ");
		builder.append(msinger);
		builder.append("\t| ");
		builder.append(mdownload);
		builder.append("\t| ");
		builder.append(mprice);
		builder.append("\t| ");
		builder.append(limitage);
		return builder.toString();
	}
	
}
