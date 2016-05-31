package frames.components.buttons;

/*
 * Created by Jonah on 5/28/2016.
 */

import javax.swing.*;
import java.awt.*;

import static frames.admins.controllers.main.AdminController.switchAdminView;

public class MenuButton extends JButton
{
    String view;

    public MenuButton(String title, Color color, String view)
    {
        super(title);

        this.view = view;

        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(color);
        setMinimumSize(new Dimension(110, 25));
        setMaximumSize(new Dimension(110, 25));

        System.out.println("Menu Button View: " + view);

        addActionListener(e -> switchAdminView(view));
    }
}