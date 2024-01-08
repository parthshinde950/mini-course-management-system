import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    String username, password;
    JLabel LUsername, LPassword;
    JTextField TUsername;
    JPasswordField TPassword;
    JButton BSubmit, BRegister;

    public static void main(String[] args) {
        Login l = new Login();
    }

    Login() {
        setLayout(null);

        username = "admin";
        password = "admin";
        LUsername = new JLabel("Username");
        LUsername.setBounds(50, 50, 100, 20);
        add(LUsername);

        TUsername = new JTextField();
        TUsername.setBounds(170, 50, 100, 20);
        add(TUsername);

        LPassword = new JLabel("Password");
        LPassword.setBounds(50, 90, 100, 20);
        add(LPassword);

        TPassword = new JPasswordField();
        TPassword.setBounds(170, 90, 100, 20);
        add(TPassword);

        BSubmit = new JButton("Submit");
        BSubmit.setBounds(50, 140, 100, 20);
        BSubmit.addActionListener(this);
        add(BSubmit);

        BRegister = new JButton("Register");
        BRegister.setBounds(170, 140, 100, 20);
        BRegister.addActionListener(this);
        add(BRegister);

        setSize(400, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String u=TUsername.getText()+"";        
        String p=TPassword.getText()+"";
        if(e.getSource() == BSubmit){
            if(u.equals(username) && p.equals(password)){
                dispose();
               Data d=new Data(); 
            }
            else{
                TUsername.setText("");                
                TPassword.setText("");
                JFrame fr=new JFrame();
                JOptionPane.showMessageDialog(fr,"Wrong Password");
            }
        }
        else if(e.getSource() == BRegister){
            dispose();
            Register re= new Register();
        }
    }
}