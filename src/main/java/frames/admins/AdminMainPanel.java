package frames.admins;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.actions.SalePanelActions;
import frames.admins.views.AdminCenterPanel;
import frames.admins.views.ControlEmployeesPanel;
import frames.common.panels.NavigationMenuPanel;
import frames.common.panels.SalePanel;
import frames.common.panels.TopPanel;
import global.Strings;

import javax.swing.*;
import java.awt.*;

public class AdminMainPanel extends JPanel
{
    public static final CardLayout centerCardLayout = new CardLayout();
    public static final JPanel containerPanel = new JPanel();

    private final NavigationMenuPanel navigationMenuPanel = new NavigationMenuPanel();

    private final AdminCenterPanel adminCenterPanel = new AdminCenterPanel();
    private final ControlEmployeesPanel controlEmployeesPanel = new ControlEmployeesPanel();

    private final SalePanel salePanel = new SalePanel();
    private final SalePanelActions actions = new SalePanelActions();
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

        //Actions
        navigationMenuPanel.addQuickSaleBtnAction(actions.addAction(this, salePanel));
        salePanel.addHideSaleBtnAction(actions.removeAction(this, salePanel));
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