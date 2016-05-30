package frames.admins.views.employeeControl.children;

/*
 * Created by Jonah on 5/8/2016.
 */

import frames.admins.controllers.employeeControl.children.EmployeeTableController;

import javax.swing.*;
import java.awt.*;

public class EmployeeTableView extends JTable
{
    ListSelectionModel cellSelectionModel;
    EmployeeTableController tableController;

    public EmployeeTableView()
    {
        cellSelectionModel = this.getSelectionModel();
        tableController = new EmployeeTableController(this, cellSelectionModel);

        initComponents();
    }

    private void initComponents()
    {
        //This
        setModel(tableController.getTableModel());
        setPreferredScrollableViewportSize(new Dimension(175, 600));
        setFillsViewportHeight(true);

        //Selection Model
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(tableController.getSelectionListener());
    }
}