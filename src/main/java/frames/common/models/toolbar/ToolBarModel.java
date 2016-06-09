package frames.common.models.toolbar;

/*
 * Created by Jonah on 5/31/2016.
 */

import frames.components.buttons.ActionButton;

import javax.swing.*;

public class ToolBarModel
{
    public ToolBarModel()
    {

    }

    private JButton[] getStaffControlBtns()
    {
        ActionButton hireBtn = new ActionButton("Hire");
        ActionButton fireBtn = new ActionButton("Fire");
        ActionButton raiseBtn = new ActionButton("Raise");

        return new JButton[]{
                hireBtn, fireBtn, raiseBtn
        };
    }

    private JButton[] getProductControlBtns()
    {
        ActionButton reupBtn = new ActionButton("Re-Up");

        return new JButton[] {
                reupBtn
        };
    }

    private JButton[] getSalesBtns()
    {
        ActionButton totalSalesBtn = new ActionButton("Total Sales");

        return new JButton[]{
            totalSalesBtn
        };
    }

    public JButton[] getButtonSet(String buttonSet)
    {
        switch(buttonSet)
        {
            case "Employees":
                return getStaffControlBtns();
            case "Product":
                return getProductControlBtns();
            case "Sales":
                return getSalesBtns();
            default:
                return null;
        }
    }
}