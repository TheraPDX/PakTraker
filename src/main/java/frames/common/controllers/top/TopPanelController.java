package frames.common.controllers.top;

/*
 * Created by Jonah on 5/31/2016.
 */

import global.Strings;
import global.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static frames.MainFrame.switchView;

public class TopPanelController
{
    public TopPanelController()
    {

    }

    public AbstractAction getTimeUpdaterAction(JLabel timeDateLabel)
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DateFormat date = new SimpleDateFormat("M/dd/yy");
                DateFormat time = new SimpleDateFormat("h:mm");
                Calendar calendar = Calendar.getInstance();

                String curTimeAndDate = "<html><div style='text-align: center;'>" + time.format(calendar.getTime())
                        + "<br>" + date.format(calendar.getTime()) + "</div></html>";

                SwingUtilities.invokeLater(() -> timeDateLabel.setText(curTimeAndDate));
            }
        };
    }

    public ItemListener getUddItemListener(DefaultComboBoxModel dropDownModel)
    {
        return event ->
        {
            if (event.getStateChange() == ItemEvent.SELECTED)
            {
                String item = event.getItem().toString();

                switch(item)
                {
                    case "Logout":
                        dropDownModel.removeElement(Strings.CUR_USER);
                        dropDownModel.setSelectedItem(Strings.CUR_USER);
                        switchView(Views.LOGIN);
                        break;

                    case "Settings":
                        dropDownModel.setSelectedItem(Strings.CUR_USER);
                        switchView(Views.SETTINGS);
                        break;

                    case "My Stats":
                        dropDownModel.setSelectedItem(Strings.CUR_USER);
                        switchView(Views.USER_STATS);
                        break;

                    default:
                        dropDownModel.setSelectedItem(Strings.CUR_USER);
                        break;
                }
            }
        };
    }
}