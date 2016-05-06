package frames.admins.parents;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.children.AdminCenterPanel;
import frames.common.children.ShowSalePanel;
import frames.common.parents.SalePanel;
import frames.admins.children.AdminTopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminMainPanel extends JPanel
{
    private final AdminTopPanel adminTopPanel = new AdminTopPanel();

    public static final CardLayout centerCardLayout = new CardLayout();
    public static final JPanel containerPanel = new JPanel();

    private final AdminCenterPanel adminCenterPanel = new AdminCenterPanel();
    private static final JPanel saleContainerPanel = new JPanel();
    private final ShowSalePanel showSalePanel = new ShowSalePanel();
    private final SalePanel salePanel = new SalePanel();

    public AdminMainPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.blue);

        //Sale Container Panel
        saleContainerPanel.setBackground(Color.CYAN);

        //Show Sale Panel
        AbstractAction showSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saleContainerPanel.remove(showSalePanel);
                saleContainerPanel.add(salePanel, BorderLayout.CENTER);

                saleContainerPanel.revalidate();
                saleContainerPanel.repaint();
            }
        };

        showSalePanel.addButtonAction(showSaleAction);

        //Hide Sale Panel
        AbstractAction hidSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saleContainerPanel.remove(salePanel);
                saleContainerPanel.add(showSalePanel);

                saleContainerPanel.revalidate();
                saleContainerPanel.repaint();
            }
        };

        salePanel.addHideSaleBtnAction(hidSaleAction);
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.setLayout(centerCardLayout);
        containerPanel.add(adminCenterPanel, "Main View");

        //Sale Container Panel
        saleContainerPanel.setLayout(new BorderLayout(0, 0));
        saleContainerPanel.add(showSalePanel, BorderLayout.CENTER);

        //This
        setLayout(new BorderLayout(0, 0));
        add(adminTopPanel, BorderLayout.PAGE_START);
        add(containerPanel, BorderLayout.CENTER);
        add(saleContainerPanel, BorderLayout.LINE_END);

        //Select Visible View
        centerCardLayout.show(containerPanel, "Main View");
    }
}