package frames.common.views.navMenu;

/*
 * Created by Jonah on 5/10/2016.
 */

import frames.common.controllers.navMenu.NavMenuController;
import frames.components.buttons.MenuButton;
import global.Colors;
import global.Dimensions;
import global.Views;

import javax.swing.*;
import java.awt.*;

public class NavMenuView extends JPanel
{
    private final JButton quickSaleBtn = new JButton("Quick Sale");

    private final MenuButton homeBtn = new MenuButton("Home", Colors.menuBtnColor, Views.A_MAIN, false);
    private final MenuButton employeeInfoBtn = new MenuButton("Employees", Colors.menuBtnColor, Views.A_EMPLOYEE_CNTRLR, true);
    private final MenuButton productBtn = new MenuButton("Product", Colors.menuBtnColor, Views.A_PRODUCT_INFO, true);
    private final MenuButton salesBtn = new MenuButton("Sales", Colors.menuBtnColor, Views.A_SALES_INFO, true);

    public NavMenuView(JPanel panel, JPanel panel1)
    {
        NavMenuController menuController = new NavMenuController();
        quickSaleBtn.addActionListener(menuController.getQsShowAction(panel, panel1));

        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //Quick Sale Button
        quickSaleBtn.setBackground(Color.RED);
        quickSaleBtn.setAlignmentX(CENTER_ALIGNMENT);
    }

    private void addComponents()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalStrut(10));
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
}