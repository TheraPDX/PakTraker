package frames.common.panels;

/*
 * Created by Jonah on 4/30/2016.
 */

import global.Strings;
import global.Views;
import utils.datebase.LoginUtils;

import javax.swing.*;
import java.awt.*;

import static frames.MainFrame.switchView;
import static frames.common.panels.TopPanel.updateComboBox;

public class LoginPanel extends JPanel
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
            String accountType = acctTypeCb.getSelectedItem().toString();
            String username = usernameTf.getText();
            char[] password = passwordTf.getPassword();

            System.out.println(Strings.CUR_USER);
            Strings.CUR_USER = username;
            System.out.println(Strings.CUR_USER);

            if(accountType.equals("Admin") && loginUtils.correctAdminLogin(username, password))
            {
                updateComboBox(username);
                switchView(Views.ADMIN);
            }
            else if(accountType.equals("Employee") && loginUtils.correctEmployeeLogin(username, password))
            {
                switchView(Views.EMPLOYEE);
            }
            else if(accountType.equals("Customer") && loginUtils.correctCustomerLogin(username, password))
            {
                switchView(Views.CUSTOMER);
            }
            else
            {
                loginUtils.incorrectLogin(loginBtn);
            }
        });
    }

    private void addComponents()
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