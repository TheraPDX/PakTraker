package frames.common.controllers.navMenu;

/*
 * Created by Jonah on 5/30/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NavMenuController
{
    public NavMenuController()
    {

    }

    public AbstractAction getQsShowAction(JPanel panel, JPanel panel1)
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.add(panel1, BorderLayout.LINE_END);

                panel.revalidate();
                panel.repaint();
            }
        };
    }
}
