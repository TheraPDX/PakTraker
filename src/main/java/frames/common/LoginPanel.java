package frames.common;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.actions.TextAction;
import frames.interfaces.panels.LoginPanelI;
import global.Strings;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static frames.MainFrame.switchView;

public class LoginPanel extends JPanel implements LoginPanelI
{
    private final JLabel usernameLbl = new JLabel("Username");
    private final JLabel passwordLbl = new JLabel("Password");

    private final JTextField usernameTf = new JTextField("Username");
    private final JPasswordField passwordTf = new JPasswordField("Password");

    private final JButton loginBtn = new JButton("Login");

    private final Dimension tfDimension = new Dimension(125, 30);
    private final Dimension lblDimension = new Dimension(65, 20);

    public LoginPanel()
    {
        initComponents();
        addComponents();
    }

    @Override
    public void initComponents()
    {
        //Username Label
        usernameLbl.setAlignmentX(CENTER_ALIGNMENT);
        usernameLbl.setAlignmentY(CENTER_ALIGNMENT);
        usernameLbl.setMaximumSize(lblDimension);

        //Username Text Field
        usernameTf.setAlignmentX(CENTER_ALIGNMENT);
        usernameTf.setAlignmentY(CENTER_ALIGNMENT);
        usernameTf.setMaximumSize(tfDimension);

        //Password Label
        passwordLbl.setAlignmentX(CENTER_ALIGNMENT);
        passwordLbl.setAlignmentY(CENTER_ALIGNMENT);
        passwordLbl.setMaximumSize(lblDimension);

        //Password Text Field
        passwordTf.setAlignmentX(CENTER_ALIGNMENT);
        passwordTf.setAlignmentY(CENTER_ALIGNMENT);
        passwordTf.setMaximumSize(tfDimension);

        //Login Button
        loginBtn.setAlignmentX(CENTER_ALIGNMENT);
        loginBtn.setAlignmentY(CENTER_ALIGNMENT);
        loginBtn.addActionListener(e ->
        {
            if(correctLogin())
            {
                switchView(Strings.ADMIN_VIEW);
            }
        });
    }

    @Override
    public void addComponents()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalGlue());
        add(usernameLbl);
        add(Box.createVerticalStrut(5));
        add(usernameTf);
        add(Box.createVerticalStrut(10));
        add(passwordLbl);
        add(Box.createVerticalStrut(5));
        add(passwordTf);
        add(Box.createVerticalStrut(10));
        add(loginBtn);
        add(Box.createVerticalGlue());
    }

    @Override
    public boolean correctLogin()
    {
        char[] pass = {'1', '2', '3', '4'};

        boolean goodCredentials = usernameTf.getText().equalsIgnoreCase("Jonah") && Arrays.equals(passwordTf.getPassword(), pass);
        if(!goodCredentials)
        {
            usernameTf.setText("Username");
            passwordTf.setText("password");

            return true;
        }
        else
        {
            Timer switchBtnTAC = new Timer(1500, TextAction.btnWarningAction(loginBtn, Color.RED, "Invalid Login", "Login"));
            switchBtnTAC.start();

            return false;
        }
    }
}
