package frames.admins.children;

/*
 * Created by Jonah on 5/8/2016.
 */

import javax.swing.*;
import java.awt.*;

public class EmployeeTablePanel extends JPanel
{
    String[][] employees = {
            {"Noah Manders"},
            {"Luis Munoz"}
    };

    String[] columns = {"Employees"};

    private JTable employeesTable;
    private final JScrollPane tableScrollPane;

    public EmployeeTablePanel()
    {
        employeesTable = new JTable(employees, columns);
        tableScrollPane = new JScrollPane(employeesTable);

        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //Employees Table
        employeesTable.setPreferredScrollableViewportSize(new Dimension(175, 600));
        employeesTable.setFillsViewportHeight(true);
    }

    private void addComponents()
    {
        setLayout(new BorderLayout(0, 0));
        add(tableScrollPane);
    }
}