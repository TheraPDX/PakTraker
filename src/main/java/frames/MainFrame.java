package frames;

/*
 * Created by Jonah on 4/29/2016.
 */

import frames.admins.views.main.AdminMainPanel;
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

    private final AdminMainPanel adminMainPanel = new AdminMainPanel();
    private final EmployeeMainPanel employeeMainPanel = new EmployeeMainPanel();
    private final LoginView adminLoginView = new LoginView();
    private final SettingsPanel settingsPanel = new SettingsPanel();

    public static final CardLayout cardLayout = new CardLayout(0, 0);
    public static final JPanel containerPanel = new JPanel(cardLayout);

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
        mainFrame.add(containerPanel);

        //Container Panel
        containerPanel.add(adminMainPanel, Views.ADMIN);
        containerPanel.add(employeeMainPanel, Views.EMPLOYEE);
        containerPanel.add(adminLoginView, Views.LOGIN);
        containerPanel.add(settingsPanel, Views.SETTINGS);
    }

    public static void switchView(String name)
    {
        cardLayout.show(containerPanel, name);
        Strings.CUR_USER_TYPE = name;
    }
}