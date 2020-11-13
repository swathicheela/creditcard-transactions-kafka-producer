package com.myhu.cheela.pojo;


public class Transaction {
	
	private String custId;
	private String firstName;
	private String lastName;
	private String txnId;
	private String txnTime;
	private String Category;
	private String merchant;
	private String TxnAmnt;
	private String longi;
	private String Lat;
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String string) {
		this.txnTime = string;
	}

	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getTxnAmnt() {
		return TxnAmnt;
	}
	public void setTxnAmnt(String txnAmnt) {
		TxnAmnt = txnAmnt;
	}
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	
	@Override
	public String toString() {
		return "Transaction [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", txnId="
				+ txnId + ", txnTime=" + txnTime + ", Category=" + Category + ", merchant=" + merchant + ", TxnAmnt="
				+ TxnAmnt + ", longi=" + longi + ", Lat=" + Lat + "]";
	}
}
