package frames.common.models;

/*
 * Created by Jonah on 5/31/2016.
 */

import frames.components.buttons.ActionButton;
import global.Strings;

import javax.swing.*;

public class ToolBarModel
{
    String userType;

    public ToolBarModel(String userType)
    {
        this.userType = userType;
    }

    private JButton[] getAdminStaffControlBtns()
    {
        ActionButton hireBtn = new ActionButton("Hire");
        ActionButton fireBtn = new ActionButton("Fire");
        ActionButton raiseBtn = new ActionButton("Raise");

        return new JButton[]{
                hireBtn, fireBtn, raiseBtn
        };
    }

    private JButton[] getAdminProductControlBtns()
    {
        ActionButton reupBtn = new ActionButton("Re-Up");

        return new JButton[]{
                reupBtn
        };
    }

    private JButton[] getAdminSalesBtns()
    {
        ActionButton totalSalesBtn = new ActionButton("Total Sales");

        return new JButton[]{
            totalSalesBtn
        };
    }

    public JButton[] getEmployViewBtns()
    {
        ActionButton someBtn = new ActionButton("Something");

        return new JButton[]{
                someBtn
        };
    }

    public JButton[] getButtonSet(String buttonSet)
    {
        switch(userType)
        {
            case Strings.ADMIN:
                switch(buttonSet)
                {
                    case "Employees":
                        return getAdminStaffControlBtns();
                    case "Product":
                        return getAdminProductControlBtns();
                    case "Sales":
                        return getAdminSalesBtns();
                    default:
                        return null;
                }

            case Strings.EMPLOYEE:
                switch(buttonSet)
                {
                    case "Employee View":
                        return getEmployViewBtns();
                    default:
                        return null;
                }

            default:
                return null;
        }
    }
}