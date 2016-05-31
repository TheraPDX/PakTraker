package frames.admins.views.staffControl;

/*
 * Created by Jonah on 5/7/2016.
 */

/*
    - Hire Employee
    - Fire Employee
    - List Of Employees
    - Individual Employee Detail
        - Social
        - DOB
        - Years W. Company
        - Total Sales, All time, Weekly, Daily
        - Total Hours
    - Pay Rate, Raises
    - Change Employees To Admins
 */

import frames.admins.views.staffControl.children.StaffTableView;

import javax.swing.*;
import java.awt.*;

public class StaffControlView extends JPanel
{
    private final StaffTableView staffTableView = new StaffTableView();

    public StaffControlView()
    {
        initComponents();
        addComponents();
    }

    public void initComponents()
    {
        setBackground(Color.CYAN);
    }

    public void addComponents()
    {
        setLayout(new BorderLayout(0, 0));

        add(new JScrollPane(staffTableView), BorderLayout.EAST);
    }
}