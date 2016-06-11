package frames.common.views.toolbar;

/*
 * Created by Jonah on 5/28/2016.
 */

import frames.common.models.toolbar.ToolBarModel;
import global.Dimensions;
import global.Strings;

import javax.swing.*;
import java.awt.*;

public class ToolBarView extends JPanel
{
    ToolBarModel toolBarModel;

    public ToolBarView(String userType)
    {
        if(userType.equals(Strings.ADMIN))
        {
            toolBarModel = new ToolBarModel(Strings.ADMIN);
        }
        else if(userType.equals(Strings.EMPLOYEE))
        {
            toolBarModel = new ToolBarModel(Strings.EMPLOYEE);
        }

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