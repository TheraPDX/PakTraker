package frames;

/*
 * Created by Jonah on 5/29/2016.
 */

import javax.swing.*;

public class MainFrameController
{
    public MainFrameController()
    {

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}