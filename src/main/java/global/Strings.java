package global;

/*
 * Created by Jonah on 5/28/2016.
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
