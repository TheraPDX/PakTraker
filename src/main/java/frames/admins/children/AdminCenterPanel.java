package frames.admins.children;

/*
 * Created by Jonah on 5/1/2016.
 */

import javax.swing.*;
import java.awt.*;

public class AdminCenterPanel extends JPanel
{

    public AdminCenterPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.CYAN);
    }

    private void addComponents()
    {
        add(new JLabel("Hello"));
    }
}