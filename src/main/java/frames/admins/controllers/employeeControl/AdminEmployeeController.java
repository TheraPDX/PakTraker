package frames.admins.controllers.employeeControl;

/*
 * Created by Jonah on 5/29/2016.
 */

import frames.interfaces.controllers.IMainController;

import javax.swing.*;
import java.awt.*;

public class AdminEmployeeController implements IMainController
{
    JPanel panel = new JPanel();
    CardLayout cardLayout = new CardLayout();

    public AdminEmployeeController(JPanel panel, CardLayout cardLayout)
    {
        this.panel = panel;
        this.cardLayout = cardLayout;
    }

    public AdminEmployeeController(JPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void switchView(String view)
    {
        cardLayout.show(panel, view);
    }
}
