package frames.admins.controllers.employeeControl.children;

/*
 * Created by Jonah on 5/29/2016.
 */

import frames.admins.models.employeeControl.children.EmployeeTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class EmployeeTableController
{
    JTable table = new JTable();
    ListSelectionModel model;

    String[][] employees = {
            {"Jonah Stieglitz"},
            {"Noah Manders"},
            {"Luis Munoz"}
    };

    String[] columns = {"Employees"};

    public EmployeeTableController(JTable table, ListSelectionModel model)
    {
        this.table = table;
        this.model = model;
    }

    public DefaultTableModel getTableModel()
    {
        return new EmployeeTableModel(employees, columns);
    }

    public ListSelectionListener getSelectionListener()
    {
        return e ->
        {
            if(!model.getValueIsAdjusting())
            {
                int selectedRow = table.getSelectedRow();
                String data = (String) table.getValueAt(selectedRow, 0);
                System.out.println(data);
            }
        };
    }
}