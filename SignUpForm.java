import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign-Up Form");

        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");
        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JButton btnSignUp = new JButton("Sign Up");

        lblUser.setBounds(50, 50, 100, 30);
        txtUser.setBounds(150, 50, 150, 30);
        lblPass.setBounds(50, 100, 100, 30);
        txtPass.setBounds(150, 100, 150, 30);
        btnSignUp.setBounds(150, 150, 100, 30);

        frame.add(lblUser);
        frame.add(txtUser);
        frame.add(lblPass);
        frame.add(txtPass);
        frame.add(btnSignUp);

        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DBConfig.getConnection();
                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO users(username,password) VALUES(?,?)");
                    ps.setString(1, txtUser.getText());
                    ps.setString(2, new String(txtPass.getPassword()));
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "User Registered Successfully!");
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
