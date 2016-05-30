package frames.admins.views.employeeControl;

/*
 * Created by Jonah on 5/8/2016.
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    ListSelectionModel cellSelectionModel;

    public EmployeeTablePanel()
    {
        employeesTable = new JTable();
        tableScrollPane = new JScrollPane(employeesTable);
        cellSelectionModel = employeesTable.getSelectionModel();

        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //Employees Table
        employeesTable.setModel(new DefaultTableModel(employees, columns){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        });

        employeesTable.setPreferredScrollableViewportSize(new Dimension(175, 600));
        employeesTable.setFillsViewportHeight(true);

        //Selection Model
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(e ->
        {
            if(!cellSelectionModel.getValueIsAdjusting())
            {
                int selectedRow = employeesTable.getSelectedRow();
                String data = (String) employeesTable.getValueAt(selectedRow, 0);
                System.out.println(data);
            }
        });
    }

    private void addComponents()
    {
        setLayout(new BorderLayout(0, 0));
        add(tableScrollPane);
    }


}