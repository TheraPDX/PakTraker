package frames.common.views.toolbar;

/*
 * Created by Jonah on 5/28/2016.
 */

import frames.common.controllers.toolbar.ToolBarController;
import frames.common.models.toolbar.ToolBarModel;
import global.Dimensions;

import javax.swing.*;
import java.awt.*;

public class ToolBarView extends JPanel
{
    ToolBarController toolBarController;
    ToolBarModel toolBarModel;

    public ToolBarView()
    {
        toolBarController = new ToolBarController();
        toolBarModel = new ToolBarModel();

        initComponents();
    }

    private void initComponents()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public void updateButtons(JButton[] buttons)
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

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Dimensions.screen.width, 45);
    }

    public ToolBarModel getModel()
    {
        return toolBarModel;
    }
}