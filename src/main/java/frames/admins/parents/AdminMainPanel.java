package frames.admins.parents;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.children.AdminCenterPanel;
import frames.admins.children.AdminRightPanel;
import frames.admins.children.AdminTopPanel;
import frames.interfaces.panels.MainPanelI;

import javax.swing.*;
import java.awt.*;

public class AdminMainPanel extends JPanel implements MainPanelI
{
    public final AdminTopPanel adminTopPanel = new AdminTopPanel();

    public static final CardLayout cardlayout = new CardLayout();
    public static final JPanel containerPanel = new JPanel();

    public final AdminCenterPanel adminCenterPanel = new AdminCenterPanel();
    public final AdminRightPanel adminRightPanel = new AdminRightPanel();

    public AdminMainPanel()
    {
        initComponents();
        addComponents();
    }

    @Override
    public void initComponents()
    {
        setBackground(Color.blue);
    }

    @Override
    public void addComponents()
    {
        //Container Panel
        containerPanel.setLayout(cardlayout);
        containerPanel.add(adminCenterPanel, "Main View");

        add(adminTopPanel, BorderLayout.NORTH);
        add(containerPanel, BorderLayout.CENTER);
        add(adminRightPanel, BorderLayout.EAST);

        cardlayout.show(containerPanel, "Main View");
    }
}