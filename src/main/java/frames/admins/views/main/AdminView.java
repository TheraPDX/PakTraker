package frames.admins.views.main;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.views.home.AdminHomeView;
import frames.admins.views.staffControl.StaffControlView;
import frames.common.panels.SalePanel;
import frames.common.views.container.ViewContainer;
import frames.common.views.navMenu.NavMenuView;
import frames.common.views.toolbar.ToolBarView;
import frames.common.views.top.TopPanelView;
import global.Strings;
import global.Views;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel
{
    private final JPanel layoutContainer;

    public static CardLayout cardLayout;
    private static ViewContainer viewContainer;

    private final AdminHomeView adminHomeView;
    private final StaffControlView staffControlView;

    private static ToolBarView toolBarView;
    private static SalePanel salePanel;
    private final TopPanelView topPanel;
    private final NavMenuView navMenuView;

    public AdminView()
    {
        layoutContainer = new JPanel();
        cardLayout = new CardLayout(0, 0);
        viewContainer = new ViewContainer(cardLayout);

        topPanel = new TopPanelView(Strings.ADMIN);
        navMenuView = new NavMenuView(Strings.ADMIN);
        toolBarView = new ToolBarView(Strings.ADMIN);

        salePanel = new SalePanel();
        adminHomeView = new AdminHomeView();
        staffControlView = new StaffControlView();

        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.blue);

        //Actions
        salePanel.setVisible(false);

        //Action Panel
        toolBarView.setVisible(false);
    }

    private void addComponents()
    {
        //Container Panel
        layoutContainer.setLayout(new BorderLayout(0, 0));
        layoutContainer.add(toolBarView, BorderLayout.PAGE_START);
        layoutContainer.add(viewContainer, BorderLayout.CENTER);

        //View Container
        viewContainer.add(adminHomeView, Views.A_MAIN);
        viewContainer.add(staffControlView, Views.A_EMPLOYEE_CNTRLR);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(navMenuView, BorderLayout.LINE_START);
        add(layoutContainer, BorderLayout.CENTER);
        add(salePanel, BorderLayout.LINE_END);

        //Select Visible View
        cardLayout.show(viewContainer, Views.A_MAIN);
    }

    public static void switchAdminView(String view)
    {
        cardLayout.show(viewContainer, view);
    }

    public static void showAdminQuickSale(boolean show)
    {
        salePanel.setVisible(show);
    }

    public static void showAdminToolbar(boolean show, String toolBarSet)
    {
        if(show)
        {
            toolBarView.updateButtons(toolBarView.getModel().getButtonSet(toolBarSet));
            toolBarView.setVisible(true);
        }
        else
        {
            toolBarView.setVisible(false);
        }
    }
}