package frames.common.panels;

/*
 * Created by Jonah on 5/10/2016.
 */

import frames.components.buttons.MenuButton;
import global.Colors;
import global.Dimensions;
import global.Views;

import javax.swing.*;
import java.awt.*;

public class NavigationMenuPanel extends JPanel
{
    private final JButton quickSaleBtn = new JButton("Quick Sale");

    private final MenuButton homeBtn = new MenuButton("Home", Colors.menuBtnColor, Views.ADMIN_MAIN);
    private final MenuButton employeeInfoBtn = new MenuButton("Employees", Colors.menuBtnColor, Views.ADMIN_EMPLOYEE_CONTROLLER);
    private final MenuButton productBtn = new MenuButton("Product", Colors.menuBtnColor, Views.ADMIN_PRODUCT_INFO);
    private final MenuButton salesBtn = new MenuButton("Sales", Colors.menuBtnColor, Views.ADMIN_SALES_INFO);

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
        add(Box.createVerticalStrut(10));
        add(productBtn);
        add(Box.createVerticalStrut(10));
        add(salesBtn);
        add(Box.createVerticalStrut(10));
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