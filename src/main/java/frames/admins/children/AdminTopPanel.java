package frames.admins.children;

/*
 * Created by Jonah on 4/30/2016.
 */

import global.Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static frames.MainFrame.switchView;

public class AdminTopPanel extends JPanel
{
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    private JLabel timeAndDate = new JLabel("<html><div style='text-align: center;'>"
            + Strings.TIME + "<br>" + Strings.DATE + "</div></html>");

    private final JLabel logo = new JLabel("Admin Panel");

    private final DefaultComboBoxModel<String> uddModel = new DefaultComboBoxModel<>();
    private final JComboBox<String> userDropdown = new JComboBox<>(uddModel);

    public AdminTopPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.GREEN);

        //Time And Date
        timeAndDate.setMaximumSize(new Dimension(40, 35));

        Timer timeUpdater = new Timer(30000, new AbstractAction()
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
                Object item = event.getItem();

                if(item.equals("Logout"))
                {
                    switchView(Strings.LOGIN_VIEW);
                }
            }
        });

        //User Dropdown Model
        uddModel.addElement(Strings.CUR_USER);
        uddModel.addElement("My Stats");
        uddModel.addElement("Settings");
        uddModel.addElement("Logout");
    }

    private void addComponents()
    {
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
        return new Dimension(screen.width, screen.height/11);
    }
}
