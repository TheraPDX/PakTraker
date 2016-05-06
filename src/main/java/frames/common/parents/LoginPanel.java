package frames.common.parents;

/*
 * Created by Jonah on 4/30/2016.
 */

import global.Strings;
import utils.datebase.LoginUtils;

import javax.swing.*;
import java.awt.*;

import static frames.MainFrame.switchView;

public class LoginPanel extends JPanel
{
    private final JLabel usernameLbl = new JLabel("Username", SwingConstants.CENTER);
    private final JLabel passwordLbl = new JLabel("Password", SwingConstants.CENTER);
    private final JLabel acctTypeLbl = new JLabel("Account Type", SwingConstants.CENTER);

    private final JTextField usernameTf = new JTextField("Username");
    private final JPasswordField passwordTf = new JPasswordField("Password");

    private final String[] acctTypes = {"Admin", "Employee", "Customer"};
    private final JComboBox<String> acctTypeCb = new JComboBox<>(acctTypes);
    private final JButton loginBtn = new JButton("Login");

    private final Dimension loginComponentsDimension = new Dimension(125, 30);

    private final LoginUtils loginUtils = new LoginUtils();

    public LoginPanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
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
        loginBtn.addActionListener(e ->
        {
            switch(acctTypeCb.getSelectedItem().toString())
            {
                case "Admin":
                    if(loginUtils.correctAdminLogin("Jonah", new char[] {'1'}))
                        switchView(Strings.ADMIN_VIEW);
                    break;

                case "Employee":
                    if(loginUtils.correctEmployeeLogin("Jonah", new char[] {'2'}))
                        switchView(Strings.EMPLOYEE_VIEW);
                    break;

                /*Commented out to test default case (Incorrect)
                case "Customer":
                    if(loginUtils.correctCustomerLogin("Jonah", new char[] {'3'}))
                        switchView(Strings.CUSTOMER_PROFILE_VIEW);
                    break;*/

                default:
                    loginUtils.incorrectLogin(loginBtn);
                    break;
            }
        });
    }

    private void addComponents()
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
        add(acctTypeLbl);
        add(Box.createVerticalStrut(5));
        add(acctTypeCb);
        add(Box.createVerticalStrut(20));
        add(loginBtn);
        add(Box.createVerticalGlue());
    }
}