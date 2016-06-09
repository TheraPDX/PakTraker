package frames.components.buttons;

/*
 * Created by Jonah on 5/28/2016.
 */

import javax.swing.*;
import java.awt.*;

import static frames.admins.controllers.main.AdminController.switchAdminView;
import static frames.admins.views.main.AdminView.addToolbar;
import static frames.admins.views.main.AdminView.removeToolbar;

public class MenuButton extends JButton
{
    public MenuButton(String title, Color color, String view, boolean showToolbar)
    {
        super(title);

        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(color);
        setMinimumSize(new Dimension(110, 25));
        setMaximumSize(new Dimension(110, 25));

        System.out.println("Menu Button View: " + view);

        addActionListener(e ->
        {
            if(showToolbar)
            {
                addToolbar(title);
                switchAdminView(view);
            }
            else
            {
                removeToolbar();
                switchAdminView(view);
            }
        });
    }
}