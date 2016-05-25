package frames.admins;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.views.AdminCenterPanel;
import frames.admins.views.ControlEmployeesPanel;
import frames.common.panels.NavigationMenuPanel;
import frames.common.panels.SalePanel;
import frames.common.panels.TopPanel;
import global.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminMainPanel extends JPanel
{
    public static final CardLayout centerCardLayout = new CardLayout();
    public static final JPanel containerPanel = new JPanel();

    private final NavigationMenuPanel navigationMenuPanel = new NavigationMenuPanel();

    private final AdminCenterPanel adminCenterPanel = new AdminCenterPanel();
    private final ControlEmployeesPanel controlEmployeesPanel = new ControlEmployeesPanel();

    private final SalePanel salePanel = new SalePanel();
    private final TopPanel topPanel = new TopPanel("Admin");

    public AdminMainPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.blue);

        //Show Sale Panel
        AbstractAction adminShowSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                add(salePanel, BorderLayout.LINE_END);

                revalidate();
                repaint();
            }
        };

        navigationMenuPanel.addQuickSaleBtnAction(adminShowSaleAction);

        //Hide Sale Panel
        AbstractAction adminHideSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                remove(salePanel);

                revalidate();
                repaint();
            }
        };

        salePanel.addHideSaleBtnAction(adminHideSaleAction);
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.setLayout(centerCardLayout);
        containerPanel.add(adminCenterPanel, "Main View");
        containerPanel.add(controlEmployeesPanel, Strings.MANIP_EMPLOYEES_VIEW);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(navigationMenuPanel, BorderLayout.LINE_START);
        add(containerPanel, BorderLayout.CENTER);

        //Select Visible View
        centerCardLayout.show(containerPanel, "Main View");
    }

    public static void switchAdminView(String view)
    {
        centerCardLayout.show(containerPanel, view);
    }
}