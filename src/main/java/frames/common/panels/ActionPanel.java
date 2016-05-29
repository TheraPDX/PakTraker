package frames.common.panels;

/*
 * Created by Jonah on 5/28/2016.
 */

import global.Dimensions;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel
{
    private JButton[] curBtns;

    public ActionPanel(JButton[] buttons)
    {
        curBtns = buttons;

        initComponents();
        addComponents();
    }

    private void initComponents()
    {

    }

    private void addComponents()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(Box.createHorizontalGlue());

        for(JButton button : curBtns)
        {
            add(button);
            add(Box.createHorizontalStrut(10));
        }

        add(Box.createHorizontalGlue());
    }

    public void setCurBtns(JButton[] buttons)
    {
        curBtns = buttons;

        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Dimensions.screen.width, 45);
    }
}