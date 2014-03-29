package model.domain;

public class CustomerDTO {
	private String cusId;
	private String cusName;
	private int cusAge;
	private int cusMoney;
	private int mcode;
	
	
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerDTO(String cusId, String cusName, int cusAge, int cusMoney,
			int mcode) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusAge = cusAge;
		this.cusMoney = cusMoney;
		this.mcode = mcode;
	}


	public String getCusId() {
		return cusId;
	}


	public void setCusId(String cusId) {
		this.cusId = cusId;
	}


	public String getCusName() {
		return cusName;
	}


	public void setCusName(String cusName) {
		this.cusName = cusName;
	}


	public int getCusAge() {
		return cusAge;
	}


	public void setCusAge(int cusAge) {
		this.cusAge = cusAge;
	}


	public int getCusMoney() {
		return cusMoney;
	}


	public void setCusMoney(int cusMoney) {
		this.cusMoney = cusMoney;
	}


	public int getMcode() {
		return mcode;
	}


	public void setMcode(int mcode) {
		this.mcode = mcode;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDTO [cusId=");
		builder.append(cusId);
		builder.append(", cusName=");
		builder.append(cusName);
		builder.append(", cusAge=");
		builder.append(cusAge);
		builder.append(", cusMoney=");
		builder.append(cusMoney);
		builder.append(", mcode=");
		builder.append(mcode);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
