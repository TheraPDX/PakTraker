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
    public static final CardLayout rightCardLayout = new CardLayout();
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

        saleContainerPanel.setLayout(new BorderLayout(0, 0));
        //saleContainerPanel.add(salePanel, BorderLayout.CENTER);
        saleContainerPanel.add(showSalePanel, BorderLayout.CENTER);

        setLayout(new BorderLayout(0, 0));
        add(adminTopPanel, BorderLayout.PAGE_START);
        add(containerPanel, BorderLayout.CENTER);
        add(saleContainerPanel, BorderLayout.LINE_END);

        centerCardLayout.show(containerPanel, "Main View");
    }
}