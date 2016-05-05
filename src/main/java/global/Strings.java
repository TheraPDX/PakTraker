package global;

/*
 * Created by Jonah on 4/30/2016.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Strings
{
    //Cur User
    public static final String CUR_USER = "Jonah Stieglitz";
    public static final String CUR_USER_TYPE = "A";

    //User Types
    public static final String ADMIN = "A";
    public static final String EMPLOYEE = "E";
    public static final String CUSTOMER_PROFILE = "CP";
    public static final String GUEST = "G";

    //Different Views
    public static final String LOGIN_VIEW = "Login";
    public static final String ADMIN_VIEW = "Admin";
    public static final String EMPLOYEE_VIEW = "Employee";
    public static final String CUSTOMER_PROFILE_VIEW = "Customer";
    public static final String SETTINGS_VIEW = "Settings";
    public static final String MY_STATS_VIEW = "Stats";

    //Time and Date
    static DateFormat date = new SimpleDateFormat("M/dd/yy");
    static DateFormat time = new SimpleDateFormat("h:mm");
    static Calendar calendar = Calendar.getInstance();

    public static String TIME = time.format(calendar.getTime());
    public static String DATE = date.format(calendar.getTime());

    public Strings(){}
}
