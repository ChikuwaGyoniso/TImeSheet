package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ChangeStringDate {
	public Date changeDate(String strDate) throws IllegalArgumentException {
		//SimpleDateFormatで書式設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		//java.util.DateのDateインスタンスを生成
		java.util.Date date = new java.util.Date();

		//入力値のString型をjava.util.Dateのformatから書式変更
		strDate = sdf.format(date);

		//java.sql.DateのvalueOfでsqlのDate型に変更
		Date date1 = Date.valueOf(strDate);

		return date1;
	}
}
