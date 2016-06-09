package frames.components.buttons;

/*
 * Created by Jonah on 5/28/2016.
 */

import global.Colors;

import javax.swing.*;
import java.awt.*;

import static frames.admins.views.main.AdminView.showToolbar;
import static frames.admins.views.main.AdminView.switchAdminView;

public class MenuButton extends JButton
{
    public MenuButton(String title, String view, boolean toolBarVisible)
    {
        super(title);

        setAlignmentX(CENTER_ALIGNMENT);
        setBackground(Colors.menuBtnColor);
        setMinimumSize(new Dimension(110, 25));
        setMaximumSize(new Dimension(110, 25));

        addActionListener(e ->
        {
            showToolbar(toolBarVisible, title);
            switchAdminView(view);
        });
    }
}