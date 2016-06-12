package frames.common.models;

/*
 * Created by Jonah on 5/31/2016.
 */

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TopPanelModel
{
    String[] dropDownContent = {"My Stats", "Settings", "Logout"};
    DefaultComboBoxModel<String> dropDownModel = new DefaultComboBoxModel<>(dropDownContent);

    DateFormat date = new SimpleDateFormat("M/dd/yy");
    DateFormat time = new SimpleDateFormat("h:mm");
    Calendar calendar;

    //String TIME = time.format(calendar.getTime());
    //String DATE = date.format(calendar.getTime());

    public TopPanelModel()
    {

    }

    public DefaultComboBoxModel<String> getDropDownModel()
    {
        return dropDownModel;
    }

    public String getTime()
    {
        calendar = Calendar.getInstance();
        return time.format(calendar.getTime());
    }

    public String getDate()
    {
        calendar = Calendar.getInstance();
        return date.format(calendar.getTime());
    }

    public String getFormattedTimeAndDate()
    {
        return "<html><div style='text-align: center;'>" + getTime() + "<br>" + getDate() + "</div></html>";
    }
}
