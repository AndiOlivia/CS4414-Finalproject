package com.jida.client;

public class DateHandler {

	/**
	 *
	 * @author Jianjie Zhou
	 * @param String: date_generated_by_JCalendarCombo
	 * @return <code>String formatted_date_recognizes_by_SQL_SERVER_2000</code>
	 * <p>This function takes in the JCalendarCombo generated date
	 * and formate it to the datetime format that sql server 2000
	 * recognizes.</p>
	 * <p><b>Examples:</b><br />
	 * <code>DateHandler.reformateDate("2008年8月8号 星期五")</code>
	 * returns <br />
	 * <code>2008-8-8</code>
	 *
	 */
	public static String reformateDate(String originalDate) {
		String date = originalDate.replace("年", "-").replace("月", "-").replace("日", "");
		String[] temp = date.split(" ");
		return temp[0];
	}

}
