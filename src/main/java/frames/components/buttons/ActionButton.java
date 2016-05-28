package frames.components.buttons;

/*
 * Created by Jonah on 5/28/2016.
 */

import javax.swing.*;
import java.awt.*;

public class ActionButton extends JButton
{

    public ActionButton(String text, Color color)
    {
        super(text);

        setBackground(color);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(90, 30);
    }
}
