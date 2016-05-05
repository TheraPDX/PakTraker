package frames.admins.parents;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.children.AdminCenterPanel;
import frames.admins.children.AdminRightPanel;
import frames.admins.children.AdminTopPanel;

import javax.swing.*;
import java.awt.*;

public class AdminMainPanel extends JPanel
{
    private final AdminTopPanel adminTopPanel = new AdminTopPanel();

    public static final CardLayout cardlayout = new CardLayout();
    public static final JPanel containerPanel = new JPanel();

    private final AdminCenterPanel adminCenterPanel = new AdminCenterPanel();
    private final AdminRightPanel adminRightPanel = new AdminRightPanel();

    public AdminMainPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        setBackground(Color.blue);
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.setLayout(cardlayout);
        containerPanel.add(adminCenterPanel, "Main View");

        setLayout(new BorderLayout(0, 0));
        add(adminTopPanel, BorderLayout.PAGE_START);
        add(containerPanel, BorderLayout.CENTER);
        add(adminRightPanel, BorderLayout.LINE_END);

        cardlayout.show(containerPanel, "Main View");
    }
}