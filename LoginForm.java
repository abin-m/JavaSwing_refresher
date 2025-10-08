import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");

        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");
        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        lblUser.setBounds(50, 50, 100, 30);
        txtUser.setBounds(150, 50, 150, 30);
        lblPass.setBounds(50, 100, 100, 30);
        txtPass.setBounds(150, 100, 150, 30);
        btnLogin.setBounds(150, 150, 100, 30);

        frame.add(lblUser);
        frame.add(txtUser);
        frame.add(lblPass);
        frame.add(txtPass);
        frame.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DBConfig.getConnection();
                    PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM users WHERE username=? AND password=?");
                    ps.setString(1, txtUser.getText());
                    ps.setString(2, new String(txtPass.getPassword()));
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(frame, "Login Successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Credentials!");
                    }

                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
