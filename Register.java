import javax.swing.*;
import java.sql.*;
import java.awt.Frame;
import java.awt.event.*;

public class Register extends JFrame implements ActionListener {
    JLabel LFname, LMname, LLname, LDOB, LGender, LMobileNumber, LAddress, LEmail, LCoursePreference;
    JTextField TFname, TMname, TLname, TMobileNumber, TEmail, TDOB;
    JTextArea TAAddress;
    JComboBox CBGender, CBCoursePreference;
    JButton BRegister, BClear, BAdminLogin;

    public static void main(String[] args) {
        Register d = new Register();
    }

    Register() {
        setLayout(null);

        LFname = new JLabel("First Name");
        LFname.setBounds(50, 50, 100, 20);
        add(LFname);

        TFname = new JTextField();
        TFname.setBounds(170, 50, 150, 20);
        add(TFname);

        LMname = new JLabel("Middle Name");
        LMname.setBounds(50, 90, 100, 20);
        add(LMname);

        TMname = new JTextField();
        TMname.setBounds(170, 90, 150, 20);
        add(TMname);

        LLname = new JLabel("Last Name");
        LLname.setBounds(50, 130, 100, 20);
        add(LLname);

        TLname = new JTextField();
        TLname.setBounds(170, 130, 150, 20);
        add(TLname);

        LDOB = new JLabel("Birth Date");
        LDOB.setBounds(50, 170, 100, 20);
        add(LDOB);

        TDOB = new JTextField();
        TDOB.setBounds(170, 170, 150, 20);
        add(TDOB);

        LGender = new JLabel("Gender");
        LGender.setBounds(50, 210, 100, 20);
        add(LGender);

        CBGender = new JComboBox();
        CBGender.addItem("Select Gender");
        CBGender.addItem("Male");
        CBGender.addItem("Female");
        CBGender.setBounds(170, 210, 150, 20);
        add(CBGender);

        LMobileNumber = new JLabel("Mobile Number");
        LMobileNumber.setBounds(50, 250, 100, 20);
        add(LMobileNumber);

        TMobileNumber = new JTextField();
        TMobileNumber.setBounds(170, 250, 150, 20);
        add(TMobileNumber);

        LAddress = new JLabel("Address");
        LAddress.setBounds(50, 290, 100, 20);
        add(LAddress);

        TAAddress = new JTextArea(50, 50);
        TAAddress.setBounds(170, 290, 150, 100);
        add(TAAddress);

        LEmail = new JLabel("E-Mail");
        LEmail.setBounds(50, 430, 100, 20);
        add(LEmail);

        TEmail = new JTextField();
        TEmail.setBounds(170, 430, 150, 20);
        add(TEmail);

        LCoursePreference = new JLabel("Course");
        LCoursePreference.setBounds(50, 470, 100, 20);
        add(LCoursePreference);

        String[] courses = { "Select Course", "DAS In Java", "DAS In C++", "DAS In Python", "Web Development",
                "Machine Learning", "Software Testing", "Networking Basics" };
        CBCoursePreference = new JComboBox(courses);
        CBCoursePreference.setBounds(170, 470, 150, 20);
        add(CBCoursePreference);

        BRegister = new JButton("Register");
        BRegister.setBounds(50, 520, 100, 20);
        BRegister.addActionListener(this);
        add(BRegister);

        BAdminLogin = new JButton("Institute Login");
        BAdminLogin.setBounds(170, 520, 150, 20);
        BAdminLogin.addActionListener(this);
        add(BAdminLogin);

        setSize(500, 700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String FNAME = TFname.getText() + "";
        String MNAME = TMname.getText() + "";
        String LNAME = TLname.getText() + "";
        String DOB = TDOB.getText() + "";
        String GENDER = CBGender.getSelectedItem() + "";
        String NUM = TMobileNumber.getText() + "";
        String ADDRESS = TAAddress.getText() + "";
        String EMAIL = TEmail.getText() + "";
        String COURSE = CBCoursePreference.getSelectedItem() + "";

        if (e.getSource() == BRegister) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:Student_Data");
                Statement st = con.createStatement();
                String sql = "INSERT INTO Detail VALUES ('" + FNAME + "','" + MNAME + "','" + LNAME + "','" + DOB
                        + "','" + GENDER + "','" + NUM + "','" + ADDRESS + "','" + EMAIL + "','" + COURSE + "')";
                int rs = st.executeUpdate(sql);
            } catch (Exception ee) {
                System.out.println(ee);
            }

        } else if (e.getSource() == BAdminLogin) {
            dispose();
            Login l = new Login();
        }
    }
}
