package org.jcarande.proyetoDAW.dtos;

public class BalanceRecoveryDto {
	
	private String month;
	private Integer year;
	private Float positive;
	private Float negative;
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Float getPositive() {
		return positive;
	}
	public void setPositive(Float positive) {
		this.positive = positive;
	}
	public Float getNegative() {
		return negative;
	}
	public void setNegative(Float negative) {
		this.negative = negative;
	}
	
}
