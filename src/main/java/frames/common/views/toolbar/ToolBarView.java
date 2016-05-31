package frames.common.views.toolbar;

/*
 * Created by Jonah on 5/28/2016.
 */

import frames.common.controllers.toolbar.ToolBarController;
import global.Dimensions;

import javax.swing.*;
import java.awt.*;

public class ToolBarView extends JPanel
{

    ToolBarController toolBarController;
    JButton[] buttons;

    public ToolBarView()
    {
        toolBarController = new ToolBarController();
        this.buttons = toolBarController.getStaffControlBtns();

        initComponents();
        addComponents(buttons);
    }

    private void initComponents()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    private void addComponents(JButton[] buttons)
    {
        removeAll();
        add(Box.createHorizontalGlue());

        for(JButton button : buttons)
        {
            add(button);
            add(Box.createHorizontalStrut(10));
        }

        add(Box.createHorizontalGlue());

        revalidate();
        repaint();
    }

    public void setCurBtns(JButton[] buttons)
    {
        this.buttons = buttons;
        addComponents(buttons);
    }

    public JButton[] getCurBtns()
    {
        return this.buttons;
    }

    public JButton getButton(int index)
    {
        return buttons[index];
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Dimensions.screen.width, 45);
    }
}