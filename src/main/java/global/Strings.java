package global;

/*
 * Created by Jonah on 5/28/2016.
 */

public class Strings
{
    //Cur User
    public static String CUR_USER;
    public static String CUR_USER_TYPE = "A";

    //User Types
    public static final String ADMIN = "Admin";
    public static final String EMPLOYEE = "Employee";
    public static final String CUSTOMER = "Customer";

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
