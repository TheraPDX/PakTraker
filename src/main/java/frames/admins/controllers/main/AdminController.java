package frames.admins.controllers.main;

/*
 * Created by Jonah on 5/24/2016.
 */

import global.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminController
{
    static CardLayout cardLayout;
    static JPanel container;

    public AdminController(CardLayout cardLayout1, JPanel container1)
    {
        cardLayout = cardLayout1;
        container = container1;
    }

    public static void switchAdminView(String view)
    {
        switch(view)
        {
            case Views.ADMIN_MAIN:
                //actionPanel.setVisible(false);
                cardLayout.show(container, view);
                break;
            case Views.ADMIN_EMPLOYEE_CONTROLLER:
                //actionPanel.setCurBtns(staffControlBtns());
                //actionPanel.setVisible(true);
                cardLayout.show(container, view);
                break;
            case Views.SETTINGS:
                //Add each viewAsString switch handling here
                cardLayout.show(container, view);
                break;
            default:
                break;
        }
    }

    public AbstractAction getQsHideAction(JPanel panel, JPanel panel1)
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.remove(panel1);

                panel.revalidate();
                panel.repaint();
            }
        };
    }
}