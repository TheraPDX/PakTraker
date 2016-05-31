package frames.common.views.container;

/*
 * Created by Jonah on 5/30/2016.
 */

/*
    JPanel With The Sole Purpose Of
    Being Used As The Container For
    All Of My (Possibly Too Many ;P)
    CardLayout Views Due To The
    Issues With Calling "switchView"
    Methods In A Lot Of Diff. Classes
    And The Inability To Use this Statically
 */

import javax.swing.*;
import java.awt.*;

public class ViewContainer extends JPanel
{
    public ViewContainer(CardLayout cardLayout)
    {
        super(cardLayout);
    }
}