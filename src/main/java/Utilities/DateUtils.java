package Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

	public static String getTodaysDate() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return formatter.format(date);

	}

	public static long diff(String DOB, String condition) throws ParseException {

		SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy");

		Date date2 = obj.parse(getTodaysDate());
		Date date1 = obj.parse(DOB);

		long time_difference = date2.getTime() - date1.getTime();

		long days_difference = TimeUnit.MILLISECONDS.toDays(time_difference) % 365;

		long years_difference = TimeUnit.MILLISECONDS.toDays(time_difference) / 365l;

		long difference = (condition.equals("days")) ? days_difference : years_difference;

		return difference;
	}
	
	public static void main(String[] args) throws ParseException {
		
		
		System.out.println(diff("18/08/2023","days"));
	}

	

}
