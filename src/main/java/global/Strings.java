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
    public static String CUR_USER;
    public static String CUR_USER_TYPE = "A";

    //User Types
    public static final String ADMIN = "Admin";
    public static final String EMPLOYEE = "Employee";
    public static final String CUSTOMER = "Customer";

    //Different Views
    public static final String LOGIN_VIEW = "Login";
    public static final String ADMIN_VIEW = "Admin";
    public static final String EMPLOYEE_VIEW = "Employee";
    public static final String MANIP_EMPLOYEES_VIEW = "Manipulate Employees";
    public static final String CUSTOMER_PROFILE_VIEW = "Customer";
    public static final String SETTINGS_VIEW = "Settings";
    public static final String MY_STATS_VIEW = "Stats";
    public static final String PRODUCT_INFO_VIEW = "Product Info";
    public static final String SALES_INFO_VIEW = "Sales Info";
    public static final String MAIN_ADMIN_VIEW = "Admin Main";

    //Time and Date
    static DateFormat date = new SimpleDateFormat("M/dd/yy");
    static DateFormat time = new SimpleDateFormat("h:mm");
    static Calendar calendar = Calendar.getInstance();

    public static String TIME = time.format(calendar.getTime());
    public static String DATE = date.format(calendar.getTime());



    public Strings(){}

    public static void setCurUser(String user)
    {
        CUR_USER = user;
    }

    public static String getCurUser()
    {
        return CUR_USER;
    }
}
