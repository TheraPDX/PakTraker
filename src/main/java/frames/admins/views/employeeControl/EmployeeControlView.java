package frames.admins.views.employeeControl;

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

import javax.swing.*;
import java.awt.*;

public class EmployeeControlView extends JPanel
{
    private final EmployeeTablePanel employeeTablePanel = new EmployeeTablePanel();

    public EmployeeControlView()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        setBackground(Color.CYAN);
    }

    private void addComponents()
    {
        setLayout(new BorderLayout(0, 0));

        add(employeeTablePanel, BorderLayout.EAST);
    }
}