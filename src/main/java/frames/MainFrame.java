package frames;

/*
 * Created by Jonah on 4/29/2016.
 */

import frames.admins.views.main.AdminView;
import frames.common.views.container.ViewContainer;
import frames.common.views.login.LoginView;
import frames.employees.EmployeeView;
import frames.settings.SettingsPanel;
import global.Strings;
import global.Views;

import javax.swing.*;
import java.awt.*;

public class MainFrame
{
    public final JFrame mainFrame = new JFrame("Pak Traker");

    private final LoginView loginView;
    private final AdminView adminView;
    private final SettingsPanel settingsPanel;
    private final EmployeeView employeeView;

    public static final CardLayout cardLayout = new CardLayout(0, 0);
    public static ViewContainer viewContainer = new ViewContainer(cardLayout);

    public MainFrame()
    {
        loginView = new LoginView();
        adminView = new AdminView();
        settingsPanel = new SettingsPanel();
        employeeView = new EmployeeView();

        initComponents();
        addComponents();

        cardLayout.show(viewContainer, Views.LOGIN);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void initComponents()
    {
        //Main Frame
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void addComponents()
    {
        //Main Frame
        mainFrame.add(viewContainer);

        //Container Panel
        viewContainer.add(loginView, Views.LOGIN);
        viewContainer.add(adminView, Views.ADMIN);
        viewContainer.add(employeeView, Views.EMPLOYEE);
        viewContainer.add(settingsPanel, Views.SETTINGS);
    }

    public static void switchMainView(String name)
    {
        cardLayout.show(viewContainer, name);
        Strings.CUR_USER_TYPE = name;
    }
}