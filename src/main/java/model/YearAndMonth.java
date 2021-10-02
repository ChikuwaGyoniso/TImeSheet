package model;

import java.io.Serializable;

public class YearAndMonth implements Serializable {
	private int year;
	private int month;

	public YearAndMonth() {

	}

	public YearAndMonth(int year, int month) {
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}
}
