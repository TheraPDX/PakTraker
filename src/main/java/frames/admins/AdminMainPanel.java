package frames.admins;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.actions.SalePanelActions;
import frames.admins.views.AdminCenterPanel;
import frames.admins.views.ControlEmployeesPanel;
import frames.common.panels.ActionPanel;
import frames.common.panels.NavigationMenuPanel;
import frames.common.panels.SalePanel;
import frames.common.panels.TopPanel;
import global.Views;

import javax.swing.*;
import java.awt.*;

import static frames.components.buttons.ActionPanelButtons.employeeControlBtns;

public class AdminMainPanel extends JPanel
{
    private final JPanel containerPanel = new JPanel();

    public static final CardLayout centerCardLayout = new CardLayout();
    public static final JPanel clContainerPanel = new JPanel();

    private final NavigationMenuPanel navigationMenuPanel = new NavigationMenuPanel();

    private final AdminCenterPanel adminCenterPanel = new AdminCenterPanel();
    private final ControlEmployeesPanel controlEmployeesPanel = new ControlEmployeesPanel();

    private static final ActionPanel actionPanel = new ActionPanel(employeeControlBtns());

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

        //Action Panel
        actionPanel.setVisible(false);
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.setLayout(new BorderLayout(0, 0));
        containerPanel.add(actionPanel, BorderLayout.PAGE_START);
        containerPanel.add(clContainerPanel, BorderLayout.CENTER);

        //Card Layout Container Panel
        clContainerPanel.setLayout(centerCardLayout);
        clContainerPanel.add(adminCenterPanel, Views.ADMIN_MAIN);
        clContainerPanel.add(controlEmployeesPanel, Views.ADMIN_EMPLOYEE_CONTROLLER);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(navigationMenuPanel, BorderLayout.LINE_START);
        add(containerPanel, BorderLayout.CENTER);

        //Select Visible View
        centerCardLayout.show(clContainerPanel, Views.ADMIN_MAIN);
    }

    public static void switchAdminView(String view)
    {
        switch(view)
        {
            case Views.ADMIN_MAIN:
                actionPanel.setVisible(false);
                centerCardLayout.show(clContainerPanel, view);
                break;
            case Views.ADMIN_EMPLOYEE_CONTROLLER:
                actionPanel.setCurBtns(employeeControlBtns());
                actionPanel.setVisible(true);
                centerCardLayout.show(clContainerPanel, view);
                break;
            case Views.SETTINGS:
                //Add each viewAsString switch handling here
                centerCardLayout.show(clContainerPanel, view);
                break;
            default:
                break;
        }
    }
}