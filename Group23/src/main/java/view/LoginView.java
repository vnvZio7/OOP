package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import entity.User;

public class LoginView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JLabel title;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;
    private JButton registerBtn;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userNameLabel = new JLabel("UserName");
        passwordlabel = new JLabel("Password");
        title = new JLabel("Login Tiêm Chủng");
        Font font = new Font("Arial", Font.BOLD, 28);
        title.setFont(font);

        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();
        registerBtn = new JButton();

        loginBtn.setText("Login");
        registerBtn.setText("Register");
        loginBtn.addActionListener(this);
        registerBtn.addActionListener(this);

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(400, 300);
        panel.setLayout(layout);
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(title);
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.add(registerBtn);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, title, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, title, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 80, SpringLayout.WEST, userNameLabel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 80, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginBtn, 80, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, loginBtn, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, registerBtn, 150, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, registerBtn, 150, SpringLayout.NORTH, panel);


        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Login");
        this.setSize(400, 300);
        this.setResizable(false);
        setLocationRelativeTo(null);

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(userNameField.getText(), 
                String.copyValueOf(passwordField.getPassword()));
    }

    public void actionPerformed(ActionEvent e) {
    }
    
    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }
    public void showRegisterView(ActionListener listener) {
        registerBtn.addActionListener(listener);
    }
}