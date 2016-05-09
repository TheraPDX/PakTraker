package models.employee;

/*
 * Created by Jonah on 5/7/2016.
 */

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class EmployeeTableModel extends AbstractTableModel
{
    private Vector<Object> content;
    int rows, columns;

    public EmployeeTableModel(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;

        content = new Vector<>(rows);
    }

    public void setRowCount(int rows)
    {
        this.rows = rows;
    }

    @Override
    public int getRowCount()
    {
        return content.size();
    }

    public void setColumnCount(int columns)
    {
        this.columns = columns;
    }

    @Override
    public int getColumnCount()
    {
        return columns;
    }

    @Override
    public String getColumnName(int column)
    {
        return "Employee Names";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return content.get(rowIndex);
    }

    public void addValueAt(Object value, int row, int column)
    {
        content.add(row, value);
        fireTableDataChanged();
    }
}