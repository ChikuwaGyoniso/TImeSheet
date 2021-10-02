package model;

import java.io.Serializable;

public class YearAndMonth implements Serializable {
	private String year;
	private String month;

	public YearAndMonth() {

	}

	public YearAndMonth(String year, String month) {
		this.year = year;
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}
}
