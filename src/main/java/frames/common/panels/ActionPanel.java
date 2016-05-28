package frames.common.panels;

/*
 * Created by Jonah on 5/28/2016.
 */

import frames.components.buttons.ActionButton;
import global.Dimensions;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel
{

    public ActionPanel()
    {
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
        add(new ActionButton("Action 1", Color.GRAY));
        add(Box.createHorizontalGlue());
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Dimensions.screen.width, 45);
    }
}