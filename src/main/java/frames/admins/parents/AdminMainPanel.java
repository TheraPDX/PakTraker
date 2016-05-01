package frames.admins.parents;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.children.TopAdminPanel;
import frames.interfaces.panels.MainPanelI;

import javax.swing.*;
import java.awt.*;

public class AdminMainPanel extends JPanel implements MainPanelI
{

    public AdminMainPanel()
    {
        initComponents();
        addComponents();
    }

    @Override
    public void initComponents()
    {
        setBackground(Color.blue);
    }

    @Override
    public void addComponents()
    {
        add(new TopAdminPanel(), BorderLayout.NORTH);
    }
}