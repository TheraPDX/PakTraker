package frames.employees;

/*
 * Created by Jonah on 5/6/2016.
 */

import frames.common.NavigationMenuPanel;
import frames.common.SalePanel;
import frames.common.TopPanel;
import frames.employees.children.EmployeeCenterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EmployeeMainPanel extends JPanel
{
    public static final CardLayout centerCardLayout = new CardLayout(0, 0);
    private final JPanel containerPanel = new JPanel(centerCardLayout);

    private final EmployeeCenterPanel employeeCenterPanel = new EmployeeCenterPanel();

    private final TopPanel topPanel = new TopPanel("Employee");
    private final NavigationMenuPanel navigationMenuPanel = new NavigationMenuPanel();
    private final SalePanel salePanel = new SalePanel();

    public EmployeeMainPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This

        //Show Sale Panel
        AbstractAction employeeShowSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                add(salePanel, BorderLayout.LINE_END);

                revalidate();
                repaint();
            }
        };

        navigationMenuPanel.addQuickSaleBtnAction(employeeShowSaleAction);

        //Hide Sale Panel
        AbstractAction employeeHideSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                remove(salePanel);

                revalidate();
                repaint();
            }
        };

        salePanel.addHideSaleBtnAction(employeeHideSaleAction);
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.add(employeeCenterPanel);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(navigationMenuPanel, BorderLayout.LINE_START);
        add(containerPanel, BorderLayout.CENTER);
    }
}