package utils.datebase;

/*
 * Created by Jonah on 5/4/2016.
 */

import frames.actions.TextAction;

import javax.swing.*;
import java.awt.*;

public class LoginUtils
{
    SearchUtils searchUtils = new SearchUtils();

    public LoginUtils()
    {

    }

    public boolean correctAdminLogin(String user, char[] pass)
    {
        return searchUtils.adminDbContains("Username", user) && searchUtils.adminDbContains("Password", pass);
    }

    public boolean correctEmployeeLogin(String user, char[] pass)
    {
        return searchUtils.employeeDbContains("Username", user) && searchUtils.employeeDbContains("Password", pass);
    }

    public boolean correctCustomerLogin(String user, char[] pass)
    {
        return false;
    }

    public void incorrectLogin(JButton button)
    {
        Timer switchBtnTAC = new Timer(1500, TextAction.btnWarningAction(button, Color.RED, "Invalid Login", "Login"));
        switchBtnTAC.start();
    }
}
