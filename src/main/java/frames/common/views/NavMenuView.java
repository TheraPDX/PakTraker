package frames.common.views;

/*
 * Created by Jonah on 5/10/2016.
 */

import frames.components.buttons.MenuButton;
import global.Dimensions;
import global.Strings;
import global.Views;

import javax.swing.*;
import java.awt.*;

import static frames.admins.views.AdminView.showAdminQuickSale;

public class NavMenuView extends JPanel
{
    private final JButton quickSaleBtn = new JButton("Quick Sale");

    private final MenuButton homeBtn = new MenuButton("Home", Views.A_MAIN, false);
    private final MenuButton employeeInfoBtn = new MenuButton("Employees", Views.A_EMPLOYEE_CNTRLR, true);
    private final MenuButton productBtn = new MenuButton("Product", Views.A_PRODUCT_INFO, true);
    private final MenuButton salesBtn = new MenuButton("Sales", Views.A_SALES_INFO, true);

    public NavMenuView(String userType)
    {
        initComponents();

        if(userType.equals(Strings.ADMIN))
        {
            adminComponents();
        }
        else if(userType.equals(Strings.EMPLOYEE))
        {
            employeeComponents();
        }
    }

    private void initComponents()
    {
        //This
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Quick Sale Button
        quickSaleBtn.setBackground(Color.RED);
        quickSaleBtn.setAlignmentX(CENTER_ALIGNMENT);
    }

    private void adminComponents()
    {
        quickSaleBtn.addActionListener(e -> showAdminQuickSale(true));

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
        add(Box.createVerticalGlue());
        add(TopPanelView.userDropdown);
    }

    private void employeeComponents()
    {
        //quickSaleBtn.addActionListener(e -> showEmployQuickSale(true));

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
        add(Box.createVerticalGlue());
        add(TopPanelView.userDropdown);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(150, Dimensions.screen.height);
    }
}