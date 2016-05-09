package frames.admins;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.admins.children.aMainPanelControls.AdminCenterPanel;
import frames.common.ShowSalePanel;
import frames.common.SalePanel;
import frames.common.TopPanel;
import global.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminMainPanel extends JPanel
{
    private final TopPanel topPanel = new TopPanel("Admin");

    public static final CardLayout centerCardLayout = new CardLayout();
    public static final JPanel containerPanel = new JPanel();

    private final AdminCenterPanel adminCenterPanel = new AdminCenterPanel();
    private final ControlEmployeesPanel controlEmployeesPanel = new ControlEmployeesPanel();

    private final ShowSalePanel showSalePanel = new ShowSalePanel(Color.CYAN);
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

        //Show Sale Panel
        AbstractAction adminShowSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                remove(showSalePanel);
                add(salePanel, BorderLayout.LINE_END);

                revalidate();
                repaint();
            }
        };

        showSalePanel.addButtonAction(adminShowSaleAction);

        //Hide Sale Panel
        AbstractAction adminHideSaleAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                remove(salePanel);
                add(showSalePanel, BorderLayout.LINE_END);

                revalidate();
                repaint();
            }
        };

        salePanel.addHideSaleBtnAction(adminHideSaleAction);
    }

    private void addComponents()
    {
        //Container Panel
        containerPanel.setLayout(centerCardLayout);
        containerPanel.add(adminCenterPanel, "Main View");
        containerPanel.add(controlEmployeesPanel, Strings.MANIP_EMPLOYEES_VIEW);

        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(containerPanel, BorderLayout.CENTER);
        add(showSalePanel, BorderLayout.LINE_END);

        //Select Visible View
        centerCardLayout.show(containerPanel, Strings.MANIP_EMPLOYEES_VIEW);
    }
}