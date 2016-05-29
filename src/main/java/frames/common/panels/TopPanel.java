package frames.common.panels;

/*
 * Created by Jonah on 4/30/2016.
 */

import global.Dimensions;
import global.Strings;
import global.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static frames.MainFrame.switchView;

public class TopPanel extends JPanel
{
    DateFormat date = new SimpleDateFormat("M/dd/yy");
    DateFormat time = new SimpleDateFormat("h:mm");
    Calendar calendar = Calendar.getInstance();

    String TIME = time.format(calendar.getTime());
    String DATE = date.format(calendar.getTime());

    private JLabel timeAndDate = new JLabel("<html><div style='text-align: center;'>"
            + TIME + "<br>" + DATE + "</div></html>");

    private final JLabel logo = new JLabel();

    static String[] uddContent = {"My Stats", "Settings", "Logout"};
    private static DefaultComboBoxModel<String> dropDownModel = new DefaultComboBoxModel<>(uddContent);
    private static JComboBox<String> userDropdown;


    public TopPanel(String curView)
    {
        userDropdown = new JComboBox<>(dropDownModel);

        initComponents(curView);
        addComponents();
    }

    private void initComponents(String curView)
    {
        //This
        setBackground(Color.GREEN);

        //Logo Label
        logo.setText(curView);

        //Time And Date
        timeAndDate.setMaximumSize(new Dimension(40, 35));

        Timer timeUpdater = new Timer(15000, new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DateFormat date = new SimpleDateFormat("M/dd/yy");
                DateFormat time = new SimpleDateFormat("h:mm");
                Calendar calendar = Calendar.getInstance();

                String curTimeAndDate = "<html><div style='text-align: center;'>" + time.format(calendar.getTime())
                        + "<br>" + date.format(calendar.getTime()) + "</div></html>";

                timeAndDate.setText(curTimeAndDate);
            }
        });

        timeUpdater.start();
        timeUpdater.setRepeats(true);

        //Logo Label
        logo.setFont(new Font("Courier New", Font.ITALIC, 24));

        //User Dropdown
        userDropdown.setMaximumSize(new Dimension(100, 35));

        userDropdown.addItemListener(event ->
        {
            if (event.getStateChange() == ItemEvent.SELECTED)
            {
                String item = event.getItem().toString();

                switch(item)
                {
                    case "Logout":
                        dropDownModel.removeElement(Strings.CUR_USER);
                        resetUddCb();
                        switchView(Views.LOGIN);
                        break;

                    case "Settings":
                        resetUddCb();
                        switchView(Views.SETTINGS);
                        break;

                    case "My Stats":
                        resetUddCb();
                        switchView(Views.USER_STATS);
                        break;

                    default:
                        resetUddCb();
                        break;
                }
            }
        });
    }

    private void addComponents()
    {
        //This
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

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

    private void resetUddCb()
    {
        userDropdown.setSelectedIndex(0);
    }

    public static void updateComboBox(String item)
    {
        dropDownModel.insertElementAt(item, 0);
        userDropdown.setSelectedIndex(0);
    }
}