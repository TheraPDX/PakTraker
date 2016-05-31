package frames.admins.views.main;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.controllers.main.AdminController;
import frames.admins.views.center.AdminCenterView;
import frames.admins.views.staffControl.StaffControlView;
import frames.common.panels.ActionPanel;
import frames.common.panels.SalePanel;
import frames.common.panels.TopPanel;
import frames.common.views.container.ViewContainer;
import frames.common.views.navMenu.NavMenuView;
import global.Views;

import javax.swing.*;
import java.awt.*;

import static frames.components.buttons.ActionPanelButtons.staffControlBtns;

public class AdminView extends JPanel
{
    private final JPanel layoutContainer = new JPanel();

    public final CardLayout centerCardLayout = new CardLayout();
    private final ViewContainer viewContainer = new ViewContainer(centerCardLayout);

    private final AdminCenterView adminCenterView = new AdminCenterView();
    private final StaffControlView staffControlView = new StaffControlView();

    private static final ActionPanel actionPanel = new ActionPanel(staffControlBtns());

    private final SalePanel salePanel = new SalePanel();
    private final TopPanel topPanel = new TopPanel("Admin");
    private final NavMenuView navMenuView = new NavMenuView(this, salePanel);

    private final AdminController adminController = new AdminController(centerCardLayout, viewContainer);

    public AdminView()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.blue);

        //Actions
        salePanel.addQsHideAction(adminController.getQsHideAction(this, salePanel));

        //Action Panel
        actionPanel.setVisible(false);
    }

    private void addComponents()
    {
        //Container Panel
        layoutContainer.setLayout(new BorderLayout(0, 0));
        layoutContainer.add(actionPanel, BorderLayout.PAGE_START);
        layoutContainer.add(viewContainer, BorderLayout.CENTER);

        //View Container
        viewContainer.add(adminCenterView, Views.ADMIN_MAIN);
        viewContainer.add(staffControlView, Views.ADMIN_EMPLOYEE_CONTROLLER);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(navMenuView, BorderLayout.LINE_START);
        add(layoutContainer, BorderLayout.CENTER);

        //Select Visible View
        centerCardLayout.show(viewContainer, Views.ADMIN_MAIN);
    }
}