package frames.common.models.login;

/*
 * Created by Jonah on 5/30/2016.
 */

public class LoginModel
{

    public boolean validAdminAcct(String user, char[] pass)
    {
        if(user.equals("User In DB") && pass.length > 7)
        {
            return true;
        }
        else
        {
            return true;
        }
    }

    public boolean validEmployeeAcct(String user, char[] pass)
    {
        if(user.equals("User In DB") && pass.length > 7)
        {
            return true;
        }
        else
        {
            return true;
        }
    }

    public boolean validCustomerAcct(String user, char[] pass)
    {
        if(user.equals("User In DB") && pass.length > 7)
        {
            return false;
        }
        else
        {
            return false;
        }
    }
}
