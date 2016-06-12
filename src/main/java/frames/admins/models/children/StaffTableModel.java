package frames.admins.models.children;

/*
 * Created by Jonah on 5/29/2016.
 */

import javax.swing.table.DefaultTableModel;

public class StaffTableModel extends DefaultTableModel
{
    public StaffTableModel(String[][] employees, String[] columns)
    {
        super(employees, columns);
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}