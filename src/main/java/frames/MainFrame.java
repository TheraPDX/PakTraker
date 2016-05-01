package frames;

/*
 * Created by Jonah on 4/29/2016.
 */

import frames.admins.children.AdminLoginPanel;
import frames.admins.parents.AdminMainPanel;
import global.Strings;

import javax.swing.*;
import java.awt.*;

public class MainFrame
{
    public static final JFrame mainFrame = new JFrame("Pak Traker");
    public static CardLayout cardLayout = new CardLayout(0, 0);
    public static final JPanel containerPanel = new JPanel(cardLayout);

    private final AdminMainPanel adminMainPanel = new AdminMainPanel();
    private final AdminLoginPanel adminLoginPanel = new AdminLoginPanel();

    public MainFrame()
    {

        initComponents();
        addComponents();

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        switchView(Strings.Views("ADMIN LOGIN"));
        mainFrame.setVisible(true);
    }

    private void initComponents()
    {

    }

    private void addComponents()
    {
        mainFrame.add(containerPanel);

        containerPanel.add(adminMainPanel, Strings.Views("ADMIN"));
        containerPanel.add(adminLoginPanel, Strings.Views("ADMIN LOGIN"));
    }

    public static void switchView(String name)
    {
        cardLayout.show(containerPanel, name);
    }
}
