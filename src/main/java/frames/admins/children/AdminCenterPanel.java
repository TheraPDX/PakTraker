package frames.admins.children;

/*
 * Created by Jonah on 5/1/2016.
 */

import frames.interfaces.panels.MainPanelI;

import javax.swing.*;
import java.awt.*;

public class AdminCenterPanel extends JPanel implements MainPanelI
{

    public AdminCenterPanel()
    {
        initComponents();
        addComponents();
    }

    @Override
    public void initComponents()
    {
        //This
        setBackground(Color.CYAN);
    }

    @Override
    public void addComponents()
    {
        add(new JLabel("Hello"));
    }

    @Override
    public Dimension getPreferredSize()
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        return new Dimension((screen.width / 10) * 7, screen.height);
    }
}