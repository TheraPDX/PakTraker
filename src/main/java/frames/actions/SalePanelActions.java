package frames.actions;

/*
 * Created by Jonah on 5/28/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SalePanelActions
{
    public AbstractAction addAction(JPanel panel, JPanel panel2)
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.add(panel2, BorderLayout.LINE_END);

                panel.revalidate();
                panel.repaint();
            }
        };
    }

    public AbstractAction removeAction(JPanel panel, JPanel panel2)
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                panel.remove(panel2);

                panel.revalidate();
                panel.repaint();
            }
        };
    }
}