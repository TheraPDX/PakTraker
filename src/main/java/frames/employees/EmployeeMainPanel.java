package frames.employees;

/*
 * Created by Jonah on 5/6/2016.
 */

import frames.common.parents.TopPanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeMainPanel extends JPanel
{
    private final TopPanel topPanel = new TopPanel("Employee");

    public EmployeeMainPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.MAGENTA);
    }

    private void addComponents()
    {
        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
    }
}
