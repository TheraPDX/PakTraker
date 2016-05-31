package frames.common.controllers.toolbar;

/*
 * Created by Jonah on 5/31/2016.
 */

import frames.components.buttons.ActionButton;

import javax.swing.*;

public class ToolBarController
{

    public ToolBarController()
    {

    }

    public JButton[] getStaffControlBtns()
    {
        ActionButton hireBtn = new ActionButton("Hire");
        ActionButton fireBtn = new ActionButton("Fire");
        ActionButton raiseBtn = new ActionButton("Raise");

        return new JButton[]{
                hireBtn, fireBtn, raiseBtn
        };
    }
}