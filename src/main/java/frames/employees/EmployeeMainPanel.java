package frames.employees;

/*
 * Created by Jonah on 5/6/2016.
 */

import frames.common.ShowSalePanel;
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
    private final ShowSalePanel showSalePanel = new ShowSalePanel(Color.MAGENTA);
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
        AbstractAction showSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                remove(showSalePanel);
                add(salePanel, BorderLayout.LINE_END);

                revalidate();
                repaint();
            }
        };

        showSalePanel.addButtonAction(showSaleAction);

        //Hide Sale Panel
        AbstractAction hidSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                remove(salePanel);
                add(showSalePanel, BorderLayout.LINE_END);

                revalidate();
                repaint();
            }
        };

        salePanel.addHideSaleBtnAction(hidSaleAction);
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.add(employeeCenterPanel);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(containerPanel, BorderLayout.CENTER);
        add(showSalePanel, BorderLayout.LINE_END);
    }
}