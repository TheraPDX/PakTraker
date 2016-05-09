package frames.common;

/*
 * Created by Jonah on 5/5/2016.
 */

import frames.admins.children.employeeControls.EmployeeTablePanel;

import javax.swing.*;
import java.awt.*;

public class ShowSalePanel extends JPanel
{
    private final JButton showSalePanelBtn = new JButton("Sale");

    private final EmployeeTablePanel employeeTablePanel = new EmployeeTablePanel();

    public ShowSalePanel(Color color)
    {
        initComponents(color);
        addComponents();
    }

    private void initComponents(Color color)
    {
        //This
        setBackground(color);

        //Employee Table Panel
        employeeTablePanel.setBackground(color);
        employeeTablePanel.setAlignmentX(RIGHT_ALIGNMENT);

        //Show Sale Panel Button
        showSalePanelBtn.setPreferredSize(new Dimension(75, 50));
        showSalePanelBtn.setAlignmentX(RIGHT_ALIGNMENT);
    }

    private void addComponents()
    {
        //This
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(showSalePanelBtn);
        //add(employeeTablePanel);
    }

    public void addButtonAction(AbstractAction action)
    {
        showSalePanelBtn.addActionListener(action);
    }
}