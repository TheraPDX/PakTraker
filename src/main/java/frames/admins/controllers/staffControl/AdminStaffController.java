package frames.admins.controllers.staffControl;

/*
 * Created by Jonah on 5/29/2016.
 */

import javax.swing.*;
import java.awt.*;

public class AdminStaffController
{
    JPanel panel = new JPanel();
    CardLayout cardLayout = new CardLayout();

    public AdminStaffController(JPanel panel, CardLayout cardLayout)
    {
        this.panel = panel;
        this.cardLayout = cardLayout;
    }

    public AdminStaffController(JPanel panel)
    {
        this.panel = panel;
    }

    public void switchView(String view)
    {
        cardLayout.show(panel, view);
    }
}
