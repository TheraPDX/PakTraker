package frames.admins.views.home;

/*
 * Created by Jonah on 5/1/2016.
 */

import javax.swing.*;
import java.awt.*;

public class AdminHomeView extends JPanel
{

    public AdminHomeView()
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