package frames.employees;

/*
 * Created by Jonah on 5/6/2016.
 */

import frames.common.ShowSalePanel;
import frames.common.SalePanel;
import frames.common.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EmployeeMainPanel extends JPanel
{
    private final TopPanel topPanel = new TopPanel("Employee");
    private final ShowSalePanel showSalePanel = new ShowSalePanel(Color.MAGENTA);
    private final SalePanel salePanel = new SalePanel();

    public EmployeeMainPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.MAGENTA);

        //Show Sale Panel
        AbstractAction showSaleAction = new AbstractAction()
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

        showSalePanel.addButtonAction(showSaleAction);

        //Hide Sale Panel
        AbstractAction hidSaleAction = new AbstractAction()
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

        salePanel.addHideSaleBtnAction(hidSaleAction);
    }

    private void addComponents()
    {
        //This
        setLayout(new BorderLayout(0, 0));
        add(topPanel, BorderLayout.PAGE_START);
        add(showSalePanel, BorderLayout.LINE_END);
    }
}