package utils;

/*
 * Created by Jonah on 5/3/2016.
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils
{

    public DateUtils()
    {

    }

    public int calculateAge(String date)
    {
        String[] dateComponents = date.split("-");

        int year = Integer.parseInt(dateComponents[2]);
        int month = Integer.parseInt(dateComponents[0]);
        int day = Integer.parseInt(dateComponents[1]);

        LocalDate dob = LocalDate.of(year, month, day);

        long age = dob.until(LocalDate.now(), ChronoUnit.YEARS);

        return (int) age;
    }
}
