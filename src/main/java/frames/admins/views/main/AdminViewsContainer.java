package frames.admins.views.main;

/*
 * Created by Jonah on 5/1/2016.
 */

import javax.swing.*;
import java.awt.*;

public class AdminViewsContainer extends JPanel
{

    public AdminViewsContainer()
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
        //This
        add(new JLabel("Hello"));
    }
}