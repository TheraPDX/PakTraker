package frames.components.buttons;

/*
 * Created by Jonah on 5/28/2016.
 */

import javax.swing.*;
import java.awt.*;

import static frames.admins.views.main.AdminMainPanel.switchAdminView;

public class MenuButton extends JButton
{
    public MenuButton(String title, Color color, String view)
    {
        super(title);

        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(color);
        setMinimumSize(new Dimension(110, 25));
        setMaximumSize(new Dimension(110, 25));

        addActionListener(e -> switchAdminView(view));
    }
}