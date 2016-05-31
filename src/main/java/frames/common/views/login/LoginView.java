package frames.common.views.login;

/*
 * Created by Jonah on 4/30/2016.
 */

import frames.common.controllers.login.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel
{
    private final JLabel usernameLbl = new JLabel("Username", SwingConstants.CENTER);
    private final JLabel passwordLbl = new JLabel("Password", SwingConstants.CENTER);
    private final JLabel acctTypeLbl = new JLabel("Account Type", SwingConstants.CENTER);

    private static final JTextField usernameTf = new JTextField("Username");
    private final JPasswordField passwordTf = new JPasswordField("Password");

    private final String[] acctTypes = {"Admin", "Employee", "Customer"};
    private final JComboBox<String> acctTypeCb = new JComboBox<>(acctTypes);
    private final JButton loginBtn = new JButton("Login");

    private final Dimension loginComponentsDimension = new Dimension(125, 30);

    private final LoginController loginController;

    public LoginView()
    {
        loginController = new LoginController(usernameTf, passwordTf, acctTypeCb, loginBtn);

        initComponents();
        addComponents();
    }

    public void initComponents()
    {
        //Username Label
        usernameLbl.setAlignmentX(CENTER_ALIGNMENT);
        usernameLbl.setMaximumSize(loginComponentsDimension);

        //Username Text Field
        usernameTf.setAlignmentX(CENTER_ALIGNMENT);
        usernameTf.setMaximumSize(loginComponentsDimension);

        //Password Label
        passwordLbl.setAlignmentX(CENTER_ALIGNMENT);
        passwordLbl.setMaximumSize(loginComponentsDimension);

        //Password Text Field
        passwordTf.setAlignmentX(CENTER_ALIGNMENT);
        passwordTf.setMaximumSize(loginComponentsDimension);

        //Account Type Label
        acctTypeLbl.setAlignmentX(CENTER_ALIGNMENT);
        acctTypeLbl.setMaximumSize(loginComponentsDimension);

        //User Type Combobox
        acctTypeCb.setAlignmentX(CENTER_ALIGNMENT);
        acctTypeCb.setMaximumSize(loginComponentsDimension);

        //Login Button
        loginBtn.setAlignmentX(CENTER_ALIGNMENT);
        loginBtn.addActionListener(loginController.getLoginBtnAction());
    }

    public void addComponents()
    {
        //This
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
        add(acctTypeLbl);
        add(Box.createVerticalStrut(5));
        add(acctTypeCb);
        add(Box.createVerticalStrut(20));
        add(loginBtn);
        add(Box.createVerticalGlue());
    }
}