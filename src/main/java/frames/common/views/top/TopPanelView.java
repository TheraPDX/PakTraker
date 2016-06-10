package frames.common.views.top;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.common.controllers.top.TopPanelController;
import frames.common.models.top.TopPanelModel;
import global.Dimensions;
import global.Strings;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class TopPanelView extends JPanel
{
    private final TopPanelController topController;
    private static TopPanelModel topModel = new TopPanelModel();

    private final JLabel timeAndDate;
    private final JLabel logo;

    public static JComboBox<String> userDropdown;

    public TopPanelView(String curView)
    {
        Strings.CUR_USER_TYPE = curView;

        topController = new TopPanelController();

        timeAndDate = new JLabel(topModel.getFormattedTimeAndDate());
        ImageIcon titleIcon = new ImageIcon(getClass().getResource("/title.png"));
        logo = new JLabel(titleIcon);
        userDropdown = new JComboBox<>(topModel.getDropDownModel());

        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.GREEN);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //Time And Date
        timeAndDate.setMaximumSize(new Dimension(40, 35));

        Timer timeUpdater = new Timer(15000, topController.getTimeUpdaterAction(timeAndDate, topModel));
        timeUpdater.start();
        timeUpdater.setRepeats(true);

        //User Dropdown
        userDropdown.setMaximumSize(new Dimension(100, 35));
        userDropdown.addItemListener(topController.getUddItemListener(topModel.getDropDownModel()));

        userDropdown.setUI(new BasicComboBoxUI()
        {
            @Override
            protected JButton createArrowButton() {
                return new BasicArrowButton(BasicArrowButton.NORTH);
            }
        });
    }

    private void addComponents()
    {
        //This
        add(Box.createRigidArea(new Dimension(15, 15)));
        add(timeAndDate);
        add(Box.createHorizontalGlue());
        add(logo);
        add(Box.createHorizontalGlue());
        add(userDropdown);
        add(Box.createRigidArea(new Dimension(15, 15)));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Dimensions.screen.width, Dimensions.screen.height/11);
    }

    public static void updateComboBox(String item)
    {
        topModel.getDropDownModel().insertElementAt(item, 0);
        userDropdown.setSelectedIndex(0);
    }
}