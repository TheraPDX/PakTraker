package frames.common.children;

/*
 * Created by Jonah on 5/5/2016.
 */

import javax.swing.*;
import java.awt.*;

public class ShowSalePanel extends JPanel
{
    private final JButton showSalePanelBtn = new JButton("Sale");

    public ShowSalePanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        setOpaque(false);
    }

    private void addComponents()
    {
        setLayout(new GridLayout(12, 1, 0, 0));
        add(showSalePanelBtn);
    }

    public void addButtonAction(AbstractAction action)
    {
        showSalePanelBtn.addActionListener(action);
    }
}
