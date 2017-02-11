package fx;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CommonMethod {
	//現在時刻を取得する関数
	public static String getDate(){
		String dateStr = "";
		Calendar calendar = Calendar.getInstance(Locale.JAPAN);
                DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                dateStr = dateformat.format(calendar.getTime());
                return dateStr;
	}
}
