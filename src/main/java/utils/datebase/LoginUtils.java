package utils.datebase;

/*
 * Created by Jonah on 5/4/2016.
 */

import frames.actions.TextAction;
import global.Strings;

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
        Strings.CUR_USER = user;
        Strings.CUR_USER_TYPE = Strings.ADMIN;

        return searchUtils.adminDbContains("Username", user) && searchUtils.adminDbContains("Password", pass);
    }

    public boolean correctEmployeeLogin(String user, char[] pass)
    {
        Strings.CUR_USER = user;
        Strings.CUR_USER_TYPE = Strings.EMPLOYEE;

        return searchUtils.employeeDbContains("Username", user) && searchUtils.employeeDbContains("Password", pass);
    }

    public boolean correctCustomerLogin(String user, char[] pass)
    {
        Strings.CUR_USER = user;
        Strings.CUR_USER_TYPE = Strings.CUSTOMER;
        return false;
    }

    public void incorrectLogin(JButton button)
    {
        Timer switchBtnTAC = new Timer(1500, TextAction.btnWarningAction(button, Color.RED, "Invalid Login", "Login"));
        switchBtnTAC.start();
    }
}
