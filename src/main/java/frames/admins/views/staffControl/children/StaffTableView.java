package frames.admins.views.staffControl.children;

/*
 * Created by Jonah on 5/8/2016.
 */

import frames.admins.controllers.staffControl.children.StaffTableController;

import javax.swing.*;
import java.awt.*;

public class StaffTableView extends JTable
{
    ListSelectionModel cellSelectionModel;
    StaffTableController tableController;

    public StaffTableView()
    {
        cellSelectionModel = this.getSelectionModel();
        tableController = new StaffTableController(this, cellSelectionModel);

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