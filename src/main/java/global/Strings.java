package global;

/*
 * Created by Jonah on 4/30/2016.
 */

public class Strings
{


    public Strings()
    {

    }

    public static String Views(String name)
    {
        boolean found = false;
        String[] views = {"ADMIN", "ADMIN LOGIN"};
        String view = "Page Not Found";

        while(!found)
        {
            for(String viewName : views)
            {
                if(viewName.equals(name))
                {
                    view = name;
                    found = true;
                    break;
                }
            }
        }
        return view;
    }
}
