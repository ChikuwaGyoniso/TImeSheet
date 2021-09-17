package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ChangeStringDate {
	public Date changeDate(String strDate) throws IllegalArgumentException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date = new java.util.Date();

		strDate = sdf.format(date);

		Date date1 = Date.valueOf(strDate);

		return date1;
	}
}
