import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List.*;


public class Login extends JFrame implements ActionListener {

    JPanel loginPanel = new JPanel();

    DAO dao = new DAO();

    JLabel welcomeLabel = new JLabel("Welcome to Employee Register System!");
    JLabel userLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel loginLabel = new JLabel("Login as:");

    JTextField userNameText = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginButton = new JButton("LOGIN");
    String loginName[] = {"HR", "Head Of Department"};
    JComboBox loginComboBox = new JComboBox(loginName);

    protected String testAuthority = "department";

    public Login() throws FileNotFoundException {
        setLayout(null);
        loginPanel.setLayout(null);
        loginPanel.setVisible(true);

        welcomeLabel.setBounds(100, 25, 250, 30);
        userLabel.setBounds(100, 90, 100, 30);
        passwordLabel.setBounds(100, 140, 100, 30);
        loginLabel.setBounds(100, 190, 100, 30);

        userNameText.setBounds(170, 90, 150, 30);
        passwordField.setBounds(170, 140, 150, 30);
        loginComboBox.setBounds(170, 190, 150, 30);

        loginButton.setBounds(170, 250, 150, 30);
        loginButton.addActionListener(this);

        loginPanel.add(welcomeLabel);
        loginPanel.add(userLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(userNameText);
        loginPanel.add(passwordField);
        loginPanel.add(loginLabel);
        loginPanel.add(loginComboBox);
        loginPanel.add(loginButton);

        loginPanel.setBorder(BorderFactory.createEtchedBorder());
        loginPanel.setBounds(10,10, 415, 345);
        add(loginPanel);
        setTitle("Login page");
        setPreferredSize(new Dimension(450, 450));
        setBackground(Color.BLUE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (userNameText.getText().equals("hr") && passwordField.getText().equals("hr") &&
                loginComboBox.getSelectedItem().toString().equals("HR")) {
            dispose();
            try {
                new ManageDepartment();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        else if (userNameText.getText().equals("surgery") && passwordField.getText().equals("surgery") &&
                loginComboBox.getSelectedItem().toString().equals("Head Of Department")){
            dispose();
            try {
                new ManageEmployees(dao.surgeryList, "Lists/SurgeryEmployees","Surgery",testAuthority);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        else if (userNameText.getText().equals("anaesthetics") && passwordField.getText().equals("anaesthetics") &&
                loginComboBox.getSelectedItem().toString().equals("Head Of Department")){
            dispose();
            try {
                new ManageEmployees(dao.anaestheticsList, "Lists/AnaestheticsEmployees", "Anaesthetics",testAuthority);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        else if (userNameText.getText().equals("cardiology") && passwordField.getText().equals("cardiology") &&
                loginComboBox.getSelectedItem().toString().equals("Head Of Department")){
            dispose();
            try {
                new ManageEmployees(dao.cardiologyList, "Lists/CardiologyEmployees", "Cardiology",testAuthority);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        else if (userNameText.getText().equals("criticalcare") && passwordField.getText().equals("criticalcare") &&
                loginComboBox.getSelectedItem().toString().equals("Head Of Department")){
            dispose();
            try {
                new ManageEmployees(dao.criticalCareList, "Lists/CriticalCareEmployees", "Critical care",testAuthority);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Felaktlig login information");

    }

    public static void main(String[] args) throws FileNotFoundException {
        new Login();
    }

}
