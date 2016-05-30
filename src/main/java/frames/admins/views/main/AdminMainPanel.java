package frames.admins.views.main;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.actions.SalePanelActions;
import frames.admins.views.staffControl.StaffControlView;
import frames.common.panels.ActionPanel;
import frames.common.panels.NavigationMenuPanel;
import frames.common.panels.SalePanel;
import frames.common.panels.TopPanel;
import global.Views;

import javax.swing.*;
import java.awt.*;

import static frames.components.buttons.ActionPanelButtons.staffControlBtns;

public class AdminMainPanel extends JPanel
{
    private final JPanel containerPanel = new JPanel();

    public static final CardLayout centerCardLayout = new CardLayout();
    public static final JPanel clContainerPanel = new JPanel();

    private final NavigationMenuPanel navigationMenuPanel = new NavigationMenuPanel();

    private final AdminViewsContainer adminViewsContainer = new AdminViewsContainer();
    private final StaffControlView staffControlView = new StaffControlView();

    private static final ActionPanel actionPanel = new ActionPanel(staffControlBtns());

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
        clContainerPanel.add(adminViewsContainer, Views.ADMIN_MAIN);
        clContainerPanel.add(staffControlView, Views.ADMIN_EMPLOYEE_CONTROLLER);

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
                actionPanel.setCurBtns(staffControlBtns());
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