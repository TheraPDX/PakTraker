package frames.admins.children;

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

import models.employee.EmployeeTableModel;

import javax.swing.*;

public class ManipulateEmployeesPanel extends JPanel
{
    private final EmployeeTableModel employeeTableModel = new EmployeeTableModel(3, 1);
    private JTable employeesTable = new JTable(employeeTableModel);

    public ManipulateEmployeesPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //Employee Table Model
        employeeTableModel.addValueAt("Noah Manders #2", 1, 1);
        employeeTableModel.addValueAt("Luis Munoz", 2, 1);

        //Employee Table
    }

    private void addComponents()
    {
        add(employeesTable);
    }
}