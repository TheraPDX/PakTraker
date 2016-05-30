package frames.common.controllers.login;

/*
 * Created by Jonah on 5/30/2016.
 */

import frames.common.models.login.LoginModel;
import global.Strings;
import global.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static frames.MainFrame.switchView;
import static frames.common.panels.TopPanel.updateComboBox;

public class LoginController
{
    LoginModel loginModel = new LoginModel();

    JTextField textField;
    JPasswordField passwordField;
    JComboBox comboBox;
    JButton button;

    public LoginController(JTextField textField, JPasswordField passwordField, JComboBox comboBox, JButton button)
    {
        this.textField = textField;
        this.passwordField = passwordField;
        this.comboBox = comboBox;
        this.button = button;
    }

    public AbstractAction getLoginBtnAction()
    {
        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String accountType = comboBox.getSelectedItem().toString();
                String username = textField.getText();
                char[] password = passwordField.getPassword();

                Strings.CUR_USER = username;

                if(accountType.equals("Admin") && loginModel.validAdminAcct(username, password))
                {
                    updateComboBox(username);
                    switchView(Views.ADMIN);
                }
                else if(accountType.equals("Employee") && loginModel.validEmployeeAcct(username, password))
                {
                    switchView(Views.EMPLOYEE);
                }
                else if(accountType.equals("Customer") && loginModel.validCustomerAcct(username, password))
                {
                    switchView(Views.CUSTOMER);
                }
                else
                {
                    Timer switchBtnTAC = new Timer(1500, getIncorrectLoginAction());

                    switchBtnTAC.start();
                }
            }
        };
    }

    private AbstractAction getIncorrectLoginAction()
    {
        button.setText("Incorrect Login");
        button.setForeground(Color.red);

        return new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                button.setText("Login");
                button.setForeground(null);
            }
        };
    }
}