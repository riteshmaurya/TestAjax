package com.baj.action;

public class Country1 {

	private int SERIAL_NO;
	private int C_CODE;
	private String C_NAME;
	
	
	
	
	
	public int getSERIAL_NO() {
		return SERIAL_NO;
	}
	public void setSERIAL_NO(int sERIAL_NO) {
		SERIAL_NO = sERIAL_NO;
	}
	public int getC_CODE() {
		return C_CODE;
	}
	public void setC_CODE(int c_CODE) {
		C_CODE = c_CODE;
	}
	public String getC_NAME() {
		return C_NAME;
	}
	public void setC_NAME(String c_NAME) {
		C_NAME = c_NAME;
	}
	@Override
	public String toString() {
		return "Country1 [SERIAL_NO=" + SERIAL_NO + ", C_CODE=" + C_CODE
				+ ", C_NAME=" + C_NAME + "]";
	}
	
	
}
