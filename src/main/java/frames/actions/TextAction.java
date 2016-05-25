package frames.actions;

/*
 * Created by Jonah on 4/30/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextAction
{
    public TextAction()
    {

    }

    public static AbstractAction btnWarningAction(JButton button, Color color, String warningMsg, String finalMsg)
    {
        button.setText(warningMsg);
        button.setForeground(color);

        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                button.setText(finalMsg);
                button.setForeground(null);
            }
        };
    }
}