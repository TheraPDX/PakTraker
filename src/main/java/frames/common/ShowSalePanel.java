package frames.common;

/*
 * Created by Jonah on 5/5/2016.
 */

import javax.swing.*;
import java.awt.*;

public class ShowSalePanel extends JPanel
{
    private final JButton showSalePanelBtn = new JButton("Sale");

    public ShowSalePanel(Color color)
    {
        initComponents(color);
        addComponents();
    }

    private void initComponents(Color color)
    {
        //This
        setBackground(color);
    }

    private void addComponents()
    {
        //This
        setLayout(new GridLayout(12, 1, 0, 0));
        add(showSalePanelBtn);
    }

    public void addButtonAction(AbstractAction action)
    {
        showSalePanelBtn.addActionListener(action);
    }
}
