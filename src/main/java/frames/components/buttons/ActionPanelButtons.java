package frames.components.buttons;

/*
 * Created by Jonah on 5/28/2016.
 */

import javax.swing.*;

public class ActionPanelButtons
{

    public static JButton[] getStaffControlBtns()
    {
        ActionButton hireBtn = new ActionButton("Hire");
        ActionButton fireBtn = new ActionButton("Fire");
        ActionButton raiseBtn = new ActionButton("Raise");

        return new JButton[]{
            hireBtn, fireBtn, raiseBtn
        };
    }
}
