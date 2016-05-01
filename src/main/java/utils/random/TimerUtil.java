package utils.random;

/*
 * Created by Jonah on 4/30/2016.
 */

import javax.swing.*;

public class TimerUtil
{
    public static Timer timer;

    public TimerUtil()
    {

    }

    public static void startTimer(int delay, AbstractAction action)
    {
        timer = new Timer(delay, action);
        timer.start();
    }

    public static void stopTimer()
    {
        timer.stop();
    }

}
