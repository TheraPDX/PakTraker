package frames.admins.views.main;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.controllers.main.AdminController;
import frames.admins.views.center.AdminCenterView;
import frames.admins.views.staffControl.StaffControlView;
import frames.common.panels.SalePanel;
import frames.common.views.container.ViewContainer;
import frames.common.views.navMenu.NavMenuView;
import frames.common.views.toolbar.ToolBarView;
import frames.common.views.top.TopPanelView;
import global.Views;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel
{
    private final JPanel layoutContainer;

    public final CardLayout cardLayout;
    private final ViewContainer viewContainer;

    private final AdminCenterView adminCenterView;
    private final StaffControlView staffControlView;

    private final ToolBarView toolBarView;
    private final SalePanel salePanel;
    private final TopPanelView topPanel;
    private final NavMenuView navMenuView;

    private final AdminController adminController;

    public AdminView()
    {
        layoutContainer = new JPanel();
        cardLayout = new CardLayout(0, 0);
        viewContainer = new ViewContainer(cardLayout);

        topPanel = new TopPanelView("Admin");
        salePanel = new SalePanel();
        navMenuView = new NavMenuView(this, salePanel);
        toolBarView = new ToolBarView();

        adminCenterView = new AdminCenterView();
        staffControlView = new StaffControlView();
        adminController = new AdminController(cardLayout, viewContainer);

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
        toolBarView.setVisible(true);
        toolBarView.getButton(0).addActionListener(e -> toolBarView.setCurBtns(new JButton[]{new JButton("Test")}));
    }

    private void addComponents()
    {
        //Container Panel
        layoutContainer.setLayout(new BorderLayout(0, 0));
        layoutContainer.add(toolBarView, BorderLayout.PAGE_START);
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
        cardLayout.show(viewContainer, Views.ADMIN_MAIN);
    }
}