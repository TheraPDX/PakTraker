package frames;

/*
 * Created by Jonah on 4/29/2016.
 */

import frames.admins.views.main.AdminView;
import frames.common.views.container.ViewContainer;
import frames.common.views.login.LoginView;
import frames.employees.EmployeeMainPanel;
import frames.settings.SettingsPanel;
import global.Strings;
import global.Views;

import javax.swing.*;
import java.awt.*;

public class MainFrame
{
    public final JFrame mainFrame = new JFrame("Pak Traker");

    private final LoginView adminLoginView = new LoginView();
    private final AdminView adminView = new AdminView();
    private final EmployeeMainPanel employeeMainPanel = new EmployeeMainPanel();
    private final SettingsPanel settingsPanel = new SettingsPanel();

    public static final CardLayout cardLayout = new CardLayout(0, 0);
    public static ViewContainer viewContainer = new ViewContainer(cardLayout);

    public MainFrame()
    {
        initComponents();
        addComponents();

        //Main Frame
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        switchView(Views.LOGIN);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void initComponents()
    {

    }

    private void addComponents()
    {
        //Main Frame
        mainFrame.add(viewContainer);

        //Container Panel
        viewContainer.add(adminLoginView, Views.LOGIN);
        viewContainer.add(adminView, Views.ADMIN);
        viewContainer.add(employeeMainPanel, Views.EMPLOYEE);
        viewContainer.add(settingsPanel, Views.SETTINGS);
    }

    public static void switchView(String name)
    {
        cardLayout.show(viewContainer, name);
        Strings.CUR_USER_TYPE = name;
    }
}