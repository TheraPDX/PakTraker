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

import frames.admins.controllers.employeeControl.AdminEmployeeController;
import frames.admins.views.employeeControl.children.EmployeeTableView;
import frames.interfaces.views.IMainView;

import javax.swing.*;
import java.awt.*;

public class EmployeeControlView extends JPanel implements IMainView
{
    private final EmployeeTableView employeeTableView = new EmployeeTableView();
    private final AdminEmployeeController adminEmployeeController = new AdminEmployeeController(this);

    public EmployeeControlView()
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

        add(new JScrollPane(employeeTableView), BorderLayout.EAST);
    }
}