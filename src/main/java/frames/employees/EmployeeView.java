package frames.employees;

/*
 * Created by Jonah on 5/6/2016.
 */

import frames.common.views.NavMenuView;
import frames.common.panels.SalePanel;
import frames.common.views.TopPanelView;
import frames.employees.children.EmployeeCenterPanel;
import global.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EmployeeView extends JPanel
{
    public static final CardLayout centerCardLayout = new CardLayout(0, 0);
    private final JPanel containerPanel = new JPanel(centerCardLayout);

    private final EmployeeCenterPanel employeeCenterPanel = new EmployeeCenterPanel();

    private final TopPanelView topPanelView = new TopPanelView("Employee");

    private final SalePanel salePanel = new SalePanel();
    private final NavMenuView navMenuView = new NavMenuView(Strings.EMPLOYEE);

    public EmployeeView()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This

        //Show Sale Panel
        AbstractAction staffShowSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                add(salePanel, BorderLayout.LINE_END);

                revalidate();
                repaint();
            }
        };

        //Hide Sale Panel
        AbstractAction staffHideSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                remove(salePanel);

                revalidate();
                repaint();
            }
        };
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.add(employeeCenterPanel);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanelView, BorderLayout.PAGE_START);
        add(navMenuView, BorderLayout.LINE_START);
        add(containerPanel, BorderLayout.CENTER);
    }
}