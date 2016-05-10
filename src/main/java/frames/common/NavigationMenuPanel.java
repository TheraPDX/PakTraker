package frames.common;

/*
 * Created by Jonah on 5/10/2016.
 */

import global.Colors;
import global.Dimensions;
import global.Strings;

import javax.swing.*;
import java.awt.*;

import static frames.admins.AdminMainPanel.switchAdminView;

public class NavigationMenuPanel extends JPanel
{
    private final JButton quickSaleBtn = new JButton("Quick Sale");

    private final JButton homeBtn = new JButton("Home");

    private final JButton employeeInfoBtn = new JButton("Employees");

    private final Dimension btnDimension = new Dimension(100, 25);

    public NavigationMenuPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This

        //Quick Sale Button
        quickSaleBtn.setBackground(Color.RED);
        quickSaleBtn.setAlignmentX(CENTER_ALIGNMENT);

        //Home Button
        homeBtn.setBackground(Colors.menuBtnColor);
        homeBtn.setAlignmentX(CENTER_ALIGNMENT);
        homeBtn.setMinimumSize(btnDimension);
        homeBtn.setMaximumSize(btnDimension);
        homeBtn.addActionListener(e1 -> switchAdminView("Main View"));

        //Employee Info Button
        employeeInfoBtn.setBackground(Colors.menuBtnColor);
        employeeInfoBtn.setAlignmentX(CENTER_ALIGNMENT);
        employeeInfoBtn.addActionListener(e -> switchAdminView(Strings.MANIP_EMPLOYEES_VIEW));
    }

    private void addComponents()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(5));
        add(quickSaleBtn);
        add(Box.createVerticalStrut(20));
        add(homeBtn);
        add(Box.createVerticalStrut(10));
        add(employeeInfoBtn);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(150, Dimensions.screen.height);
    }

    public void addQuickSaleBtnAction(AbstractAction action)
    {
        quickSaleBtn.addActionListener(action);
    }
}