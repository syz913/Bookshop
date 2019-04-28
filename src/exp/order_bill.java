package exp;

import java.util.Calendar;

public class order_bill {

	public static String trans(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        StringBuilder sb = new StringBuilder();
        sb.append("bill_");
        sb.append(s);
        sb.append("_fduCS");
        return sb.toString();
    }
	
	public static String random_bill() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        StringBuilder sb = new StringBuilder();
        sb.append(c.get(Calendar.YEAR));
        sb.append(c.get(Calendar.MONTH));
        sb.append(c.get(Calendar.DAY_OF_MONTH));
        sb.append(c.get(Calendar.HOUR));
        sb.append(c.get(Calendar.MINUTE));
        sb.append(c.get(Calendar.SECOND));
  
        return sb.toString();
    }
}
